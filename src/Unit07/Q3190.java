package Unit07;

import java.util.*;

public class Q3190 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = 0;

        int N = scanner.nextInt(); // 보드의 크기
        int K = scanner.nextInt(); // 사과의 개수

        int[][] apples = new int[N][N]; // 사과가 있는 곳은 1로 초기화
        for (int i = 0; i < K; i++) 
            apples[scanner.nextInt()-1][scanner.nextInt()-1] = 1;

        int L = scanner.nextInt(); // 뱀의 방향 전환 횟수
        HashMap<Integer, String> turn = new HashMap<>(); // 방향 전환 정보 저장 (X초 뒤, C 방향으로 전환)
        for (int i = 0; i < L; i++) {
            int X = scanner.nextInt();
            String C = scanner.next();
            turn.put(X, C);
        }

        int direction = 0; // 현재 뱀의 진행 방향 (오른쪽: 0, 아래: 1, 왼쪽: 2, 위: 3)
        int snakeX = 0, snakeY = 0; // 현재 뱀의 좌표
        ArrayDeque<int[]> exist = new ArrayDeque<>(); // 현재 뱀의 좌표를 저장
        exist.add(new int[] {snakeX, snakeY});
        
        boolean gameOver = false;

        // 1초마다 실행되는 과정 작성
        while (true) {
            time++;

            // 1. 뱀의 머리 이동 (X, Y)
            if (direction == 0) // 오른쪽 이동
                snakeY++;
            else if (direction == 1) // 아래로 이동
                snakeX++;
            else if (direction == 2) // 왼쪽 이동
                snakeY--;
            else if (direction == 3) // 위로 이동
                snakeX--;

            // 2. 종료 조건 검사
            if (snakeX < 0 || snakeX >= N || snakeY < 0 || snakeY >= N) // 벽에 부딪히는 경우
            	gameOver = true;
            
            for (int[] part : exist) 
                if (part[0] == snakeX && part[1] == snakeY)  // 자신의 몸에 부딪히는 경우
                    gameOver = true;
                
            if (gameOver)
            	break;
            else
            	exist.addFirst(new int[] {snakeX, snakeY}); // 종료되지 않으면 큐에 머리 위치 추가

            // 3. 사과 있는지 확인 (있으면 사과 없애고 꼬리는 그대로, 없으면 꼬리 삭제)
            if (apples[snakeX][snakeY] == 1)
                apples[snakeX][snakeY] = 0;
            else
                exist.pollLast(); // 꼬리 삭제

            // 4. 방향이 전환할 때가 되면 방향 처리
            if (turn.containsKey(time)) {
                String s = turn.get(time);
                if (s.equals("D")) // 오른쪽으로 회전
                    direction = (direction + 1) % 4; // 항상 양수로 유지
                else if (s.equals("L")) // 왼쪽으로 회전
                    direction = (direction + 3) % 4;
            }
        }
        System.out.println(time);
    }
}

/* < 자신의 몸에 부딪히는 경우 판단 - contains 사용 불가 >
 * 내가 쓴 코드: if (exist.contains(new int[] {snakeX, snakeY}))
 * 
 * contain() 메서드는 Object.equals() 메서드를 호출하여 객체 비교
 * -> 기본 equal() 메서드는 객체의 참조를 비교
 * 해겳법: equal() 메서드를 오버라이드하여 값을 비교하도록 구현
 * 내 해결법: 배열이니까 그냥 순회하면서 다 비교해보자 ^^...
 */