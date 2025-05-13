package com.example.mathgame.dto;

public class AnswerResponseDto {
    private boolean correct;
    private int score;

    public AnswerResponseDto(boolean correct, int score) {
        this.correct = correct;
        this.score = score;
    }

    public boolean isCorrect() {
        return correct;
    }

    public int getScore() {
        return score;
    }
}
