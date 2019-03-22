package ru.nik.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.nik.domain.Person;
import ru.nik.domain.Question;
import ru.nik.service.AnswerCheckService;
import ru.nik.service.QuestionService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ShellComponent
public class ShellQuestionsController {

    private final QuestionService questionService;

    private final AnswerCheckService answerCheckService;

    private Person person;
    private String locale;

    @Autowired
    public ShellQuestionsController(QuestionService questionService, AnswerCheckService answerCheckService) {
        this.questionService = questionService;
        this.answerCheckService = answerCheckService;
    }

    @ShellMethod("fullname")
    public String fullname(@ShellOption String name, @ShellOption String surname) {
        this.person = new Person(name, surname);
        return "You have successfully input '" + person.toString() + "' person";
    }

    @ShellMethod("locale")
    public String locale(@ShellOption String locale) {
        this.locale = locale;
        return "You have successfully input '" + locale + "' locale";
    }

    @ShellMethod("questions")
    public String questions() {
        if (locale == null) {
            return "Locale is null! Please input locale first!";
        } else if (person == null) {
            return "Your name is empty! Please input your full name first!";
        } else {
            List<Question> questions;
            List<String> answers = new ArrayList<>();
            List<String> rightAnswers = new ArrayList<>();
            System.out.println("Please input an answer completely");
            if (locale.equals("ru")) {
                questions = questionService.getAllRuQuestions();
                answers = questions.stream().map(this::answerTheQuestion).collect(Collectors.toList());
            } else {
                questions = questionService.getAllQuestions();
                answers = questions.stream().map(this::answerTheQuestion).collect(Collectors.toList());
            }
            double score = answerCheckService.checkAnswers(questions, answers);
            return "Congratulations!!!\n" + person.getName() + " " + person.getSurname()+", your score is " + score;
        }
    }

    private String answerTheQuestion(Question question) {
        System.out.println(question.getQuestion());
        Map<Integer, String> answers = question.getAnswers();
        answers.forEach((integer, s) -> System.out.println(integer + ") " +s));
        try {
            return new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            System.out.println("Some error happen!");
        }
        return null;
    }
}
