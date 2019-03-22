package ru.nik.shell;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.nik.service.AnswerCheckService;
import ru.nik.service.QuestionService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
class ShellQuestionsControllerTest {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerCheckService answerCheckService;

    private ShellQuestionsController controller;

    @BeforeEach
    void init() {
        controller = new ShellQuestionsController(questionService, answerCheckService);
    }

    @Test
    void fullname() {
        String result = controller.fullname("вася", "пупкин");
        assertEquals("You have successfully input 'Person{name='вася', surname='пупкин'}' person", result);
    }

    @Test
    void locale() {
        String result = controller.locale("ru");
        assertEquals("You have successfully input '" + "ru" + "' locale", result);
    }

    @Test
    void questionsNoLocale() {
        String result = controller.questions();
        assertEquals("Locale is null! Please input locale first!", result);
    }

    @Test
    void questionsNoFullname() {
        controller.locale("ru");
        String result = controller.questions();
        assertEquals("Your name is empty! Please input your full name first!", result);
    }

    @Test
    void questions() {
        controller.locale("ru");
        controller.fullname("вася", "пупкин");
        String result = controller.questions();



    }
}