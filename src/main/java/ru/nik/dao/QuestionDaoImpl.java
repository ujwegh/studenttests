package ru.nik.dao;

import ru.nik.domain.Question;
import ru.nik.utils.Util;

import java.util.List;

public class QuestionDaoImpl implements QuestionDao {

    @Override
    public Question findById(int id) {
        try {
            List<Question> questions = Util.parseCSV(this.getClass()
                    .getClassLoader().getResource("/questions/file.csv").getFile());
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
            return Util.parseCSV(this.getClass()
                    .getClassLoader().getResource("/questions/file.csv").getFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
