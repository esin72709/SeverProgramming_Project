package com.example.mathgame.controller;

import com.example.mathgame.dto.AnswerRequestDto;
import com.example.mathgame.dto.AnswerResponseDto;
import com.example.mathgame.service.AnswerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public AnswerResponseDto submitAnswer(@RequestBody AnswerRequestDto dto) {
        return answerService.checkAnswer(dto);
    }
}
