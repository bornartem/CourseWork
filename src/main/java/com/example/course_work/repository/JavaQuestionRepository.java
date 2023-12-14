package com.example.course_work.repository;

import com.example.course_work.Question;
import com.example.course_work.exception.QuestionAddedException;
import com.example.course_work.exception.QuestionNotFound;
import com.example.course_work.service.QuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
public class JavaQuestionRepository implements QuestionRepository {
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
        if (!questions.add(enigma)) {
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
}
