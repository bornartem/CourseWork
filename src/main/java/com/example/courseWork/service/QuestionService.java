package com.example.courseWork.service;

import com.example.courseWork.Question;

import java.util.Collection;

public interface QuestionService {
    Question addQuestion(String question, String answer);

    Question findQuestion(String question, String answer);

    Question removeQuestion(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
