import { useEffect, useState } from "react";
import { getCategoryRevenue } from "../../services/dashboardService";

import {
  BarChart,
  Bar,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
} from "recharts";

function CategoryChart() {

  const [data, setData] = useState([]);

  useEffect(() => {

    getCategoryRevenue()
      .then((response) => {

        const formattedData = response.data.map((item) => ({
          category: item.categoryName,
          revenue: item.revenue,
        }));

        setData(formattedData);

      })
      .catch((error) => {
        console.error("Error fetching category revenue:", error);
      });

  }, []);

  return (
    <div className="bg-white rounded-xl shadow-sm p-6">

      <h2 className="text-xl font-semibold text-[#4E342E] mb-6">
        Category Revenue
      </h2>

      <ResponsiveContainer width="100%" height={300}>

        <BarChart data={data}>

          <XAxis dataKey="category" />

          <YAxis />

          <Tooltip />

          <Bar
            dataKey="revenue"
            fill="#6F4E37"
            radius={[8, 8, 0, 0]}
          />

        </BarChart>

      </ResponsiveContainer>

    </div>
  );
}

export default CategoryChart;