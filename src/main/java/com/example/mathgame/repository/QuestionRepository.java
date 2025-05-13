package com.example.mathgame.repository;

import com.example.mathgame.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByLevel(String level);  // 난이도로 문제 찾기
}
