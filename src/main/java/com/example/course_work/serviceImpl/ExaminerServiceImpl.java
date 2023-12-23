package com.example.course_work.serviceImpl;

import com.example.course_work.Question;
import com.example.course_work.service.ExaminerService;
import com.example.course_work.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random = new Random();

    private List<QuestionService> questionList;

    public ExaminerServiceImpl(List<QuestionService> questionList) {
        this.questionList = questionList;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        Set<Question> newQuestions = new HashSet<>();
        while (newQuestions.size() != amount) {
            newQuestions.add(questionList.get(random.nextInt(questionList.size())).getRandomQuestion());
        }
        return newQuestions;
    }
}
