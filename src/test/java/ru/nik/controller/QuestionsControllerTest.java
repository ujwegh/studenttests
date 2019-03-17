package ru.nik.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import ru.nik.config.SpringConfig;
import ru.nik.config.WebConfig;
import ru.nik.domain.Person;
import ru.nik.domain.Question;
import ru.nik.service.AnswerCheckService;
import ru.nik.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringConfig.class, WebConfig.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class QuestionsControllerTest {

    private static final CharacterEncodingFilter CHARACTER_ENCODING_FILTER = new CharacterEncodingFilter();

    static {
        CHARACTER_ENCODING_FILTER.setEncoding("UTF-8");
        CHARACTER_ENCODING_FILTER.setForceEncoding(true);
    }

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerCheckService answerCheckService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeAll
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .addFilter(CHARACTER_ENCODING_FILTER).build();
    }

    @Test
    void getUserTest() throws Exception {
        this.mockMvc.perform(get("/login")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(forwardedUrl("/WEB-INF/views/login.jsp"));
    }

    @Test
    void loginPersonTest() throws Exception {
        Person person = new Person("вася", "пупкин");
        this.mockMvc.perform(post("/login").param("name", person.getName())
                .param("surname", person.getSurname()))
                .andDo(print())
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/questions"));
    }

    @Test
    void allQuestionsTest() throws Exception {
        this.mockMvc.perform(get("/questions"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("questions"))
                .andExpect(forwardedUrl("/WEB-INF/views/questions.jsp"))
                .andExpect(result -> questionService.getAllQuestions());
    }

    @Test
    void sendAnswersTest() throws Exception {
        List<Question> questions = questionService.getAllQuestions();
        List<String> answers = new ArrayList<>();
        questions.forEach(q -> answers.add(q.getRightAnswer()));
        if (answers.size() == 5)
            this.mockMvc.perform(post("/questions")
                    .param("answer 1", answers.get(0))
                    .param("answer 2", answers.get(1))
                    .param("answer 3", answers.get(2))
                    .param("answer 4", answers.get(3))
                    .param("answer 5", answers.get(4)))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(model().attribute("name", "вася"))
                    .andExpect(model().attribute("surname", "пупкин"))
                    .andExpect(forwardedUrl("/WEB-INF/views/congrats.jsp"));
    }
}