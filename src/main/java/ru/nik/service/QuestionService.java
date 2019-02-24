package ru.nik.service;

import ru.nik.domain.Question;

import java.util.List;

public interface QuestionService {
    Question getById(int number);

    List<Question> getAllQuestions();
}
