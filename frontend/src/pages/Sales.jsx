import { useEffect, useState } from "react";
import toast from "react-hot-toast";

import Sidebar from "../components/layout/Sidebar";
import Header from "../components/layout/Header";

import SalesForm from "../components/forms/SalesForm";
import SalesTable from "../components/tables/SalesTable";

import { getAllSales } from "../services/salesService";

function Sales() {

  const [sales, setSales] = useState([]);

  // Fetch Sales
  const fetchSales = () => {

    getAllSales()
      .then((response) => {

        setSales(response.data);

      })
      .catch((error) => {

        console.error("Error fetching sales:", error);

      });

  };

  useEffect(() => {

    fetchSales();

  }, []);

  return (

    <div className="bg-[#F6F1EB] min-h-screen">

      <Sidebar />

      <main className="ml-72 p-10">

        <Header />

        <h1 className="text-4xl font-bold text-[#4E342E] mt-8 mb-8">

          Sales Management

        </h1>

        <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">

          {/* Sales Form */}

          <div>

            <SalesForm
              onSaleComplete={fetchSales}
            />

          </div>

          {/* Sales Table */}

          <div className="lg:col-span-2">

            <SalesTable
              sales={sales}
            />

          </div>

        </div>

      </main>

    </div>

  );

}

export default Sales;