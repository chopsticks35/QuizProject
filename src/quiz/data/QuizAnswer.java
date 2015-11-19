package quiz.data;

public class QuizAnswer {
	private String text;
	private boolean correct;

	public QuizAnswer(String text, boolean correct) {
		this.text = text;
		this.correct = correct;
	}

	public String getText() {
		return text;
	}

	void setValue(String text) {
		this.text = text;
	}

	public boolean isCorrect() {
		return correct;
	}

	void setCorrect(boolean correct) {
		this.correct = correct;
	}

	@Override
	public String toString() {
		return "Answer [text=" + text + ", correct=" + correct + "]";
	}
}
