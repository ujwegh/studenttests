package ru.nik.dao;

import ru.nik.domain.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> getAllQuestions();

    List<Question> getAllRuQuestions();
}
