package com.example.course_work.serviceImpl;


import com.example.course_work.Question;
import com.example.course_work.exception.QuestionAddedException;
import com.example.course_work.exception.QuestionNotFound;
import com.example.course_work.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("javaQuestionService")
public class JavaQuestionService implements QuestionService {
    Random random = new Random();
    private final Set<Question> questions = new HashSet<>(Set.of(
            new Question("What kind types of variables in Java?", "Primitives and references"),
            new Question("What kind types of collections in Java?", "List, Set, Map"),
            new Question("What class is grand pa of all classes in Java?", "Object"),
            new Question("What kind types of OOP do you know?", "Polymorphism, Inheritance, Encapsulation"),
            new Question("What kind types of memory in Java?", "Stack, Heap"),
            new Question("Test1", "Test2")
    ));

    @Override
    public Question addQuestion(String question, String answer) {
        Question enigma = new Question(question, answer);
        if (questions.contains(enigma) || questions.contains(null)) {
            throw new QuestionAddedException();
        }
        return enigma;
    }

    @Override
    public Question findQuestion(String question, String answer) {
        Question enigma = new Question(question, answer);
        if (questions.contains(enigma)) {
            return enigma;
        }
        throw new QuestionNotFound();
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        Question enigma = new Question(question, answer);
        if (questions.contains(enigma)) {
            questions.remove(enigma);
            return enigma;
        }
        throw new QuestionNotFound();
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> arrQuestion = questions.stream().toList();
        int randomNumber = random.nextInt(arrQuestion.size());
        return arrQuestion.get(randomNumber);
    }
}
