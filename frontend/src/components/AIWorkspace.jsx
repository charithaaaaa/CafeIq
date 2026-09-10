import { useState } from "react";
import { ArrowLeft, Send, Sparkles } from "lucide-react";
import { useNavigate } from "react-router-dom";

function AIWorkspace({ title, description, suggestions }) {

  const navigate = useNavigate();

  const [question, setQuestion] = useState("");
  const [answer, setAnswer] = useState("");
  const [loading, setLoading] = useState(false);

  // Temporary function
  // Later this will call our Spring Boot backend
  const handleAsk = () => {

    if (!question.trim()) {
      return;
    }

    setLoading(true);
    setAnswer("");

    // Temporary response just to test the UI
    setTimeout(() => {

      setAnswer(
        "Looking at your cafe's recent activity, I'd focus on your slower-moving items today. Instead of discounting them heavily, try pairing one with an item customers already like. This can help move stock while keeping the offer attractive."
      );

      setLoading(false);

    }, 800);
  };

  return (
    <div className="min-h-screen bg-[#F8F5F2] p-10">

      {/* Back Button */}

      <button
        onClick={() => navigate("/ai-insights")}
        className="flex items-center gap-2 text-[#6F4E37] mb-8 hover:underline"
      >
        <ArrowLeft size={18} />
        Back to AI Insights
      </button>


      {/* Header */}

      <div className="mb-10">

        <h1 className="text-4xl font-bold text-[#4E342E] mb-3">
          {title}
        </h1>

        <p className="text-gray-600 text-lg">
          {description}
        </p>

      </div>


      {/* Suggested Questions */}

      <div className="bg-white rounded-2xl shadow-sm p-7 mb-8">

        <h2 className="text-lg font-semibold text-[#4E342E] mb-5">
          You could ask me...
        </h2>

        <div className="flex flex-wrap gap-3">

          {suggestions.map((suggestion) => (

            <button
              key={suggestion}
              onClick={() => setQuestion(suggestion)}
              className="
                px-5 py-3
                border border-[#D7C5B5]
                rounded-xl
                text-[#6F4E37]
                hover:bg-[#F3E9E2]
                hover:border-[#A67C52]
                transition
              "
            >
              {suggestion}
            </button>

          ))}

        </div>

      </div>


      {/* Question Box */}

      <div className="bg-white rounded-2xl shadow-sm p-7 mb-8">

        <h2 className="text-lg font-semibold text-[#4E342E] mb-4">
          What would you like to know?
        </h2>

        <div className="flex gap-3">

          <input
            type="text"
            value={question}
            onChange={(e) => setQuestion(e.target.value)}
            onKeyDown={(e) => {
              if (e.key === "Enter") {
                handleAsk();
              }
            }}
            placeholder="Ask CafeIQ..."
            className="
              flex-1
              border border-gray-300
              rounded-xl
              px-5 py-4
              outline-none
              focus:border-[#6F4E37]
            "
          />

          <button
            onClick={handleAsk}
            disabled={loading}
            className="
              bg-[#6F4E37]
              text-white
              px-6
              rounded-xl
              flex items-center gap-2
              hover:bg-[#4E342E]
              transition
              disabled:opacity-60
            "
          >
            Ask
            <Send size={18} />
          </button>

        </div>

      </div>


      {/* Thinking */}

      {loading && (

        <div className="bg-white rounded-2xl shadow-sm p-7 mb-8">

          <div className="flex items-center gap-3 text-[#6F4E37]">

            <Sparkles size={21} />

            <p className="font-medium">
              Looking through your cafe data...
            </p>

          </div>

        </div>

      )}


      {/* AI Answer */}

      {answer && !loading && (

        <div
          className="
            bg-gradient-to-r
            from-[#5C4033]
            to-[#7A5642]
            rounded-2xl
            shadow-lg
            p-8
            text-white
          "
        >

          <div className="flex items-center gap-3 mb-5">

            <Sparkles size={23} />

            <h2 className="text-xl font-bold">
              CafeIQ
            </h2>

          </div>

          <p className="text-lg leading-8 text-white/95">
            {answer}
          </p>

        </div>

      )}

    </div>
  );
}

export default AIWorkspace;