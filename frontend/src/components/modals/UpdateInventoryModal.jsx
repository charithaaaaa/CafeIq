import { useEffect, useState } from "react";

function UpdateInventoryModal({
  isOpen,
  inventory,
  onClose,
  onSave,
}) {

  const [currentStock, setCurrentStock] = useState("");
  const [minimumStock, setMinimumStock] = useState("");

  useEffect(() => {
    if (inventory) {
      setCurrentStock(inventory.currentStock);
      setMinimumStock(inventory.minimumStock);
    }
  }, [inventory]);

  if (!isOpen) return null;

  const handleSave = () => {
    onSave({
      itemId: inventory.itemId,
      currentStock: Number(currentStock),
      minimumStock: Number(minimumStock),
    });
  };

  return (
    <div className="fixed inset-0 bg-black/40 flex items-center justify-center z-50">

      <div className="bg-white rounded-xl shadow-lg w-[450px] p-8">

        <h2 className="text-3xl font-bold text-[#4E342E] mb-6">
          Update Inventory
        </h2>

        <div className="mb-5">
          <label className="block mb-2 font-medium">
            Item
          </label>

          <input
            type="text"
            value={inventory.itemName}
            disabled
            className="w-full border rounded-lg p-3 bg-gray-100"
          />
        </div>

        <div className="mb-5">
          <label className="block mb-2 font-medium">
            Current Stock
          </label>

          <input
            type="number"
            min="0"
            value={currentStock}
            onChange={(e) => setCurrentStock(e.target.value)}
            className="w-full border rounded-lg p-3"
          />
        </div>

        <div className="mb-6">
          <label className="block mb-2 font-medium">
            Minimum Stock
          </label>

          <input
            type="number"
            min="0"
            value={minimumStock}
            onChange={(e) => setMinimumStock(e.target.value)}
            className="w-full border rounded-lg p-3"
          />
        </div>

        <div className="flex justify-end gap-3">

          <button
            onClick={onClose}
            className="border px-5 py-2 rounded-lg hover:bg-gray-100"
          >
            Cancel
          </button>

          <button
            onClick={handleSave}
            className="bg-[#6F4E37] text-white px-5 py-2 rounded-lg hover:bg-[#5A3E2B]"
          >
            Save
          </button>

        </div>

      </div>

    </div>
  );
}

export default UpdateInventoryModal;