package com.example.courseWork.controller;

import com.example.courseWork.Question;
import com.example.courseWork.service.ExaminerService;
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
