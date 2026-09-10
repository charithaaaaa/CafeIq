import { useEffect, useState } from "react";
import { getMenuItems } from "../../services/menuService";
import { addSale } from "../../services/salesService";
import toast from "react-hot-toast";

function SalesForm({ onSaleComplete }) {

  const [menuItems, setMenuItems] = useState([]);

  const [selectedItem, setSelectedItem] = useState("");

  const [quantity, setQuantity] = useState(1);

  const [paymentMethod, setPaymentMethod] = useState("UPI");

  // Fetch Menu Items
  useEffect(() => {

    getMenuItems()
      .then((response) => {

        setMenuItems(response.data);

      })
      .catch((error) => {

        console.error(error);

      });

  }, []);

  // Selected Menu
  const selectedMenu = menuItems.find(
    item => item.itemId == selectedItem
  );

  // Estimated Total
  const estimatedTotal = selectedMenu
    ? selectedMenu.sellingPrice * quantity
    : 0;

  // Submit Sale
  const handleSubmit = () => {

    if (!selectedItem) {
      toast.error("Please select a menu item.");
      return;
    }

    const sale = {

      itemId: Number(selectedItem),

      quantity: Number(quantity),

      paymentMethod,

    };

    addSale(sale)
      .then(() => {

  toast.success("Sale completed successfully!");

  setSelectedItem("");
  setQuantity(1);
  setPaymentMethod("UPI");

  onSaleComplete();

})
      .catch((error) => {

  console.error(error);

  if (error.response?.data?.message) {

    toast.error(error.response.data.message);

  } else {

    toast.error("Failed to complete sale.");

  }

});
  };

  return (

    <div className="bg-white rounded-xl shadow-sm p-6">

      <h2 className="text-2xl font-semibold text-[#4E342E] mb-6">
        Complete Sale
      </h2>

      <div className="space-y-5">

        {/* Menu */}

        <div>

          <label className="block mb-2 font-medium">
            Menu Item
          </label>

          <select
            value={selectedItem}
            onChange={(e) => setSelectedItem(e.target.value)}
            className="w-full border rounded-lg p-3"
          >

            <option value="">
              Select Menu Item
            </option>

            {menuItems.map((item) => (

              <option
                key={item.itemId}
                value={item.itemId}
              >
                {item.itemName} (₹{item.sellingPrice})
              </option>

            ))}

          </select>

        </div>

        {/* Quantity */}

        <div>

          <label className="block mb-2 font-medium">
            Quantity
          </label>

          <input
            type="number"
            min="1"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
            className="w-full border rounded-lg p-3"
          />

        </div>

        {/* Payment */}

        <div>

          <label className="block mb-2 font-medium">
            Payment Method
          </label>

          <select
            value={paymentMethod}
            onChange={(e) => setPaymentMethod(e.target.value)}
            className="w-full border rounded-lg p-3"
          >

            <option value="UPI">UPI</option>
            <option value="Cash">Cash</option>
            <option value="Card">Card</option>

          </select>

        </div>

        {/* Estimated Total */}

        <div className="bg-[#F6F1EB] rounded-lg p-4">

          <span className="text-gray-600">
            Estimated Total
          </span>

          <h2 className="text-3xl font-bold text-[#4E342E]">

            ₹{estimatedTotal.toFixed(2)}

          </h2>

        </div>

        {/* Button */}

        <button
          onClick={handleSubmit}
          className="w-full bg-[#6F4E37] text-white py-3 rounded-lg hover:bg-[#5A3E2B]"
        >
          Complete Sale
        </button>

      </div>

    </div>

  );

}

export default SalesForm;