# java-chess
체스 게임 구현을 위한 저장소

# 요구 사항 정의

## 체스말
- [x] 각각의 말이 흑백 여부 저장
- [x] 각각의 말에 위치 정보 저장
- [x] 폰
  - [x] 앞으로 한 칸 이동
    - [x] 앞에 말이 있는 경우 이동 불가
  - [x] 처음 이동인 경우 두 칸 이동 가능
  - [x] 전방의 대각선으로 이동하여 kill
- [x] 룩
  - [x] 상하좌우로 이동
    - [x] 뛰어 넘기 불가
  - [x] 상하좌우로 kill
- [x] 나이트
  - [x] 나이트 이동 방식으로 이동, kill (뛰어 넘기 가능)
- [x] 비숍
  - [x] 대각선으로 이동, kill
    - [x] 뛰어 넘기 불가
- [x] 퀸
  - [x] 상하좌우, 대각선으로 이동, kill
    - [x] 뛰어 넘기 불가
- [x] 킹
  - [x] 3x3 내에서만 이동, kill
    - [ ] 공격받을 자리로 이동 불가
    
## 위치 정보
- [x] (x,y) 좌표 를 정의
    - [x] 가능한 x 좌표를 enum 으로 정의 (a~h)
    - [x] 가능한 y 좌표를 enum 으로 정의 (1~8)

## 체스 게임
- [x] 체스 말 묶음 저장
- [x] start, end 입력에 따른 게임 시작 여부 결정
  - [x] `예외` start 와 end 가 아닌 입력이 들어온 경우
- [x] 입력 받은 이동 위치에 따라 행동 요령 결정
  - [ ] `예외` move 가 아닌 다른 명령을 입력한 경우
  - [ ] `예외` 입력한 위치가 2개가 아닌 경우
- [x] 체스 보드 출력
- [ ] 킹이 하나라도 죽으면 게임 종료 후 "status" 입력받아 각 플레이어 점수 출력
  - [ ] `예외` status 와 end 가 아닌 다른 명령을 입력한 경우