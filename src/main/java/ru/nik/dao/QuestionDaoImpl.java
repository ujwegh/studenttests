package ru.nik.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;
import ru.nik.domain.Question;
import ru.nik.utils.Util;

//import java.io.File;
import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {

//    @Value("classpath:questions/file_en.csv")
    @Value("${questions.en}")
    private String enQuestions;

//    @Value("classpath:questions/file_ru.csv")
    @Value("${questions.ru}")
    private String ruQuestions;

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public List<Question> getAllQuestions() {
        try {
            return Util.parseCSV(resourceLoader.getResource(enQuestions).getFile().getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Question> getAllRuQuestions() {
        try {
            return Util.parseCSV(resourceLoader.getResource(ruQuestions).getFile().getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
