import AIWorkspace from "../components/AIWorkspace";

function DecisionMaker() {
  const suggestions = [
    "What should I focus on improving today?",
    "Should I promote my best seller or a slow-moving item?",
    "Which menu item should I consider removing?",
    "What is the biggest problem I should fix right now?"
  ];

  return (
    <AIWorkspace
      title="Decision Maker"
      description="Not sure what to do next? Let's use your cafe data to make a better decision."
      suggestions={suggestions}
    />
  );
}

export default DecisionMaker;