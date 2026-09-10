import { useEffect, useState } from "react";
import { getLowStockItems } from "../../services/dashboardService";

function LowStockTable() {

  const [items, setItems] = useState([]);

  useEffect(() => {

    getLowStockItems()
      .then((response) => {
        setItems(response.data);
      })
      .catch((error) => {
        console.error("Error fetching low stock items:", error);
      });

  }, []);

  return (
    <div className="bg-white rounded-xl shadow-sm p-6">

      <h2 className="text-xl font-semibold text-[#4E342E] mb-5">
        Low Stock Alerts
      </h2>

      <table className="w-full">

        <thead>

          <tr className="border-b">

            <th className="text-left py-3">
              Item
            </th>

            <th className="text-center py-3">
              Current
            </th>

            <th className="text-center py-3">
              Minimum
            </th>

          </tr>

        </thead>

        <tbody>

          {items.map((item, index) => (

            <tr
              key={index}
              className="border-b hover:bg-gray-50"
            >

              <td className="py-3">
                {item.itemName}
              </td>

              <td className="text-center text-red-600 font-semibold">
                {item.currentStock}
              </td>

              <td className="text-center">
                {item.minimumStock}
              </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  );
}

export default LowStockTable;