# Math Game Backend (기능 2개 구현)

## ✅ 구현 기능
1. 사칙연산 문제 출제 (`QuestionController`, `QuestionService`, `Question` 엔티티)
2. 정답 처리 및 점수 계산 (`AnswerController`, `AnswerService`, `GameRecord`)

## 🛠️ 실행 방법
1. `build.gradle`로 프로젝트 실행
2. 메인 클래스: `MathgameApplication.java`
3. 기본 포트: `localhost:8080`

## 📁 최소 파일 구성
- controller: 문제 출제, 정답 확인 API
- service: 문제 생성, 정답 판별 로직
- dto: 정답 요청/응답
- entity: 문제, 점수 기록
- repository: 문제/점수 저장용 JPA
