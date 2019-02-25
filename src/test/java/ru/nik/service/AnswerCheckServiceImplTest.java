package ru.nik.service;

import org.junit.jupiter.api.Test;
import ru.nik.domain.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnswerCheckServiceImplTest {

    @Test
    void checkAnswersTest() {
        AnswerCheckService checkService = new AnswerCheckServiceImpl();
        List<String> answers = new ArrayList<>();
        List<Question> testData = QuestionDataTest.getTestData();
        for (Question q: testData) {
            answers.add(q.getRightAnswer());
        }

        double result = checkService.checkAnswers(testData, answers);

        assertEquals(1.0, result);
    }
}