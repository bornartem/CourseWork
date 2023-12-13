package com.example.courseWork.serviceImpl;


import com.example.courseWork.Question;
import com.example.courseWork.exception.QuestionAddedException;
import com.example.courseWork.exception.QuestionNotFound;
import com.example.courseWork.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>(List.of(
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
        questions.add(enigma);
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
        Random random = new Random();
        int randomNumber = random.nextInt(arrQuestion.size());
        return arrQuestion.get(randomNumber);
    }
}
