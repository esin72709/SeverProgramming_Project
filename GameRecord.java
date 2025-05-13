package com.example.mathgame.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "game_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;  // 유저 식별자
    private int score;    // 현재 점수
    private int life;     // 남은 목숨 (예: 최대 3)
    private int coins;    // 보유 코인
}
