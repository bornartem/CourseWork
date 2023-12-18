package com.example.course_work.serviceImpl;

import com.example.course_work.Question;
import com.example.course_work.exception.QuestionIndexOutOfBoundException;
import com.example.course_work.service.ExaminerService;
import com.example.course_work.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;


    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new QuestionIndexOutOfBoundException();
        }
        Set<Question> newQuestions = new HashSet<>();
        while (newQuestions.size() != amount) {
            newQuestions.add(javaQuestionService.getRandomQuestion());
            newQuestions.add(mathQuestionService.getRandomQuestion());
        }
        return newQuestions;
    }
}
