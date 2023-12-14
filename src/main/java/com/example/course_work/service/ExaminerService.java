package com.example.course_work.service;

import com.example.course_work.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
