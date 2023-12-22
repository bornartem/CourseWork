package com.example.course_work.controller;

import com.example.course_work.Question;
import com.example.course_work.service.ExaminerService;
import com.example.course_work.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable Integer amount){
        return examinerService.getQuestions(amount);
    }
}
