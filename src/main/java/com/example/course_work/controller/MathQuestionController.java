package com.example.course_work.controller;

import com.example.course_work.Question;
import com.example.course_work.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final QuestionService questionService;

    @Autowired
    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, String answer) {
        return questionService.addQuestion(question, answer);
    }

    @GetMapping("/find")
    public Question find(@RequestParam("question") String question, String answer) {
        return questionService.findQuestion(question, answer);
    }

    @GetMapping("remove")
    public Question remove(@RequestParam("question") String question, String answer) {
        return questionService.removeQuestion(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
