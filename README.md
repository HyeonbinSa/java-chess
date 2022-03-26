# java-chess

체스 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

# 1단계 - 체스판 초기화

### 입력

- [x] 게임 시작 시 사용자로부터 시작 및 종료를 입력받는다.
    - [x] null이나 empty일 수 없다.
    - [x] `start` 또는 `end` 이외의 값을 입력할 수 없다.

### 출력

- [x] 체스판을 출력한다.
    - [x] 체스판에는 위치 값이 존재한다.
        - [x] 가로 위치는 왼쪽부터 a~h이다.
        - [x] 세로 위치는 아래부터 위로 1~8이다.
    - [x] 각 진영은 검은색(대문자)과 흰색(소문자) 편으로 구분한다.

# 2단계 - 말 이동

### 입력

- [ ] 게임 시작 시 사용자로부터 `시작`, `종료`, `이동` 중 하나를 입력받는다.
    - [ ] 게임 이동시 `move source위치 target위치`를 입력한다.
        - [ ] 체스 보드 외의 범위를 입력할 수 없다.
        - [ ] 이동할 수 없는 위치를 입력할 수 없다.
        - [ ] 플레이어는 자신의 말만 이동할 수 있다.
    - [ ] 이외의 값을 입력할 수 없다.

### 출력

- [ ] 명령어 입력 시 변경된 체스판을 출력한다.

### 말 이동

- [ ] 흰색 플레이어부터 시작한다.
- [ ] 플레이어는 자신의 말만 이동할 수 있다.
- [ ] 한 칸에 한 개의 말이 존재한다.
- [ ] 말은 다른 말을 통과할 수 없다(단, Knight는 다른 말을 뛰어넘을 수 있다).
- [x] 각 말은 고유한 규칙에 따라 움직일 수 있다.
    - [x] Pawn
        - [x] `첫 이동`이라면, `앞으로 두 칸` 이동할 수 있다.
        - [x] `앞으로 한 칸` 이동한다.
        - [x] 적이 `앞으로 대각선 한 칸`에 존재하면 공격할 수 있다.
    - [x] Rook
        - `상하좌우`를 원하는 만큼 이동할 수 있다.
    - [x] Knight
        - [x] `앞으로 한 칸, 대각선 한칸 L자 모양`으로 이동할 수 있다.
        - [x] 기물 중 유일하게 다른 말을 뛰어넘을 수 있다.
    - [x] Bishop
        - `대각선`을 원하는 만큼 이동할 수 있다.
    - [x] Queen
        - `상하좌우`와 `대각선`을 원하는 만큼 이동할 수 있다.
    - [x] King
        - `어느 방향이든 한 칸` 이동할 수 있다.
- [x] 말 이동 상세
    - [x] 공통
        - [x] 기물 고유 규칙에 따라 이동할 수 있는 위치여야한다.
    - [x] Pawn
        - [ ] 이동
            - [x] 직진(앞으로) 한칸 이동 가능하며 목적지에 기물이 없어야한다.
            - [x] 첫 이동이라면 두칸 이동할 수 있다.
            - [x] 두칸을 이동한다면 가는 길에 기물이 없어야한다.
        - [x] 공격
            - [x] 대각선으로만 공격이 가능하다.
            - [x] 이동 위치에 상대방의 기물이 존재하여야한다.
    - [x] 기본
        - [x] 목적지가 상대방의 기물이 있거나 공백이어야 한다.
        - [x] 이동하는 길목에 기물이 존재한다면 이동할 수 없다.
