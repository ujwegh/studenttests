package ru.nik.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.nik.dao.QuestionDao;
import ru.nik.dao.QuestionDaoImpl;
import ru.nik.domain.Question;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceImplTest {

    @Test
    void getAllEnQuestionsTest() throws IOException {
        QuestionService service = Mockito.mock(QuestionServiceImpl.class);
        Mockito.when(service.getAllQuestions()).thenReturn(QuestionDataTest.getEnQuestions());
//
        List<Question> testQuestions = QuestionDataTest.getTestData();
        List<Question> actualQuestions = service.getAllQuestions();
        assertEquals(actualQuestions.size(), testQuestions.size());
    }

    @Test
    void getAllRuQuestionsTest() {
//        QuestionDao dao = new QuestionDaoImpl();
//        QuestionService service =
//
//        List<Question> testQuestions = QuestionDataTest.getTestData();
//        List<Question> actualQuestions = service.getAllQuestions();
//        assertEquals(actualQuestions.size(), testQuestions.size());
    }
}