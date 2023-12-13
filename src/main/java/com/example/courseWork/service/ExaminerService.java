package com.example.courseWork.service;

import com.example.courseWork.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
