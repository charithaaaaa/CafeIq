import AIWorkspace from "../components/AIWorkspace";

function BusinessAdvisor() {

  const suggestions = [
    "How can I increase sales today?",
    "Which products should I promote this weekend?",
    "What combo offer should I create?",
    "Where am I losing sales opportunities?"
  ];

  return (
    <AIWorkspace
      title="Business Advisor"
      description="Let's look at your cafe and find practical ways to improve sales and grow the business."
      suggestions={suggestions}
    />
  );
}

export default BusinessAdvisor;