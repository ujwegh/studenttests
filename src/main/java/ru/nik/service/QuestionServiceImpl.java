package ru.nik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nik.dao.QuestionDao;
import ru.nik.domain.Question;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao dao;

    @Autowired
    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Question> getAllQuestions() {
        return dao.getAllQuestions();
    }

    @Override
    public List<Question> getAllRuQuestions() {
        return dao.getAllRuQuestions();
    }
}
