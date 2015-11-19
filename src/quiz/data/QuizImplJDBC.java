package quiz.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizImplJDBC implements IQuiz {
	private List<QuizQuestion> questions;
	private String name = "State Capitals";

	public QuizImplJDBC() {
		String URL = "jdbc:derby://localhost:1527/quiz";

		// For SQLite
		//String URL = "jdbc:sqlite:" + System.getProperty("user.home") + 
		//		"/SD/Databases/quiz.db";

		try (Connection conn = DriverManager.getConnection(URL)) {
			loadQuestions(conn);
		} catch (SQLException e) {
			System.err.println(e);
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	private void loadQuestions(Connection conn) throws SQLException {

		String questionSQL = "SELECT qu.id, text "
				+ "FROM quiz q, question qu, quiz_question qq "
				+ "WHERE q.id = qq.quiz_id " + "AND qu.id = qq.question_id "
				+ "AND q.name = ?";

		PreparedStatement pstmt = conn.prepareStatement(questionSQL);
		pstmt.setString(1, name);
		ResultSet rs = pstmt.executeQuery();

		questions = new ArrayList<>();
		while (rs.next()) {
			int questionId = rs.getInt(1);
			String questionText = rs.getString(2);

			List<QuizAnswer> answers = new ArrayList<>();
			String answerSQL = "SELECT text, iscorrect " + "FROM answer "
					+ "WHERE question_id = ?";
			PreparedStatement pstmt2 = conn.prepareStatement(answerSQL);
			pstmt2.setInt(1, questionId);
			ResultSet rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				String answerText = rs2.getString(1);
				boolean isCorrect = false;
				if (rs2.getString(2).equals("Y"))
				   isCorrect = true;
				answers.add(new QuizAnswer(answerText, isCorrect));
			}
			rs2.close();
			pstmt2.close();

			QuizQuestion question = new QuizQuestion(questionId, questionText, answers);
			questions.add(question);
		}
		rs.close();
		pstmt.close();
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
