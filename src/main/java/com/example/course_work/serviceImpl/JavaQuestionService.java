package com.example.course_work.serviceImpl;


import com.example.course_work.Question;
import com.example.course_work.repository.JavaQuestionRepository;
import com.example.course_work.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("javaQuestionService")
public class JavaQuestionService implements QuestionService {
    private final Random random = new Random();
    private final JavaQuestionRepository javaQuestionRepository;

    @Autowired
    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question addQuestion(String question, String answer) {
        return javaQuestionRepository.addQuestion(question, answer);
    }

    @Override
    public Question findQuestion(String question, String answer) {
        return javaQuestionRepository.findQuestion(question, answer);
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        return javaQuestionRepository.removeQuestion(question, answer);
    }

    @Override
    public Set<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> arrQuestion = javaQuestionRepository.getAll().stream().toList();
        int randomNumber = random.nextInt(arrQuestion.size());
        return arrQuestion.get(randomNumber);
    }
}
