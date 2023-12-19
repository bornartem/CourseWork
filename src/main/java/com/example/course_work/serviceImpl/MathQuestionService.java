package com.example.course_work.serviceImpl;

import com.example.course_work.Question;
import com.example.course_work.repository.MathQuestionRepository;
import com.example.course_work.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionService implements QuestionService {
    Random random = new Random();
    private final MathQuestionRepository mathQuestionRepository;

    @Autowired
    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }


    @Override
    public Question addQuestion(String question, String answer) {
        return mathQuestionRepository.addQuestion(question, answer);
    }

    @Override
    public Question findQuestion(String question, String answer) {
        return mathQuestionRepository.findQuestion(question, answer);
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        return mathQuestionRepository.removeQuestion(question, answer);
    }

    @Override
    public Set<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> mathList = mathQuestionRepository.getAll().stream().toList();
        int randomMath = random.nextInt(mathList.size());
        return mathList.get(randomMath);
    }
}
