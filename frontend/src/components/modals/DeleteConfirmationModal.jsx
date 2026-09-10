function DeleteConfirmationModal({
  isOpen,
  onClose,
  onConfirm,
  itemName,
}) {

  if (!isOpen) return null;

  return (

    <div className="fixed inset-0 bg-black/50 flex items-center justify-center z-50">

      <div className="bg-white rounded-xl shadow-xl w-[420px] p-6">

        <h2 className="text-2xl font-bold text-[#4E342E] mb-4">
          Delete Menu Item
        </h2>

        <p className="text-gray-700 mb-2">
          Are you sure you want to delete
        </p>

        <p className="font-semibold text-lg text-[#6F4E37] mb-6">
          "{itemName}" ?
        </p>

        <p className="text-red-500 text-sm mb-6">
          This action cannot be undone.
        </p>

        <div className="flex justify-end gap-3">

          <button
            onClick={onClose}
            className="px-5 py-2 rounded-lg border border-gray-300 hover:bg-gray-100"
          >
            Cancel
          </button>

          <button
            onClick={onConfirm}
            className="px-5 py-2 rounded-lg bg-red-600 text-white hover:bg-red-700"
          >
            Delete
          </button>

        </div>

      </div>

    </div>

  );
}

export default DeleteConfirmationModal;