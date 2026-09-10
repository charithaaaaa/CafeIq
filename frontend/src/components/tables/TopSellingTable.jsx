import { useEffect, useState } from "react";
import { getTopSellingItems } from "../../services/dashboardService";

function TopSellingTable() {

  const [items, setItems] = useState([]);

  useEffect(() => {

    getTopSellingItems()
      .then((response) => {
        setItems(response.data);
      })
      .catch((error) => {
        console.error("Error fetching top selling items:", error);
      });

  }, []);

  return (
    <div className="bg-white rounded-xl shadow-sm p-6">

      <h2 className="text-xl font-semibold text-[#4E342E] mb-5">
        Top Selling Items
      </h2>

      <table className="w-full">

        <thead>

          <tr className="border-b">

            <th className="text-left py-3">
              Item
            </th>

            <th className="text-right py-3">
              Quantity Sold
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

              <td className="text-right font-semibold">
                {item.quantitySold}
              </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  );
}

export default TopSellingTable;