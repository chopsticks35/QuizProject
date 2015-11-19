package quiz.data;

import java.util.List;

public class QuizQuestion {
	private int id;
	private String text;
	private List<QuizAnswer> answers;
	private String givenAnswer;
	

	public QuizQuestion() {
	
	}
	
	public QuizQuestion(int id, String text, List<QuizAnswer> answers) {
		this.id = id;
		this.text = text;
		this.answers = answers;
	}

	int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	void setText(String text) {
		this.text = text;
	}

	public List<QuizAnswer> getAnswers() {
		return answers;
	}

	void setAnswers(List<QuizAnswer> answers) {
		this.answers = answers;
	}

	public String getGivenAnswer() {
		return givenAnswer;
	}

	public void setGivenAnswer(String givenAnswer) {
		this.givenAnswer = givenAnswer;
	}

	public QuizAnswer getCorrectAnswer() {
		for (QuizAnswer answer : answers) {
			if (answer.isCorrect())
				return answer;
		}
		return null;
	}

	@Override
	public String toString() {
		
		return "Question [id=" + id + ", text=" + text + ", answers="
				+ answers + ", givenAnswer=" + givenAnswer + "]";
	}
}
