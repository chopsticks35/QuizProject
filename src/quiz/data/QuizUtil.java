package quiz.data;

import java.util.List;

public class QuizUtil {
	public static String getQuizResults(IQuiz quiz) {
		StringBuilder builder = new StringBuilder(1024);
		for (QuizQuestion question : quiz.getQuestions()) {
			builder.append("Question: " + question.getText() + "\n");
			List<QuizAnswer> answers = question.getAnswers();
			for (QuizAnswer answer : answers) {
				if (answer.isCorrect()) {
					builder.append("  *");
				} else {
					builder.append("   ");
				}
				builder.append("Answer: " + answer.getText() + "\n");
			}
			builder.append("User Answer: " + question.getGivenAnswer());
			if (question.getCorrectAnswer().getText()
					.equals(question.getGivenAnswer())) {
				builder.append(" --> CORRECT" + "\n");
			} else {
				builder.append(" --> INCORRECT" + "\n");
			}
			builder.append("\n");
		}
		return builder.toString();
	}

}
