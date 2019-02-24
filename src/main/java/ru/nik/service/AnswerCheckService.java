package ru.nik.service;

import ru.nik.domain.Question;

import java.util.List;

public interface AnswerCheckService {
    double checkAnswers(List<Question> questions, List<String> answers);
}
