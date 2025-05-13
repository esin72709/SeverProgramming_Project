package com.example.mathgame.service;

import com.example.mathgame.entity.Question;
import com.example.mathgame.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getRandomQuestionByLevel(int level) {
        List<Question> questions = questionRepository.findByLevel(level);
        if (questions.isEmpty()) {
            throw new RuntimeException("해당 난이도의 문제가 없습니다.");
        }
        return questions.get(new Random().nextInt(questions.size()));
    }
}