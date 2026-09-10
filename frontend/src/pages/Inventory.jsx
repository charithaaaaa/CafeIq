import { useEffect, useState } from "react";

import Sidebar from "../components/layout/Sidebar";
import Header from "../components/layout/Header";

import {
  getInventory,
  updateInventory,
} from "../services/inventoryService";

import UpdateInventoryModal from "../components/modals/UpdateInventoryModal";

import toast from "react-hot-toast";

function Inventory() {

  const [inventory, setInventory] = useState([]);

  const [selectedItem, setSelectedItem] = useState(null);

  const [isModalOpen, setIsModalOpen] = useState(false);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortBy, setSortBy] = useState("nameAsc");
  const totalItems = inventory.length;

const inStock = inventory.filter(
  (item) => item.currentStock > item.minimumStock
).length;

const lowStock = inventory.filter(
  (item) =>
    item.currentStock > 0 &&
    item.currentStock <= item.minimumStock
).length;

const outOfStock = inventory.filter(
  (item) => item.currentStock === 0
).length;

  // -------------------------
  // Fetch Inventory
  // -------------------------

  const fetchInventory = () => {

    getInventory()

      .then((response) => {

        setInventory(response.data);

      })

      .catch((error) => {

        console.error(error);

        toast.error("Failed to load inventory.");

      });

  };

  useEffect(() => {

    fetchInventory();

  }, []);

  // -------------------------
  // Edit
  // -------------------------

  const handleEdit = (item) => {

    setSelectedItem(item);

    setIsModalOpen(true);

  };

  // -------------------------
  // Save
  // -------------------------

  const handleSave = (updatedData) => {

    updateInventory(selectedItem.inventoryId, updatedData)

      .then(() => {

        toast.success("Inventory updated successfully!");

        fetchInventory();

        setIsModalOpen(false);

        setSelectedItem(null);

      })

      .catch((error) => {

        console.error(error);

        toast.error("Failed to update inventory.");

      });

  };

  return (

    <div className="bg-[#F6F1EB] min-h-screen">

      <Sidebar />

      <main className="ml-72 p-10">

        <Header />

        <div className="flex justify-between items-center mt-8 mb-6">

          <h1 className="text-4xl font-bold text-[#4E342E]">

            Inventory Management

          </h1>

        </div>
        <div className="grid grid-cols-4 gap-6 mb-6">

  <div className="bg-white rounded-xl shadow p-5">
    <p className="text-gray-500 text-sm">Total Items</p>
    <h2 className="text-3xl font-bold text-[#4E342E]">
      {totalItems}
    </h2>
  </div>

  <div className="bg-green-100 rounded-xl shadow p-5">
    <p className="text-green-700 text-sm">In Stock</p>
    <h2 className="text-3xl font-bold text-green-700">
      {inStock}
    </h2>
  </div>

  <div className="bg-yellow-100 rounded-xl shadow p-5">
    <p className="text-yellow-700 text-sm">Low Stock</p>
    <h2 className="text-3xl font-bold text-yellow-700">
      {lowStock}
    </h2>
  </div>

  <div className="bg-red-100 rounded-xl shadow p-5">
    <p className="text-red-700 text-sm">Out of Stock</p>
    <h2 className="text-3xl font-bold text-red-700">
      {outOfStock}
    </h2>
  </div>

</div>

       
<div className="flex justify-between items-center mb-4">

  <input
    type="text"
    placeholder="🔍 Search inventory..."
    value={searchTerm}
    onChange={(e) => setSearchTerm(e.target.value)}
    className="border rounded-lg px-4 py-2 w-72 focus:outline-none focus:ring-2 focus:ring-[#6F4E37]"
  />

  <select
    value={sortBy}
    onChange={(e) => setSortBy(e.target.value)}
    className="border rounded-lg px-4 py-2 focus:outline-none focus:ring-2 focus:ring-[#6F4E37]"
  >
    <option value="nameAsc">Name (A-Z)</option>
    <option value="nameDesc">Name (Z-A)</option>
    <option value="stockHigh">Stock (High → Low)</option>
    <option value="stockLow">Stock (Low → High)</option>
    <option value="updated">Last Updated</option>
  </select>

</div>

  <div className="bg-white rounded-xl shadow-sm p-6 overflow-x-auto">

          <table className="w-full">

            <thead>

              <tr className="border-b">

                <th className="text-left py-3">
                  Item
                </th>

                <th className="text-center py-3">
                  Current Stock
                </th>

                <th className="text-center py-3">
                  Minimum Stock
                </th>

                <th className="text-center py-3">
                  Last Updated
                </th>

                <th className="text-center py-3">
                  Status
                </th>

                <th className="text-center py-3">
                  Action
                </th>

              </tr>

            </thead>

            <tbody>

             {inventory
  .filter((item) =>
    item.itemName
      .toLowerCase()
      .includes(searchTerm.toLowerCase())
  )
  .sort((a, b) => {
    switch (sortBy) {
      case "nameAsc":
        return a.itemName.localeCompare(b.itemName);

      case "nameDesc":
        return b.itemName.localeCompare(a.itemName);

      case "stockHigh":
        return b.currentStock - a.currentStock;

      case "stockLow":
        return a.currentStock - b.currentStock;

      case "updated":
        return new Date(b.lastUpdated) - new Date(a.lastUpdated);

      default:
        return 0;

        
    }
  })
  .map((item) => (

               <tr
  key={item.inventoryId}
  className={`border-b hover:shadow-md transition duration-200 ${
    item.currentStock === 0
      ? "bg-red-50"
      : item.currentStock <= item.minimumStock
      ? "bg-yellow-50"
      : "bg-green-50"
  }`}
>

                  <td className="py-3">
                    {item.itemName}
                  </td>

                  <td className="text-center">
                    {item.currentStock}
                  </td>

                  <td className="text-center">
                    {item.minimumStock}
                  </td>

                  {/* Last Updated */}
                  <td className="text-center text-sm">

                    {new Date(item.lastUpdated).toLocaleString("en-IN", {

                      day: "2-digit",

                      month: "short",

                      year: "numeric",

                      hour: "2-digit",

                      minute: "2-digit",

                    })}

                  </td>

                  {/* Status */}
                  <td className="text-center">

                    {item.currentStock === 0 ? (

                     <span className="bg-red-100 text-yellow-700 px-3 py-1 rounded-full text-sm font-semibold">
    Out of Stock
</span>

                    ) : item.currentStock <= item.minimumStock ? (

                      <span className="bg-yellow-100 text-green-700 px-3 py-1 rounded-full text-sm font-semibold">
    Low Stock
</span>

                    ) : (

                     <span className="bg-green-100 text-green-700 px-3 py-1 rounded-full text-sm font-semibold">
    In Stock
</span>

                    )}

                  </td>

                  {/* Edit */}
                  <td className="text-center">

                    <button

                      onClick={() => handleEdit(item)}

                      className="bg-[#6F4E37] hover:bg-[#5A3D2B] text-white px-3 py-1 rounded hover:bg-blue-600"

                    >

                      Edit

                    </button>

                  </td>

                </tr>

              ))}

            </tbody>

          </table>

        </div>
          

      </main>

      <UpdateInventoryModal

        isOpen={isModalOpen}

        inventory={selectedItem}

        onClose={() => {

          setIsModalOpen(false);

          setSelectedItem(null);

        }}

        onSave={handleSave}

      />

    </div>

  );

}

export default Inventory;