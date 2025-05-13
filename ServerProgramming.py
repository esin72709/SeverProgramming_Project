import pymysql

# MySQL 연결 설정
conn = pymysql.connect(
    host='localhost',             # MySQL 서버 주소
    user='user',                  # MySQL 사용자 이름
    password='1234',              # MySQL 비밀번호
    database='ServerProgramming', # 사용할 데이터베이스 이름
    charset='utf8mb4'             # 문자 인코딩 방식
)

# 커서 객체 생성 (SQL 실행을 위한 객체)
cur = conn.cursor()

# 문제 데이터: 각 문제는 (난이도, 문제 표현식, 정답) 형식으로 정의
questions = [
    # easy - 유치원
    ('easy', '1 + 2', 3),
    ('easy', '2 + 3', 5),
    ('easy', '3 + 1', 4),
    ('easy', '4 - 1', 3),
    ('easy', '5 - 2', 3),
    ('easy', '2 + 5', 7),
    ('easy', '7 - 3', 4),
    ('easy', '6 + 1', 7),
    ('easy', '8 - 4', 4),
    ('easy', '3 + 3', 6),

    # medium - 초1~2
    ('medium', '8 + 5', 13),
    ('medium', '12 - 4', 8),
    ('medium', '3 * 4', 12),
    ('medium', '7 + 6', 13),
    ('medium', '16 - 9', 7),
    ('medium', '4 * 2', 8),
    ('medium', '11 + 7', 18),
    ('medium', '9 - 3', 6),
    ('medium', '2 * 5', 10),
    ('medium', '14 - 6', 8),

    # hard - 초3
    ('hard', '6 * 3 + 4', 22),
    ('hard', '(8 + 4) * 2', 24),
    ('hard', '18 / 3 + 7', 13),
    ('hard', '9 + 12 / 4', 12),
    ('hard', '(15 - 3) / 3', 4),
    ('hard', '7 * (2 + 1)', 21),
    ('hard', '20 / (2 + 2)', 5),
    ('hard', '(6 + 6) * 2', 24),
    ('hard', '30 / 5 + 2', 8),
    ('hard', '4 * 5 - 3', 17)
]

# 중복 체크 후 데이터 삽입 함수 정의
def insert_question(level, expression, answer):
    # 먼저 문제의 level, expression, answer가 동일한 항목이 이미 존재하는지 확인하는 쿼리
    cur.execute("""
        SELECT COUNT(*) FROM question  # 'question' 테이블에서 중복되는 문제를 찾기 위한 SELECT 쿼리
        WHERE level = %s AND expression = %s AND answer = %s
    """, (level, expression, answer))  # 사용자가 입력한 값이 쿼리에 바인딩됨
    
    # fetchone()은 결과에서 첫 번째 행을 반환 (중복 여부 체크)
    count = cur.fetchone()[0]
    
    if count == 0:  # 중복된 문제가 없으면 삽입
        # 문제 삽입 쿼리 실행
        cur.execute("""
            INSERT INTO question (level, expression, answer)
            VALUES (%s, %s, %s)  # 문제의 난이도, 표현식, 정답을 삽입
        """, (level, expression, answer))  # 사용자가 입력한 값이 쿼리에 바인딩됨
        print(f"문제 '{expression}' (정답: {answer}) 가 삽입되었습니다.")  # 삽입 성공 메시지 출력
    else:
        print(f"문제 '{expression}' (정답: {answer}) 가 이미 존재합니다.")  # 이미 존재하는 문제는 삽입하지 않음

# 데이터 삽입 시작: 'questions' 리스트에 있는 모든 문제를 차례로 삽입
for question in questions:
    insert_question(*question)  # 'question' 튜플의 값들을 인수로 전달하여 함수 실행

# 커밋: 쿼리 실행 후 반드시 커밋을 통해 변경 사항을 실제 DB에 반영
conn.commit()

# 커서 및 연결 종료
cur.close()
conn.close()
