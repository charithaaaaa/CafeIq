import { Bell, Search } from "lucide-react";

function Header() {
  const today = new Date().toLocaleDateString("en-IN", {
    weekday: "long",
    day: "numeric",
    month: "long",
    year: "numeric",
  });

  return (
    <header className="bg-white rounded-xl shadow-sm px-8 py-6 flex items-center justify-between">

      <div>
        <h1 className="text-5xl font-bold text-[#4E342E]">
          Dashboard
        </h1>

        <p className="text-gray-500 mt-1">
          {today}
        </p>
      </div>

      <div className="flex items-center gap-5">

        {/* Search */}

        <div className="flex items-center bg-[#F6F1EB] px-4 py-3 rounded-lg w-80">

          <Search size={20} className="text-gray-500" />

          <input
            type="text"
            placeholder="Search..."
            className="bg-transparent outline-none ml-3 w-full"
          />

        </div>

        {/* Notification */}

        <button className="bg-[#F6F1EB] p-3 rounded-lg hover:bg-[#EADFD2]">

          <Bell size={20} />

        </button>

        {/* Profile */}

        <div className="flex items-center gap-3 bg-[#6F4E37] text-white px-4 py-2 rounded-lg">

          <div className="w-10 h-10 rounded-full bg-white text-[#6F4E37] flex items-center justify-center font-bold">
            A
          </div>

          <div>

            <p className="font-semibold">Admin</p>

            <p className="text-xs text-gray-200">
              Cafe Manager
            </p>

          </div>

        </div>

      </div>

    </header>
  );
}

export default Header;