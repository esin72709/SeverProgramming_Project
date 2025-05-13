package com.example.mathgame.repository;

import com.example.mathgame.entity.GameRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRecordRepository extends JpaRepository<GameRecord, Long> {
    Optional<GameRecord> findByUserId(Long userId);  // 유저 ID로 게임 기록 찾기
}
