package com.example.course_work.serviceImpl;

import com.example.course_work.Question;
import com.example.course_work.exception.QuestionIndexOutOfBoundException;
import com.example.course_work.service.ExaminerService;
import com.example.course_work.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    Random random = new Random();

    private List<QuestionService> questionList;

    public ExaminerServiceImpl(List<QuestionService> questionList) {
        this.questionList = questionList;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        if (amount > questionList.size()) {
            throw new QuestionIndexOutOfBoundException();
        }
        while (questionList.size() != amount) {
            questionList.get(random.nextInt(questionList.size())).getRandomQuestion();
        }
        return questionList;
    }
}
