package ru.nik.dao;

import ru.nik.domain.Question;
import ru.nik.utils.Util;

import java.io.File;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {

    @Override
    public Question findById(int id) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("questions/file.csv").getFile());
            List<Question> questions = Util.parseCSV(file.getPath());
            for (Question q : questions) {
                if (q.getId() == id) {
                    return q;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public List<Question> getAllQuestions() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("questions/file.csv").getFile());
            return Util.parseCSV(file.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
