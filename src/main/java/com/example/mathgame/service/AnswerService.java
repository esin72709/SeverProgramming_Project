package com.example.mathgame.service;

import com.example.mathgame.dto.AnswerRequestDto;
import com.example.mathgame.dto.AnswerResponseDto;
import com.example.mathgame.entity.GameRecord;
import com.example.mathgame.entity.Question;
import com.example.mathgame.entity.User;
import com.example.mathgame.repository.GameRecordRepository;
import com.example.mathgame.repository.QuestionRepository;
import com.example.mathgame.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final GameRecordRepository gameRecordRepository;

    public AnswerService(QuestionRepository questionRepository,
                         UserRepository userRepository,
                         GameRecordRepository gameRecordRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.gameRecordRepository = gameRecordRepository;
    }

    public AnswerResponseDto checkAnswer(AnswerRequestDto request) {
        Question question = questionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> new IllegalArgumentException("Question not found"));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        boolean isCorrect = question.getAnswer() == request.getUserAnswer();
        int score = isCorrect ? 10 : 0;

        if (isCorrect) {
            // 게임 기록 저장
            GameRecord record = new GameRecord(user, score, question.getLevel());
            gameRecordRepository.save(record);

            // 코인 지급
            user.setCoin(user.getCoin() + 5);
            userRepository.save(user);
        }

        return new AnswerResponseDto(isCorrect, score);
    }
}
