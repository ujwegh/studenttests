package ru.nik.service;

import org.springframework.stereotype.Service;
import ru.nik.domain.Question;

import java.util.List;

@Service
public class AnswerCheckServiceImpl implements AnswerCheckService {

    @Override
    public double checkAnswers(List<Question> questions, List<String> answers) {
        double value = 0.0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getRightAnswer().equals(answers.get(i))) {
                value++;
            }
        }
        return value / questions.size();
    }
}
