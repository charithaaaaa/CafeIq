function SalesTable({ sales }) {

  return (

    <div className="bg-white rounded-xl shadow-sm p-6">

      <h2 className="text-2xl font-semibold text-[#4E342E] mb-6">

        Today's Sales

      </h2>

      <table className="w-full">

        <thead>

          <tr className="border-b">

            <th className="text-left py-3">Item</th>

            <th className="text-center py-3">Quantity</th>

            <th className="text-center py-3">Payment</th>

            <th className="text-center py-3">Amount</th>

            <th className="text-right py-3">Time</th>

          </tr>

        </thead>

        <tbody>

          {sales.length === 0 ? (

            <tr>

              <td
                colSpan="5"
                className="text-center py-6 text-gray-500"
              >

                No Sales Found

              </td>

            </tr>

          ) : (

            sales.map((sale) => (

              <tr
                key={sale.saleId}
                className="border-b hover:bg-gray-50"
              >

                <td className="py-3">

                  {sale.itemName}

                </td>

                <td className="text-center">

                  {sale.quantity}

                </td>

                <td className="text-center">

                  {sale.paymentMethod}

                </td>

                <td className="text-center">

                  ₹{sale.totalAmount}

                </td>

                <td className="text-right">

                  {new Date(sale.saleDate).toLocaleTimeString([], {
                    hour: "2-digit",
                    minute: "2-digit",
                  })}

                </td>

              </tr>

            ))

          )}

        </tbody>

      </table>

    </div>

  );

}

export default SalesTable;