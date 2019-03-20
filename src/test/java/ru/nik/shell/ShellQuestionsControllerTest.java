package ru.nik.shell;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.nik.service.AnswerCheckService;
import ru.nik.service.QuestionService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ShellQuestionsControllerTest {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerCheckService answerCheckService;


    @Test
    void fullname() {

    }

    @Test
    void locale() {
    }

    @Test
    void questions() {
    }
}