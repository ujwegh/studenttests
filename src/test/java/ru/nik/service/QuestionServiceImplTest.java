package ru.nik.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.nik.config.SpringConfig;
import ru.nik.config.WebConfig;
import ru.nik.dao.QuestionDao;
import ru.nik.dao.QuestionDaoImpl;
import ru.nik.domain.Question;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(loader= AnnotationConfigContextLoader.class,
        classes={SpringConfig.class, WebConfig.class})
class QuestionServiceImplTest {

    @Test
    void getAllEnQuestionsTest() throws IOException {
        QuestionService service = Mockito.mock(QuestionServiceImpl.class);
        Mockito.when(service.getAllQuestions()).thenReturn(QuestionDataTest.getEnQuestions());

        List<Question> testQuestions = QuestionDataTest.getTestData();
        List<Question> actualQuestions = service.getAllQuestions();
        assertEquals(actualQuestions.size(), testQuestions.size());
    }

    @Test
    void getAllRuQuestionsTest() throws IOException {
        QuestionService service = Mockito.mock(QuestionServiceImpl.class);
        Mockito.when(service.getAllQuestions()).thenReturn(QuestionDataTest.getRuQuestions());

        List<Question> testQuestions = QuestionDataTest.getTestData();
        List<Question> actualQuestions = service.getAllQuestions();
        assertEquals(actualQuestions.size(), testQuestions.size());
    }
}