import AIWorkspace from "../components/AIWorkspace";

function CustomerBehavior() {
  const suggestions = [
    "What are customers buying most often?",
    "Which items are commonly popular together?",
    "Are customer preferences changing?",
    "What does recent sales activity tell me about my customers?"
  ];

  return (
    <AIWorkspace
      title="Customer Behavior"
      description="Let's understand what your customers seem to prefer based on how they actually buy."
      suggestions={suggestions}
    />
  );
}

export default CustomerBehavior;