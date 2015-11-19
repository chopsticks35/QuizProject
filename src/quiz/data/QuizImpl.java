package quiz.data;

import java.util.ArrayList;
import java.util.List;

public class QuizImpl implements IQuiz{
	private List<QuizQuestion> questions;
	private String name = "State Capitals";

	public QuizImpl() {
		loadQuestions();
	}

	// Better to get this from Database
	public void loadQuestions() {
		questions = new ArrayList<>();

		List<QuizAnswer> answers1 = new ArrayList<>();
		answers1.add(new QuizAnswer("Denver", true));
		answers1.add(new QuizAnswer("Pueblo", false));
		answers1.add(new QuizAnswer("Boulder", false));
		answers1.add(new QuizAnswer("Alamosa", false));
		QuizQuestion question1 = new QuizQuestion(1,
				"What is the Capital of Colorado?", answers1);
		questions.add(question1);

		List<QuizAnswer> answers2 = new ArrayList<>();
		answers2.add(new QuizAnswer("New York City", false));
		answers2.add(new QuizAnswer("Buffalo", false));
		answers2.add(new QuizAnswer("Albany", true));
		answers2.add(new QuizAnswer("Syracuse", false));
		QuizQuestion question2 = new QuizQuestion(2,
				"What is the Capital of New York?", answers2);
		questions.add(question2);

		List<QuizAnswer> answers3 = new ArrayList<>();
		answers3.add(new QuizAnswer("Minneaopolis", false));
		answers3.add(new QuizAnswer("St. Paul", true));
		answers3.add(new QuizAnswer("Duluth", false));
		answers3.add(new QuizAnswer("St. Cloud", false));
		QuizQuestion question3 = new QuizQuestion(3,
				"What is the Capital of Minnesota?", answers3);
		questions.add(question3);

	}

	public String getName() {
		return name;
	}
	
	public int getNumberOfQuestions() {
		return questions.size();
	}

	public List<QuizQuestion> getQuestions() {
		return questions;
	}

	void setQuestions(List<QuizQuestion> questions) {
		this.questions = questions;
	}
}
