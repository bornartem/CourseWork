package com.example.course_work.controller;

import com.example.course_work.Question;
import com.example.course_work.repository.MathQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {

    private final MathQuestionRepository mathQuestionRepository;

    @Autowired
    public MathQuestionController(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, String answer) {
        return mathQuestionRepository.addQuestion(question, answer);
    }

    @GetMapping("/find")
    public Question find(@RequestParam("question") String question, String answer) {
        return mathQuestionRepository.findQuestion(question, answer);
    }

    @GetMapping("remove")
    public Question remove(@RequestParam("question") String question, String answer) {
        return mathQuestionRepository.removeQuestion(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }
}
