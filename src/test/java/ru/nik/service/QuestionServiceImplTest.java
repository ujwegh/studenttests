package ru.nik.service;

import org.junit.jupiter.api.Test;
import ru.nik.dao.QuestionDao;
import ru.nik.dao.QuestionDaoImpl;
import ru.nik.domain.Question;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceImplTest {

    @Test
    void getByIdTest() {
        QuestionDao dao = new QuestionDaoImpl();
        QuestionService service = new QuestionServiceImpl(dao);
        assertEquals(QuestionDataTest.getTestData().get(0).getQuestion(), service.getById(1).getQuestion());

    }

    @Test
    void getAllQuestionsTest() {
        QuestionDao dao = new QuestionDaoImpl();
        QuestionService service = new QuestionServiceImpl(dao);

        List<Question> testQuestions = QuestionDataTest.getTestData();
        List<Question> actualQuestions = service.getAllQuestions();
        assertEquals(actualQuestions.size(), testQuestions.size());
    }
}