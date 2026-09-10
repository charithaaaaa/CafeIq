import React from "react";
import { useNavigate } from "react-router-dom";

import {
  Coffee,
  TrendingUp,
  Lightbulb,
  Megaphone,
  DollarSign,
  Users,
} from "lucide-react";

const aiExperts = [
  {
    title: "Business Advisor",
    icon: <Coffee size={30} />,
    description: "Get ideas to improve your cafe's revenue and growth.",
    path: "/ai-insights/business-advisor",
  },
  {
    title: "Trend Analyzer",
    icon: <TrendingUp size={30} />,
    description: "Understand sales patterns and customer trends.",
    path: "/ai-insights/trend-analyzer",
  },
  {
    title: "Decision Maker",
    icon: <Lightbulb size={30} />,
    description: "Get help making better business decisions.",
    path: "/ai-insights/decision-maker",
  },
  {
    title: "Marketing Assistant",
    icon: <Megaphone size={30} />,
    description: "Generate offers, promotions and marketing ideas.",
    path: "/ai-insights/marketing-assistant",
  },
  {
    title: "Profit Advisor",
    icon: <DollarSign size={30} />,
    description: "Find ways to increase profits and reduce losses.",
    path: "/ai-insights/profit-advisor",
  },
  {
    title: "Customer Behavior",
    icon: <Users size={30} />,
    description: "Understand customer preferences and buying habits.",
    path: "/ai-insights/customer-behavior",
  },
];

export default function AIInsights() {

  // Navigation
  const navigate = useNavigate();

  return (
    <div className="p-10 bg-[#F8F5F2] min-h-screen">

      {/* Header */}

      <div className="bg-white rounded-3xl shadow-md p-8 mb-8">

        <h2 className="text-3xl font-bold text-[#6F4E37] mb-4">
          Good Morning , BOSS!!
        </h2>

        <p className="text-lg text-gray-600 leading-8">

          Before your cafe gets busy today, I looked through
          yesterday's sales, inventory and customer activity.

          <br /><br />

          Here's what caught my attention.

        </p>

      </div>


      {/* Daily Briefing */}

      <div className="bg-white rounded-2xl shadow-md p-6 mb-6">

        <h2 className="text-xl font-bold text-[#6F4E37] mb-5">
          Daily Briefing
        </h2>

        <div className="space-y-3 text-gray-700">

          <p>📈 Revenue increased by 12% yesterday.</p>

          <p>☕ Cappuccino was the best-selling item.</p>

          <p>⚠ Espresso stock is running low.</p>

          <p>🍰 Brownie sales dropped this week.</p>

          <p>💳 Most customers preferred UPI payments.</p>

        </div>

      </div>


      {/* Today's Focus */}

      <div className="bg-gradient-to-r from-[#5C4033] to-[#7A5642] rounded-3xl shadow-2xl p-10 mb-10 text-white">

        <p className="uppercase tracking-[4px] text-sm text-white/70 mb-4">
          Today's Focus
        </p>

        <div className="inline-flex items-center gap-3 bg-white/15 px-5 py-3 rounded-full mb-8">

          <span className="text-2xl">☕</span>

          <h2 className="text-3xl font-bold">
            Brownie + Cappuccino Combo
          </h2>

        </div>

        <p className="text-xl leading-9 text-white/95 mb-6">

          Hey! I noticed your brownies haven't been selling much lately,
          but you still have plenty in stock.

        </p>

        <p className="text-xl leading-9 text-white/95">

          Try offering a{" "}
          <span className="font-bold text-yellow-200">
            Brownie + Cappuccino Combo
          </span>{" "}
          today. Even a small discount could encourage more customers
          to try it.

        </p>

        <div className="mt-8 border-t border-white/20 pt-5">

          <p className="text-sm text-white/70 italic">
            ☕ Suggested by CafeIQ Copilot
          </p>

        </div>

      </div>


      {/* AI Experts */}

      <h2 className="text-2xl font-bold text-[#6F4E37] mb-6">
        HOW CAN I HELP YOU TODAY?
      </h2>

      <div className="grid grid-cols-3 gap-6">

        {aiExperts.map((expert) => (

          <div
            key={expert.title}
            className="bg-white rounded-2xl shadow-md p-6
              hover:shadow-xl
              hover:border-[#A67C52]
              border-2 border-transparent
              hover:-translate-y-1
              transition-all duration-300"
          >

            {/* Icon */}

            <div className="text-[#6F4E37] mb-4">
              {expert.icon}
            </div>


            {/* Title */}

            <h3 className="text-lg font-bold mb-2">
              {expert.title}
            </h3>


            {/* Description */}

            <p className="text-gray-600 text-sm">
              {expert.description}
            </p>


            {/* Start Button */}

            <div className="mt-6 flex justify-end">

              <button
                onClick={() => navigate(expert.path)}
                className="text-[#6F4E37] font-semibold
                  hover:translate-x-1
                  transition-all duration-300"
              >
                Start →
              </button>

            </div>

          </div>

        ))}

      </div>

    </div>
  );
}