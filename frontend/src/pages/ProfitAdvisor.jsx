import AIWorkspace from "../components/AIWorkspace";

function ProfitAdvisor() {
  const suggestions = [
    "Where might I be losing money?",
    "Which products are contributing most to my revenue?",
    "How can I improve profit without increasing prices?",
    "Are any slow-selling items tying up too much stock?"
  ];

  return (
    <AIWorkspace
      title="Profit Advisor"
      description="Let's find where your cafe is making money, where it's losing opportunities, and what you could improve."
      suggestions={suggestions}
    />
  );
}

export default ProfitAdvisor;