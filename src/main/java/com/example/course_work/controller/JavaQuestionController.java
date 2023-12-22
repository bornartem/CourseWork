package com.example.course_work.controller;

import com.example.course_work.Question;
import com.example.course_work.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService javaQuestionService;

    @Autowired
    public JavaQuestionController(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }


    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, String answer) {
        return javaQuestionService.addQuestion(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam("question") String question, String answer) {
        return javaQuestionService.removeQuestion(question, answer);
    }

    @GetMapping("/find")
    public Question find(@RequestParam("question") String question, String answer) {
        return javaQuestionService.findQuestion(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

}
