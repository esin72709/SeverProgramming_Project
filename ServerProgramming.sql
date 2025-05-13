-- 1. 난이도에 따른 사칙연산 문제 저장
CREATE TABLE question (
    id INT AUTO_INCREMENT PRIMARY KEY,                           -- 문제 고유 ID
    level ENUM('easy', 'medium', 'hard') NOT NULL,               -- 문제 난이도 (쉬움, 보통, 어려움)
    expression VARCHAR(50) NOT NULL,                             -- 문제 표현식 (예: '3 + 4')
    answer INT NOT NULL                                          -- 문제의 정답 값
);
