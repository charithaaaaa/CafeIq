import AIWorkspace from "../components/AIWorkspace";

function MarketingAssistant() {
  const suggestions = [
    "Create an offer for this weekend.",
    "Which product should I promote today?",
    "Suggest a combo customers might like.",
    "How can I bring attention to a slow-selling item?"
  ];

  return (
    <AIWorkspace
      title="Marketing Assistant"
      description="Let's turn what's happening in your cafe into offers and promotions customers will actually notice."
      suggestions={suggestions}
    />
  );
}

export default MarketingAssistant;