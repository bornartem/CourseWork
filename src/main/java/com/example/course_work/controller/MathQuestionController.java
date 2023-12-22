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
    private final QuestionService mathQuestionService;

    @Autowired
    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }


    @GetMapping("/add")
    public Question add(@RequestParam("question") String question, String answer) {
        return mathQuestionService.addQuestion(question, answer);
    }

    @GetMapping("/find")
    public Question find(@RequestParam("question") String question, String answer) {
        return mathQuestionService.findQuestion(question, answer);
    }

    @GetMapping("remove")
    public Question remove(@RequestParam("question") String question, String answer) {
        return mathQuestionService.removeQuestion(question, answer);
    }

    @GetMapping
    public Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }
}
