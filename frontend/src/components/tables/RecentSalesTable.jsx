import { useEffect, useState } from "react";
import { getRecentSales } from "../../services/dashboardService";

function RecentSalesTable() {

  const [sales, setSales] = useState([]);

  useEffect(() => {

    getRecentSales()
      .then((response) => {
        setSales(response.data);
      })
      .catch((error) => {
        console.error("Error fetching recent sales:", error);
      });

  }, []);

  return (
    <div className="bg-white rounded-xl shadow-sm p-6">

      <h2 className="text-xl font-semibold text-[#4E342E] mb-5">
        Recent Sales
      </h2>

      <table className="w-full">

        <thead>

          <tr className="border-b">

            <th className="text-left py-3">Time</th>
            <th className="text-left py-3">Item</th>
            <th className="text-center py-3">Qty</th>
            <th className="text-center py-3">Payment</th>
            <th className="text-right py-3">Amount</th>

          </tr>

        </thead>

        <tbody>

          {sales.map((sale, index) => (

            <tr
              key={index}
              className="border-b hover:bg-gray-50"
            >

              <td className="py-3">
                {new Date(sale.saleDate).toLocaleTimeString([], {
                  hour: "2-digit",
                  minute: "2-digit",
                })}
              </td>

              <td>{sale.itemName}</td>

              <td className="text-center">
                {sale.quantity}
              </td>

              <td className="text-center">
                {sale.paymentMethod}
              </td>

              <td className="text-right font-semibold">
                ₹{sale.totalAmount.toFixed(2)}
              </td>

            </tr>

          ))}

        </tbody>

      </table>

    </div>
  );
}

export default RecentSalesTable;