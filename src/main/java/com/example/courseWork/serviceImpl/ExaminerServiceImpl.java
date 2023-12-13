package com.example.courseWork.serviceImpl;

import com.example.courseWork.Question;
import com.example.courseWork.exception.QuestionIndexOutOfBoundException;
import com.example.courseWork.service.ExaminerService;
import com.example.courseWork.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> newQuestions = new HashSet<>();
        if (questionService.getAll().size() < amount) {
            throw new QuestionIndexOutOfBoundException();
        }
        newQuestions.add(questionService.getRandomQuestion());
        return newQuestions;
    }
}
