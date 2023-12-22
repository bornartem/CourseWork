package com.example.course_work.serviceImpl;

import com.example.course_work.Question;
import com.example.course_work.exception.MathAddedException;
import com.example.course_work.exception.MathNotFound;
//import com.example.course_work.repository.MathQuestionRepository;
import com.example.course_work.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionService implements QuestionService {
    Random random = new Random();
//    private final MathQuestionRepository mathQuestionRepository;

//    @Autowired
//    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
//        this.mathQuestionRepository = mathQuestionRepository;
//    }


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
        switch (randomOperation) {
            case "+" -> {
                String questionPlus = "Сколько будет " + value1 + "+" + value2;
                String resultPlus = String.valueOf(value1 + value2);
                return new Question(questionPlus, resultPlus);
            }
            case "-" -> {
                String questionMinus = "Сколько будет " + value1 + "-" + value2;
                String resultMinus = String.valueOf(value1 + value2);
                return new Question(questionMinus, resultMinus);
            }
            case "*" -> {
                String questionMultiply = "Сколько будет " + value1 + "*" + value2;
                String resultMultiply = String.valueOf(value1 + value2);
                return new Question(questionMultiply, resultMultiply);
            }
            case "/" -> {
                String questionDivide = "Сколько будет " + value1 + "/" + value2;
                String resultDivide = String.valueOf(value1 + value2);
                return new Question(questionDivide, resultDivide);
            }
        }
        return new Question(getRandomQuestion().getQuestion(), getRandomQuestion().getAnswer());
    }
}
