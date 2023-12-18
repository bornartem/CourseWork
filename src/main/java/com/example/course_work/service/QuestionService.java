package com.example.course_work.service;

import com.example.course_work.Question;

import java.util.Collection;
import java.util.Set;

public interface QuestionService {
    Question addQuestion(String question, String answer);

    Question findQuestion(String question, String answer);

    Question removeQuestion(String question, String answer);

    Set<Question> getAll();

    Question getRandomQuestion();
}
