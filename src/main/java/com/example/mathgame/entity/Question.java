package com.example.mathgame.entity;

import jakarta.persistence.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String level;      // easy, medium, hard
    private String content;    // "3 + 5"
    private int answer;

    // 기본 생성자 (JPA 필수)
    public Question() {}

    // 생성자
    public Question(String level, String content, int answer) {
        this.level = level;
        this.content = content;
        this.answer = answer;
    }

    // Getter/Setter
    public Long getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public String getContent() {
        return content;
    }

    public int getAnswer() {
        return answer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
