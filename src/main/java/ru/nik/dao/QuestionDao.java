package ru.nik.dao;

import ru.nik.domain.Question;

import java.util.List;

public interface QuestionDao {
    Question findById(int number);

    List<Question> getAllQuestions();
}
