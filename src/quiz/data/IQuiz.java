package quiz.data;

import java.util.List;

public interface IQuiz {
	public String getName();
	public int getNumberOfQuestions();
	public List<QuizQuestion> getQuestions();
}
