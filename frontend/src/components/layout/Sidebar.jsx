import { NavLink } from "react-router-dom";


import {
  LayoutDashboard,
  Coffee,
  Package,
  ShoppingCart,
  BarChart3,
  Bot,
} from "lucide-react";

function Sidebar() {
  return (
    <aside className="fixed left-0 top-0 w-72 h-screen bg-[#4E342E] text-white p-6 flex flex-col">

      <div>

        <h1 className="text-4xl font-bold mb-12">
          ☕ CafeIQ
        </h1>

        <nav className="space-y-2">

          {/* Dashboard */}
          <NavLink
            to="/dashboard"
            className={({ isActive }) =>
              `flex items-center gap-3 px-4 py-3 rounded-lg ${
                isActive ? "bg-[#6F4E37]" : "hover:bg-[#6F4E37]"
              }`
            }
          >
            <LayoutDashboard size={20} />
            <span>Dashboard</span>
          </NavLink>

          {/* Menu */}
          <NavLink
            to="/menu"
            className={({ isActive }) =>
              `flex items-center gap-3 px-4 py-3 rounded-lg ${
                isActive ? "bg-[#6F4E37]" : "hover:bg-[#6F4E37]"
              }`
            }
          >
            <Coffee size={20} />
            <span>Menu</span>
          </NavLink>

          {/* Inventory */}
          <NavLink
            to="/inventory"
            className={({ isActive }) =>
              `flex items-center gap-3 px-4 py-3 rounded-lg ${
                isActive ? "bg-[#6F4E37]" : "hover:bg-[#6F4E37]"
              }`
            }
          >
            <Package size={20} />
            <span>Inventory</span>
          </NavLink>

          {/* Sales */}
          <NavLink
            to="/sales"
            className={({ isActive }) =>
              `flex items-center gap-3 px-4 py-3 rounded-lg ${
                isActive ? "bg-[#6F4E37]" : "hover:bg-[#6F4E37]"
              }`
            }
          >
            <ShoppingCart size={20} />
            <span>Sales</span>
          </NavLink>

          {/* Analytics */}
          <NavLink
            to="/analytics"
            className={({ isActive }) =>
              `flex items-center gap-3 px-4 py-3 rounded-lg ${
                isActive ? "bg-[#6F4E37]" : "hover:bg-[#6F4E37]"
              }`
            }
          >
            <BarChart3 size={20} />
            <span>Analytics</span>
          </NavLink>

          {/* AI Insights */}
          <NavLink
            to="/ai-insights"
            className={({ isActive }) =>
              `flex items-center gap-3 px-4 py-3 rounded-lg ${
                isActive ? "bg-[#6F4E37]" : "hover:bg-[#6F4E37]"
              }`
            }
          >
            <Bot size={20} />
            <span>AI Insights</span>
          </NavLink>

          

      

        </nav>

      </div>

      <div className="mt-auto text-gray-300 text-sm">
        CafeIQ v1.0
      </div>

    </aside>
  );
}

export default Sidebar;