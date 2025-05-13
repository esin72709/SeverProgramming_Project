package com.example.mathgame.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequestDto {
    private Long userId;
    private Long questionId;
    private int submittedAnswer;
}