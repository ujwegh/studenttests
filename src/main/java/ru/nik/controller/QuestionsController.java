package ru.nik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.nik.domain.Person;
import ru.nik.domain.Question;
import ru.nik.service.AnswerCheckService;
import ru.nik.service.QuestionService;

import javax.servlet.http.HttpServletRequest;

import java.util.*;

@Controller(value = "/login")
public class QuestionsController {

    private final QuestionService questionService;

    private final AnswerCheckService answerCheckService;

    private Person person = new Person("", "");

    @Autowired
    public QuestionsController(QuestionService questionService, AnswerCheckService answerCheckService) {
        this.questionService = questionService;
        this.answerCheckService = answerCheckService;
    }

    @GetMapping(value = "/login")
    public String getUser() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String loginPerson(Person person) {
        this.person = person;
        return "redirect:/questions";
    }

    @GetMapping("/questions")
    public List<Question> allQuestions(Model model,  Locale locale) {
        List<Question> questions;
        if (locale.equals(Locale.ENGLISH)) {
            questions = questionService.getAllQuestions();
        } else{
            questions = questionService.getAllRuQuestions();
        }

        if (questions == null) {
            questions = Collections.emptyList();
        }
        model.addAttribute("questions", questions);
        return questions;
    }

    @PostMapping(value = "/questions")
    public String sendAnswers(HttpServletRequest req, Model model) {
        List<Question> questions = questionService.getAllQuestions();
        Enumeration<String> parameterNames = req.getParameterNames();
        List<String> answers = new ArrayList<>();
        String paramName;
        while (parameterNames.hasMoreElements()) {
            paramName = parameterNames.nextElement();
            answers.add(req.getParameter(paramName));
        }
        double score = answerCheckService.checkAnswers(questions, answers);
        parameterNames.asIterator().forEachRemaining(System.out::println);
        model.addAttribute("name", this.person.getName());
        model.addAttribute("surname", this.person.getSurname());
        model.addAttribute("score", score);

        return "congrats";
    }


}
