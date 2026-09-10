import {
  IndianRupee,
  ShoppingCart,
  TrendingUp,
  Coffee,
} from "lucide-react";

function KpiCard({ title, value }) {

  const getIcon = () => {
    switch (title) {
      case "Today's Revenue":
        return <IndianRupee size={24} className="text-green-600" />;

      case "Today's Orders":
        return <ShoppingCart size={24} className="text-blue-600" />;

      case "Average Order":
        return <TrendingUp size={24} className="text-orange-500" />;

      case "Items Sold":
        return <Coffee size={24} className="text-[#6F4E37]" />;

      default:
        return null;
    }
  };

  return (
    <div className="bg-white rounded-xl shadow-sm hover:shadow-lg transition-all duration-300 p-6">

      <div className="flex justify-between items-center">

        <div>

          <p className="text-gray-500 text-sm">
            {title}
          </p>

          <h2 className="text-4xl font-bold text-[#4E342E] mt-3">
            {value}
          </h2>

        </div>

        <div className="bg-[#F6F1EB] p-4 rounded-full">
          {getIcon()}
        </div>

      </div>

    </div>
  );
}


export default KpiCard;