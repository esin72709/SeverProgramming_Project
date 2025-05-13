package com.example.mathgame.service;

import com.example.mathgame.dto.AnswerResponseDto;
import com.example.mathgame.entity.GameRecord;
import com.example.mathgame.entity.Question;
import com.example.mathgame.repository.GameRecordRepository;
import com.example.mathgame.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final QuestionRepository questionRepository;
    private final GameRecordRepository gameRecordRepository;

    public AnswerService(QuestionRepository questionRepository, GameRecordRepository gameRecordRepository) {
        this.questionRepository = questionRepository;
        this.gameRecordRepository = gameRecordRepository;
    }

    public AnswerResponseDto checkAnswer(AnswerRequestDto dto) {
        Question question = questionRepository.findById(dto.getQuestionId())
                .orElseThrow(() -> new RuntimeException("문제를 찾을 수 없습니다."));

        GameRecord record = gameRecordRepository.findByUserId(dto.getUserId())
                .orElse(new GameRecord(null, dto.getUserId(), 0, 3, 0)); // 새로 시작

        boolean correct = dto.getSubmittedAnswer() == question.getAnswer();
        String message;

        if (correct) {
            record.setScore(record.getScore() + 30);
            record.setCoins(record.getCoins() + 5);
            message = "정답입니다! 점수와 코인이 올라갑니다.";
        } else {
            record.setLife(record.getLife() - 1);
            message = record.getLife() <= 0 ? "게임 오버!" : "오답입니다. 목숨이 줄었습니다.";
        }

        gameRecordRepository.save(record);

        return new AnswerResponseDto(correct, record.getScore(), record.getLife(), record.getCoins(), message);
    }
}
