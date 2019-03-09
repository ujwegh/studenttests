package ru.nik.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.nik.domain.Question;
import ru.nik.utils.Util;

import java.io.File;
import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Value("classpath:questions/file_en.csv")
    private File enQuestions;

    @Value("classpath:questions/file_ru.csv")
    private File ruQuestions;

    @Override
    public List<Question> getAllQuestions() {
        try {
            return Util.parseCSV(this.enQuestions.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Question> getAllRuQuestions() {
        try {
            return Util.parseCSV(this.ruQuestions.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
