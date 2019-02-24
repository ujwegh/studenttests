package ru.nik.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.nik.domain.Question;
import ru.nik.service.AnswerCheckService;
import ru.nik.service.QuestionService;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/questions")
public class QuestionsServlet extends HttpServlet {

    private ClassPathXmlApplicationContext context;

    public void init(ServletConfig config) {
        System.out.println("My questions servlet has been initialized");
        this.context = new ClassPathXmlApplicationContext("/spring-context.xml");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionService service = context.getBean(QuestionService.class);
        List<Question> questions = service.getAllQuestions();
        if (questions == null) {
            questions = Collections.emptyList();
        }
        req.setAttribute("questions", questions);
        req.getRequestDispatcher("/WEB-INF/views/questions.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        AnswerCheckService checkService = context.getBean(AnswerCheckService.class);
        QuestionService service = context.getBean(QuestionService.class);
        List<Question> questions = service.getAllQuestions();
        Enumeration<String> parameterNames = req.getParameterNames();
        Cookie[] cookies = req.getCookies();
        for (Cookie k : cookies) {
            if (k.getName().equals("name"))
                req.setAttribute("name", k.getValue());
            if (k.getName().equals("surname"))
                req.setAttribute("surname", k.getValue());
        }
        List<String> answers = new ArrayList<>();
        String paramName;
        while (parameterNames.hasMoreElements()) {
            paramName = parameterNames.nextElement();
            answers.add(req.getParameter(paramName));
        }
        double score = checkService.checkAnswers(questions, answers);
        req.setAttribute("score", score);
        req.getRequestDispatcher("/WEB-INF/views/congrats.jsp").forward(req, resp);
    }


}
