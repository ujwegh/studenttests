package ru.nik.domain;

import java.util.List;
import java.util.Map;

public class Question {
    private final int id;
    private final String question;
    private final Map<Integer, String> answers;
    private final String rightAnswer;

    public Question(int id, String question, Map<Integer, String> answers, String rightAnswer) {
        this.id = id;
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }
}
