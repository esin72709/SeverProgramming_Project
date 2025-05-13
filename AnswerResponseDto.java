package com.example.mathgame.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AnswerResponseDto {
    private boolean correct;
    private int score;
    private int life;
    private int coins;
    private String message;
}