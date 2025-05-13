package com.example.mathgame.repository;

import com.example.mathgame.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByLevel(int level);  // 난이도별 문제 찾기
}
