package com.example.mathgame.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int level; // 난이도 (0: 초급, 1: 중급, 2: 고급)
    private String content; // 예: "3 + 5"
    private int answer; // 정답 숫자
}
