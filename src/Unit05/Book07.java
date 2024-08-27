package Unit05;

import java.util.HashSet;

public class Book07 {
	
	public static void main(String[] args) {
		
		String dirs = "ULURRDLLU";
		
		System.out.println(solution(dirs));
	}
	
	public static int solution(String dirs) {
		// 초기 좌표평면
		int x = 0, y = 0;
		
		// 처음 걸어본 길만 저장하는 HashSet (좌표 ?중복 없음)
		
		HashSet<String> answer = new HashSet<>();
		
		for (int i = 0; i < dirs.length(); i++) {
			int subx = x, suby = y;
			char direction = dirs.charAt(i);
			
			// 이동 구현 (경계를 넘어가는 명령어는 제외)
			if (direction == 'U' && y < 5) {
                y += 1;
            } 
			else if (direction == 'D' && y > -5) {
                y -= 1;
            } 
			else if (direction == 'R' && x < 5) {
                x += 1;
            } 
			else if (direction == 'L' && x > -5) {
                x -= 1;
            }
			/*
			 * 중복된 길을 처리하기 위한 방법: 이동하는 좌표의 양 방향 저장
			 * 
			 * if. (3,2)에서 (4,2)로 이동할 때 HashSet에 저장되는 내용
			 * 		1. 3,2->4,2 
			 * 		2. 4,2->3,2
			 */
			if (subx != x || suby != y) {
                answer.add(subx + "," + suby + "->" + x + "," + y);
                answer.add(x + "," + y + "->" + subx + "," + suby);
            }
		}
		// 한 방향만 인정하여 반환
		return answer.size() / 2;
	}
}
