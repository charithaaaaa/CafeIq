import { useEffect, useState } from "react";
import { getTodaySummary } from "../services/dashboardService";


import Sidebar from "../components/layout/Sidebar";
import Header from "../components/layout/Header";

import KpiCard from "../components/cards/KpiCard";

import RevenueChart from "../components/charts/RevenueChart";
import PaymentChart from "../components/charts/PaymentChart";
import CategoryChart from "../components/charts/CategoryChart";

import TopSellingTable from "../components/tables/TopSellingTable";
import LowStockTable from "../components/tables/LowStockTable";
import RecentSalesTable from "../components/tables/RecentSalesTable";

function Dashboard() {
  const [summary, setSummary] = useState({
  totalRevenue: 0,
  totalOrders: 0,
  averageOrderValue: 0,
  totalItemsSold: 0,
});

useEffect(() => {
  getTodaySummary()
    .then((response) => {
      setSummary(response.data);
    })
    .catch((error) => {
      console.error("Error fetching dashboard summary:", error);
    });
}, []);



  return (
    <div className="bg-[#F6F1EB] min-h-screen">

      {/* Fixed Sidebar */}
      <Sidebar />

      {/* Main Content */}
      <main className="ml-72 p-10">

        {/* Header */}
        <Header />

        {/* KPI Cards */}
        <KpiCard
  title="Today's Revenue"
  value={`₹${summary.totalRevenue.toFixed(2)}`}
/>

<KpiCard
  title="Today's Orders"
  value={summary.totalOrders}
/>

<KpiCard
  title="Average Order"
  value={`₹${summary.averageOrderValue.toFixed(2)}`}
/>

<KpiCard
  title="Items Sold"
  value={summary.totalItemsSold}
/>

        {/* Revenue Trend */}
        <div className="mt-8">
          <RevenueChart />
        </div>

        {/* Payment Analytics & Category Revenue */}
        <div className="grid grid-cols-2 gap-6 mt-8">

          <PaymentChart />

          <CategoryChart />

        </div>

        {/* Top Selling & Low Stock */}
        <div className="grid grid-cols-2 gap-6 mt-8">

          <TopSellingTable />

          <LowStockTable />

        </div>

        {/* Recent Sales */}
        <div className="mt-8">

          <RecentSalesTable />

        </div>

      </main>

    </div>
  );
}

export default Dashboard;