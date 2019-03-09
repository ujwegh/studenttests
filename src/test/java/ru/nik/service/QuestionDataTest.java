package ru.nik.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import ru.nik.domain.Question;
import ru.nik.utils.Util;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class QuestionDataTest {

    @Value("classpath:questions/file_en.csv")
    private static File enQuestions;

    @Value("classpath:questions/file_ru.csv")
    private static File ruQuestions;

    public static List<Question> getTestData() {
        Question q1 = new Question(1, "Сколько будет 2+2?",
                Map.of(1, "один", 2, "2 с половиной", 3, "три", 4, "4", 5, "а фиг его знает"),
                "4");
        Question q2 = new Question(2, "Сколько будет 3*7?",
                Map.of(1, "двадцать", 2, "21.001", 3, "двадцать один", 4, "22", 5, "а фиг его знает"),
                "двадцать один");
        Question q3 = new Question(3, "Сколько будет 1234/4?",
                Map.of(1, "триста восемь", 2, "308 c  половиной", 3, "309", 4, "а фиг его знает"),
                "308 c  половиной");
        Question q4 = new Question(4, "Сколько будет 1515*253/5?",
                Map.of(1, "76659", 2, "где-то 76 тыщ", 3, "76568", 4, "а фиг его знает"),
                "76659");
        Question q5 = new Question(5, "Сколько будет что-то там на что-то там + что-то еще?",
                Map.of(1, "что-то там", 2, "что-то еще", 3, "а фиг его знает", 4, "таки я не экстрасенс"),
                "что-то еще");

        return new ArrayList<>(Arrays.asList(q1, q2, q3, q4, q5));
    }

    public static List<Question> getEnQuestions() throws IOException {
        return Util.parseCSV(enQuestions.getPath());
    }
}
