package com.example.course_work.controller;

import com.example.course_work.Question;
import com.example.course_work.repository.JavaQuestionRepository;
import com.example.course_work.repository.MathQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionRepository javaQuestionRepository;

    @Autowired
    public JavaQuestionController(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, String answer) {
        return javaQuestionRepository.addQuestion(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question, String answer) {
        return javaQuestionRepository.removeQuestion(question, answer);
    }

    @GetMapping("/find")
    public Question find(@RequestParam("question") String question, String answer) {
        return javaQuestionRepository.findQuestion(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

}
