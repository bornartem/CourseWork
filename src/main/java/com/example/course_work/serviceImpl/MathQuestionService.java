package com.example.course_work.serviceImpl;

import com.example.course_work.Question;
import com.example.course_work.exception.MathAddedException;
import com.example.course_work.exception.MathNotFound;
import com.example.course_work.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>(List.of(
            new Question("2+2", "4"),
            new Question("10-5", "5"),
            new Question("4*4", "16"),
            new Question("100/5", "20"),
            new Question("7+3-5", "5"),
            new Question("10-10", "0")

    ));

    @Override
    public Question addQuestion(String question, String answer) {
        Question math = new Question(question, answer);
        if (questions.contains(math) || math == null) {
            throw new MathAddedException();
        }
        questions.add(math);
        return math;
    }

    @Override
    public Question findQuestion(String question, String answer) {
        Question math = new Question(question, answer);
        if (questions.contains(math)) {
            return math;
        }
        throw new MathNotFound();
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        Question math = new Question(question, answer);
        if (questions.contains(math)) {
            questions.remove(math);
            return math;
        }
        throw new MathNotFound();
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> mathList = questions.stream().toList();
        Random random = new Random();
        int randomMath = random.nextInt(mathList.size());
        return mathList.get(randomMath);
    }
}
