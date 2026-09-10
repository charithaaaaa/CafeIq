import { useEffect, useState } from "react";

import {
  getMenuItems,
  addMenuItem,
  updateMenuItem,
  deleteMenuItem,
} from "../services/menuService";

import Sidebar from "../components/layout/Sidebar";
import Header from "../components/layout/Header";

import DeleteConfirmationModal from "../components/modals/DeleteConfirmationModal";
import AddEditMenuModal from "../components/modals/AddEditMenuModal";

function Menu() {

  const [menuItems, setMenuItems] = useState([]);

  // Delete Modal
  const [isDeleteModalOpen, setIsDeleteModalOpen] = useState(false);
  const [selectedItem, setSelectedItem] = useState(null);

  // Add / Edit Modal
  const [isAddEditModalOpen, setIsAddEditModalOpen] = useState(false);
  const [editingItem, setEditingItem] = useState(null);

  // Fetch Menu Items
  const fetchMenuItems = () => {

    getMenuItems()
      .then((response) => {

        setMenuItems(response.data);

      })
      .catch((error) => {

        console.error(error);

      });

  };

  useEffect(() => {

    fetchMenuItems();

  }, []);

  // -----------------------
  // DELETE
  // -----------------------

  const handleDeleteClick = (item) => {

    setSelectedItem(item);

    setIsDeleteModalOpen(true);

  };

  const handleConfirmDelete = () => {

    deleteMenuItem(selectedItem.itemId)

      .then(() => {

        fetchMenuItems();

        setIsDeleteModalOpen(false);

        setSelectedItem(null);

      })

      .catch((error) => {

        console.error(error);

      });

  };

  // -----------------------
  // ADD
  // -----------------------

  const handleAddClick = () => {

    setEditingItem(null);

    setIsAddEditModalOpen(true);

  };

  // -----------------------
  // EDIT
  // -----------------------

  const handleEditClick = (item) => {

    setEditingItem(item);

    setIsAddEditModalOpen(true);

  };

  // -----------------------
  // SAVE
  // -----------------------

  const handleSave = (menuData) => {

    const payload = {

      

      itemName: menuData.itemName,

      category: {
        categoryId: Number(menuData.categoryId),
      },

      sellingPrice: Number(menuData.sellingPrice),

      costPrice: Number(menuData.costPrice),

    };

    if (editingItem) {

      updateMenuItem(editingItem.itemId, payload)

        .then(() => {

          fetchMenuItems();

          setIsAddEditModalOpen(false);

          setEditingItem(null);

        })

        .catch((error) => {

          console.error(error);

        });

    } else {

      addMenuItem(payload)

        .then(() => {

          fetchMenuItems();

          setIsAddEditModalOpen(false);

        })

        .catch((error) => {

          console.error(error);

        });

    }

  };

  return (

    <div className="bg-[#F6F1EB] min-h-screen">

      <Sidebar />

      <main className="ml-72 p-10">

        <Header />

        <div className="flex justify-between items-center mt-8 mb-6">

          <h1 className="text-4xl font-bold text-[#4E342E]">

            Menu Management

          </h1>

          <button

            onClick={handleAddClick}

            className="bg-[#6F4E37] text-white px-5 py-3 rounded-lg hover:bg-[#5A3E2B]"

          >

            + Add Item

          </button>

        </div>

        <div className="bg-white rounded-xl shadow-sm p-6">

          <table className="w-full">

            <thead>

              <tr className="border-b">

                <th className="text-left py-3">Item Name</th>

                <th className="text-left py-3">Category</th>

                <th className="text-center py-3">Selling Price</th>

                <th className="text-center py-3">Cost Price</th>

                <th className="text-center py-3">Actions</th>

              </tr>

            </thead>

            <tbody>

              {menuItems.map((item) => (

                <tr

                  key={item.itemId}

                  className="border-b hover:bg-gray-50"

                >

                  <td className="py-3">

                    {item.itemName}

                  </td>

                  <td>

                    {item.categoryName}

                  </td>

                  <td className="text-center">

                    ₹{item.sellingPrice}

                  </td>

                  <td className="text-center">

                    ₹{item.costPrice}

                  </td>

                  <td className="text-center">
                                        <button
                      onClick={() => handleEditClick(item)}
                      className="bg-blue-500 text-white px-3 py-1 rounded mr-2 hover:bg-blue-600"
                    >
                      Edit
                    </button>

                    <button
                      onClick={() => handleDeleteClick(item)}
                      className="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-600"
                    >
                      Delete
                    </button>

                  </td>

                </tr>

              ))}

            </tbody>

          </table>

        </div>

      </main>

      {/* Delete Confirmation Modal */}
      <DeleteConfirmationModal
        isOpen={isDeleteModalOpen}
        itemName={selectedItem?.itemName}
        onClose={() => {
          setIsDeleteModalOpen(false);
          setSelectedItem(null);
        }}
        onConfirm={handleConfirmDelete}
      />

      {/* Add / Edit Modal */}
      <AddEditMenuModal
        isOpen={isAddEditModalOpen}
        menuItem={editingItem}
        onClose={() => {
          setIsAddEditModalOpen(false);
          setEditingItem(null);
        }}
        onSave={handleSave}
      />

    </div>

  );

}

export default Menu;