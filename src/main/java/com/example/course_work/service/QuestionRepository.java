package com.example.course_work.service;

import com.example.course_work.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question addQuestion(String question, String answer);

    Question findQuestion(String question, String answer);

    Question removeQuestion(String question, String answer);

    Collection<Question> getAll();
}
