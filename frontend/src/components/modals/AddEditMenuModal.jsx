import { useEffect, useState } from "react";

function AddEditMenuModal({
  isOpen,
  onClose,
  onSave,
  menuItem,
}) {

  const [formData, setFormData] = useState({
    itemName: "",
    categoryId: "",
    sellingPrice: "",
    costPrice: "",
  });

  useEffect(() => {

    if (menuItem) {

      setFormData({
        itemName: menuItem.itemName,
        categoryId: menuItem.categoryId,
        sellingPrice: menuItem.sellingPrice,
        costPrice: menuItem.costPrice,
      });

    } else {

      setFormData({
        itemName: "",
        categoryId: "",
        sellingPrice: "",
        costPrice: "",
      });

    }

  }, [menuItem]);

  if (!isOpen) return null;

  const handleChange = (e) => {

    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });

  };

  const handleSubmit = () => {

    if (
      !formData.itemName ||
      !formData.categoryId ||
      !formData.sellingPrice ||
      !formData.costPrice
    ) {
      alert("Please fill all fields.");
      return;
    }

    onSave(formData);

  };

  return (

    <div className="fixed inset-0 bg-black/40 flex justify-center items-center z-50">

      <div className="bg-white rounded-xl w-[500px] p-8 shadow-xl">

        <h2 className="text-3xl font-bold text-[#4E342E] mb-6">

          {menuItem ? "Edit Menu Item" : "Add Menu Item"}

        </h2>

        <div className="space-y-4">

          <input
            type="text"
            name="itemName"
            placeholder="Item Name"
            value={formData.itemName}
            onChange={handleChange}
            className="w-full border rounded-lg p-3"
          />

          <select
            name="categoryId"
            value={formData.categoryId}
            onChange={handleChange}
            className="w-full border rounded-lg p-3"
          >
            <option value="">Select Category</option>
            <option value="1">Coffee</option>
            <option value="2">Tea</option>
            <option value="3">Cold Coffee</option>
            <option value="4">Desserts</option>
            <option value="5">Snacks</option>
          </select>

          <input
            type="number"
            name="sellingPrice"
            placeholder="Selling Price"
            value={formData.sellingPrice}
            onChange={handleChange}
            className="w-full border rounded-lg p-3"
          />

          <input
            type="number"
            name="costPrice"
            placeholder="Cost Price"
            value={formData.costPrice}
            onChange={handleChange}
            className="w-full border rounded-lg p-3"
          />

        </div>

        <div className="flex justify-end gap-3 mt-8">

          <button
            onClick={onClose}
            className="px-5 py-2 rounded-lg border hover:bg-gray-100"
          >
            Cancel
          </button>

          <button
            onClick={handleSubmit}
            className="bg-[#6F4E37] text-white px-5 py-2 rounded-lg hover:bg-[#5A3E2B]"
          >
            {menuItem ? "Update" : "Save"}
          </button>

        </div>

      </div>

    </div>

  );

}

export default AddEditMenuModal;