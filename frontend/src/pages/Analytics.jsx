import { useEffect, useState } from "react";
import Sidebar from "../components/layout/Sidebar";
import Header from "../components/layout/Header";
import {
  getAnalyticsSummary,
  getRevenueTrend,
  getTopSellingItems,
  getCategoryRevenue,
} from "../services/analyticsService";
import toast from "react-hot-toast";

import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  Tooltip,
  CartesianGrid,
  ResponsiveContainer,
  PieChart,
  Pie,
  Cell,
  Legend,
} from "recharts";

function Analytics() {
  const [summary, setSummary] = useState({
    totalRevenue: 0,
    totalOrders: 0,
    totalItemsSold: 0,
    bestSellingItem: "",
  });

  const [revenueTrend, setRevenueTrend] = useState([]);
  const [topItems, setTopItems] = useState([]);
  const [categoryRevenue, setCategoryRevenue] = useState([]);

  useEffect(() => {
    // Summary
    getAnalyticsSummary()
      .then((response) => {
        setSummary(response.data);
      })
      .catch((error) => {
        console.error(error);
        toast.error("Failed to load analytics.");
      });

    // Revenue Trend
    getRevenueTrend()
      .then((response) => {
        setRevenueTrend(response.data);
      })
      .catch((error) => {
        console.error(error);
        toast.error("Failed to load revenue trend.");
      });

    // Top Selling Items
    getTopSellingItems()
      .then((response) => {
        setTopItems(response.data);
      })
      .catch((error) => {
        console.error(error);
        toast.error("Failed to load top selling items.");
      });

  }, []);
  getCategoryRevenue()
  .then((response) => {
    setCategoryRevenue(response.data);
  })
  .catch((error) => {
    console.error(error);
    toast.error("Failed to load category revenue.");
  });
  const COLORS = [
  "#6F4E37",
  "#A67C52",
  "#D9A066",
  "#8D6E63",
  "#C19A6B",
  "#FFB74D",
];

  return (
    <div className="bg-[#F6F1EB] min-h-screen">
      <Sidebar />

      <main className="ml-72 p-10">
        <Header />

        <h1 className="text-4xl font-bold text-[#4E342E] mb-8">
          Analytics
        </h1>

        {/* Summary Cards */}
        <div className="grid grid-cols-4 gap-6">

          <div className="bg-white rounded-xl shadow p-6">
            <p className="text-gray-500">Total Revenue</p>
            <h2 className="text-3xl font-bold text-green-600 mt-2">
              ₹{summary.totalRevenue.toFixed(2)}
            </h2>
          </div>

          <div className="bg-white rounded-xl shadow p-6">
            <p className="text-gray-500">Total Orders</p>
            <h2 className="text-3xl font-bold text-blue-600 mt-2">
              {summary.totalOrders}
            </h2>
          </div>

          <div className="bg-white rounded-xl shadow p-6">
            <p className="text-gray-500">Items Sold</p>
            <h2 className="text-3xl font-bold text-orange-600 mt-2">
              {summary.totalItemsSold}
            </h2>
          </div>

          <div className="bg-white rounded-xl shadow p-6">
            <p className="text-gray-500">Best Seller</p>
            <h2 className="text-2xl font-bold text-[#6F4E37] mt-2">
              {summary.bestSellingItem}
            </h2>
          </div>

        </div>

        {/* Revenue Trend */}
        <div className="bg-white rounded-xl shadow p-6 mt-8">

          <h2 className="text-2xl font-bold text-[#4E342E] mb-6">
            Revenue Trend
          </h2>

          <ResponsiveContainer width="100%" height={350}>
            <LineChart data={revenueTrend}>
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="date" />
              <YAxis />
              <Tooltip />
              <Line
                type="monotone"
                dataKey="revenue"
                stroke="#6F4E37"
                strokeWidth={3}
              />
            </LineChart>
          </ResponsiveContainer>

        </div>

       

        {/* Top Selling Items */}
       <div className="grid grid-cols-2 gap-8 mt-8">

  {/* Top Selling Items */}
  <div className="bg-white rounded-xl shadow p-6">

    <h2 className="text-2xl font-bold text-[#4E342E] mb-6">
      Top Selling Items
    </h2>

    <table className="w-full">

      <thead>
        <tr className="border-b">
          <th className="text-left py-3">Rank</th>
          <th className="text-left py-3">Item</th>
          <th className="text-center py-3">Quantity Sold</th>
        </tr>
      </thead>

      <tbody>

        {topItems.map((item, index) => (

          <tr key={index} className="border-b hover:bg-gray-50">

            <td className="py-3">
              #{index + 1}
            </td>

            <td>
              {item.itemName}
            </td>

            <td className="text-center">
              {item.quantitySold}
            </td>

          </tr>

        ))}

      </tbody>

    </table>

  </div>

  {/* Category-wise Sales */}
  <div className="bg-white rounded-xl shadow p-6">

    <h2 className="text-2xl font-bold text-[#4E342E] mb-6">
      Category-wise Sales
    </h2>
    

    <ResponsiveContainer width="100%" height={450}>
      <PieChart>
     <Pie
  data={categoryRevenue}
  dataKey="revenue"
  nameKey="categoryName"
  cx="50%"
  cy="50%"
  outerRadius={125}
  label={({ categoryName, percent }) =>
    `${categoryName} ${(percent * 100).toFixed(0)}%`
  }
>
  {categoryRevenue.map((entry, index) => (
    <Cell
      key={index}
      fill={COLORS[index % COLORS.length]}
    />
  ))}
</Pie>

<Tooltip
  formatter={(value) => [`₹${Number(value).toLocaleString()}`, "Revenue"]}
/>

<Legend
  verticalAlign="bottom"
  iconType="circle"
/>

      </PieChart>
    </ResponsiveContainer>

  </div>

</div>
        

      </main>
    </div>
  );
}

export default Analytics;