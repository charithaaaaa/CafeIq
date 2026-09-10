import AIWorkspace from "../components/AIWorkspace";

function TrendAnalyzer() {

  const suggestions = [
    "What sales trends should I pay attention to?",
    "Which items are becoming more popular?",
    "Which items are losing customer interest?",
    "Are there any unusual sales patterns lately?"
  ];

  return (
    <AIWorkspace
      title="Trend Analyzer"
      description="Let's look at your sales patterns and see what's changing in your cafe."
      suggestions={suggestions}
    />
  );
}

export default TrendAnalyzer;