import json
import requests

from deepeval import evaluate
from deepeval.metrics import AnswerRelevancyMetric, GEval
from deepeval.models import OllamaModel
from deepeval.test_case import LLMTestCase, SingleTurnParams
from deepeval.evaluate.configs import AsyncConfig

API_URL = "http://localhost:8080/api/ai/business-advisor"
QUESTIONS_FILE = "src/test/resources/advisor-evaluation.json"


def load_questions():
    with open(QUESTIONS_FILE, "r", encoding="utf-8") as file:
        return json.load(file)


def ask_business_advisor(question):
    response = requests.post(
        API_URL,
        json={"question": question},
        timeout=300,
    )

    response.raise_for_status()

    data = response.json()

    return data["answer"]


def main():
    questions = load_questions()
    test_cases = []

    print("\n========================================")
    print("CafeIQ AI Advisor - Day 2 Evaluation")
    print("========================================\n")

    for item in questions:
        question_id = item["id"]
        question = item["question"]

        print(f"[{question_id}/10] {question}")

        answer = ask_business_advisor(question)

        print(f"Answer: {answer}\n")

        test_cases.append(
            LLMTestCase(
                input=question,
                actual_output=answer,
                expected_output=item["expectedBehavior"],
            )
        )

    judge_model = OllamaModel(
        model="llama3.2:3b",
        base_url="http://localhost:11434",
        temperature=0,
    )

    relevancy_metric = AnswerRelevancyMetric(
        threshold=0.7,
        include_reason=True,
        model=judge_model,
    )

    business_rule_metric = GEval(
        name="CafeIQ Business Rule Compliance",
        criteria=(
            "Determine whether the actual answer satisfies the expected CafeIQ "
            "business behavior for this question. The answer should follow the "
            "stated business rule, use evidence appropriately, avoid unsupported "
            "claims, and avoid inventing unavailable data."
        ),
        evaluation_params=[
            SingleTurnParams.ACTUAL_OUTPUT,
            SingleTurnParams.EXPECTED_OUTPUT,
        ],
        threshold=0.7,
        
        model=judge_model,
    )

    print("\n========================================")
    print("Running DeepEval")
    print("========================================\n")

    evaluate(
        test_cases=test_cases,
        metrics=[
            relevancy_metric,
            business_rule_metric,
        ],
        async_config=AsyncConfig(
            run_async=True,
            max_concurrent=1,
        ),
    )


if __name__ == "__main__":
    main()
