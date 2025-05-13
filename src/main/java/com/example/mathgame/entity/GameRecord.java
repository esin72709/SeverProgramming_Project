package com.example.mathgame.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class GameRecord {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private int score;
    private String level;
    private LocalDateTime playedAt = LocalDateTime.now();

    public GameRecord() {}

    public GameRecord(User user, int score, String level) {
        this.user = user;
        this.score = score;
        this.level = level;
    }

    // getter/setter 생략 가능
}
