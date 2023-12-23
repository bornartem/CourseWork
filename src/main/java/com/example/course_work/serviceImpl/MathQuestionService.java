package com.example.course_work.serviceImpl;

import com.example.course_work.Question;
import com.example.course_work.exception.MathAddedException;
import com.example.course_work.exception.MathNotFound;
import com.example.course_work.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionService implements QuestionService {
    private Random random = new Random();

    private String getQuestion(int value1, int value2, String randomOperation) {
        return "Сколько будет " + value1 + randomOperation + value2;
    }

    @Override
    public Question addQuestion(String question, String answer) {
        throw new MathAddedException();
    }

    @Override
    public Question findQuestion(String question, String answer) {
        throw new MathNotFound();
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        throw new MathNotFound();
    }

    @Override
    public Set<Question> getAll() {

        throw new MathNotFound();
    }

    @Override
    public Question getRandomQuestion() {
        int value1 = random.nextInt(1, 10);
        int value2 = random.nextInt(1, 10);
        List<String> operations = List.of("+", "-", "*", "/");
        int index = random.nextInt(0, operations.size());
        String randomOperation = operations.get(index);
        String questionString = getQuestion(value1, value2, randomOperation);
        switch (randomOperation) {
            case "+" -> {
                String resultPlus = String.valueOf(value1 + value2);
                return new Question(questionString, resultPlus);
            }
            case "-" -> {
                String resultMinus = String.valueOf(value1 - value2);
                return new Question(questionString, resultMinus);
            }
            case "*" -> {
                String resultMultiply = String.valueOf(value1 * value2);
                return new Question(questionString, resultMultiply);
            }
            case "/" -> {
                String resultDivide = String.valueOf(value1 / value2);
                return new Question(questionString, resultDivide);
            }
        }
        return null;
    }
}

