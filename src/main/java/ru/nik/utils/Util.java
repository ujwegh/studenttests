package ru.nik.utils;

import com.opencsv.CSVReader;
import ru.nik.domain.Question;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Util {
    private Util() {
    }

    public static List<Question> parseCSV(String path) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(path, StandardCharsets.UTF_8), ',');
        List<Question> questions = new ArrayList<>();
        //read line by line
        String[] record;

        while ((record = reader.readNext()) != null) {
            int size = record.length;
            Map<Integer, String> answers = new HashMap<>();
            for (int i = 2, k = 0; i < size - 1; i++, k++) {
                answers.put(k, record[i]);
            }
            Question temp = new Question(Integer.parseInt(record[0]), record[1], answers, record[size - 1]);
            questions.add(temp);
        }
        reader.close();

        return questions;
    }
}
