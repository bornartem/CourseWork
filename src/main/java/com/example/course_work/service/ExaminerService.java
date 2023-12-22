package com.example.course_work.service;

import com.example.course_work.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ExaminerService {
    List<Question> getQuestions(int amount);
}
