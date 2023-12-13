package com.example.courseWork.controller;

import com.example.courseWork.Question;
import com.example.courseWork.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Random;

@RestController
@RequestMapping("/exam/java")
public class JavaController {

    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, String answer) {
        Question enigma = new Question(question, answer);
        return questionService.addQuestion(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question, String answer) {
        return questionService.removeQuestion(question, answer);
    }

    @GetMapping("/find")
    public Question find(@RequestParam("question") String question, String answer) {
        return questionService.findQuestion(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

}
