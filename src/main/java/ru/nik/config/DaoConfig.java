package ru.nik.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.nik.dao.QuestionDao;
import ru.nik.dao.QuestionDaoImpl;

//@Configuration
public class DaoConfig {

//    @Bean
    public QuestionDao personDao() {
        return new QuestionDaoImpl();
    }
}
