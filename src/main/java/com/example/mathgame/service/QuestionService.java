package com.example.mathgame.service;

import com.example.mathgame.entity.Question;
import com.example.mathgame.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestionService {

    private final QuestionRepository repo;

    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }

    public Question getRandomQuestion(String level) {
        List<Question> questions = repo.findByLevel(level);

        if (questions.isEmpty()) {
            throw new IllegalStateException("No questions available for level: " + level);
        }

        int index = new Random().nextInt(questions.size());
        return questions.get(index);
    }
}
