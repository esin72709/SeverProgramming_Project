package com.example.mathgame.controller;

import com.example.mathgame.entity.Question;
import com.example.mathgame.service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping
    public Question getQuestion(@RequestParam String level) {
        return service.getRandomQuestion(level);
    }
}
