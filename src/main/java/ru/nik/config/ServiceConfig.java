package ru.nik.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.nik.dao.QuestionDao;
import ru.nik.service.AnswerCheckService;
import ru.nik.service.AnswerCheckServiceImpl;
import ru.nik.service.QuestionService;
import ru.nik.service.QuestionServiceImpl;

//@Configuration
public class ServiceConfig {

//    @Bean
    public QuestionService questionService(QuestionDao dao) {
        return new QuestionServiceImpl(dao);
    }

//    @Bean
    public AnswerCheckService answerCheckService() {
        return new AnswerCheckServiceImpl();
    }
}
