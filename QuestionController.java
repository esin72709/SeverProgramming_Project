package com.example.mathgame.controller;

import com.example.mathgame.entity.Question;
import com.example.mathgame.service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Question getQuestion(@RequestParam int level) {
        return questionService.getRandomQuestionByLevel(level);
    }
}
