package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import quiz.data.IQuiz;
import quiz.data.Instructor;
import quiz.data.QuizAnswer;
import quiz.data.QuizImpl;
import quiz.data.QuizQuestion;

@Controller
public class QuizController {
	
	List<QuizQuestion> questions;

	
	

	@RequestMapping(value = "/Quiz.do", method = RequestMethod.GET)
	public ModelAndView getQuiz() {

		return new ModelAndView("index.jsp");
	}

	@RequestMapping(value = "/Quiz.do", method = RequestMethod.POST)
	public ModelAndView postQuiz() {
		
		IQuiz quiz = new QuizImpl();
		 questions = quiz.getQuestions();

		for (QuizQuestion quizQuestion : questions) {
			System.out.println(quizQuestion);
		}		
				
		ModelAndView mv = new ModelAndView("questions.jsp", "questions", questions);
		return mv;
		
//		List<QuizQuestion> questions = new ArrayList<>();
//
//		List<QuizAnswer> answers1 = new ArrayList<>();
//		answers1.add(new QuizAnswer("Denver", true));
//		answers1.add(new QuizAnswer("Pueblo", false));
//		answers1.add(new QuizAnswer("Boulder", false));
//		answers1.add(new QuizAnswer("Alamosa", false));
//		QuizQuestion question1 = new QuizQuestion(1, "What is the Capital of Colorado?", answers1);
//		questions.add(question1);
//
//		for (QuizAnswer quizAnswer : answers1) {
//			System.out.println(quizAnswer);
//		}
//		ModelAndView mv = new ModelAndView("questions.jsp", "questions", questions);
//		mv.addObject("answers", answers1);
//		return mv;
	}

	// EntityManager em = emf.getEntityManager();
	// em.getTrasanction();
	// em.persist(instructors);

	

	@RequestMapping("/instructors.do")
	public ModelAndView getInstructors() {
		// this will add instructors to the view.

		List<Instructor> instructors = new ArrayList<>();

		instructors.add(0, new Instructor("David", 25));
		instructors.add(1, new Instructor("Ti", 33));
		instructors.add(2, new Instructor("Jamie", 43));

		return new ModelAndView("instructors.jsp", "instructors", instructors);
	}
}
