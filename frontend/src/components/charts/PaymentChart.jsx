import { useEffect, useState } from "react";
import { getPaymentAnalytics } from "../../services/dashboardService";

import {
  PieChart,
  Pie,
  Cell,
  Tooltip,
  Legend,
  ResponsiveContainer,
} from "recharts";

const COLORS = [
  "#6F4E37",
  "#A67C52",
  "#D9B382",
];

function PaymentChart() {

  const [data, setData] = useState([]);

  useEffect(() => {
    getPaymentAnalytics()
      .then((response) => {

        const formattedData = response.data.map((item) => ({
          name: item.paymentMethod,
          value: item.transactions,
        }));

        setData(formattedData);
      })
      .catch((error) => {
        console.error("Error fetching payment analytics:", error);
      });
  }, []);

  return (
    <div className="bg-white rounded-xl shadow-sm p-6">

      <h2 className="text-xl font-semibold text-[#4E342E] mb-6">
        Payment Analytics
      </h2>

      <ResponsiveContainer width="100%" height={300}>

        <PieChart>

          <Pie
            data={data}
            dataKey="value"
            nameKey="name"
            outerRadius={100}
            label
          >

            {data.map((entry, index) => (
              <Cell
                key={index}
                fill={COLORS[index % COLORS.length]}
              />
            ))}

          </Pie>

          <Tooltip />

          <Legend />

        </PieChart>

      </ResponsiveContainer>

    </div>
  );
}

export default PaymentChart;