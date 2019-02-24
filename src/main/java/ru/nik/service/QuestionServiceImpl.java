package ru.nik.service;

import ru.nik.dao.QuestionDao;
import ru.nik.domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public Question getById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Question> getAllQuestions() {
        return dao.getAllQuestions();
    }
}
