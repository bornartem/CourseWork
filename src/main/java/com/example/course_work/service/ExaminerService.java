package com.example.course_work.service;

import com.example.course_work.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}
