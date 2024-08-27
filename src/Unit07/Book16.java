package Unit07;

import java.util.*;

public class Book16 {
	
	public static void main(String[] args) {
		
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
		
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		// deque에 progresses 인덱스 저장
		for (int i = 0; i < progresses.length; i++)
			deque.add(i);
		
		while (!deque.isEmpty()) {
			int count = 0; // 하루에 배포되는 기능의 개수
			
			// 하루가 지날 때마다 각 작업 진도에 개발 속도를 더해줌
			for (int i = 0; i < progresses.length; i++)
				progresses[i] += speeds[i]; 
			
			while (!deque.isEmpty() && progresses[deque.peekFirst()] >= 100) {
				// 100% 넘으면 배포 
				// 배포 개수 계산
				// > progresses[deque의 맨 앞] 값이 100이 넘었는지 확인 후 deque에서 해당 인덱스 값 삭제
				deque.pollFirst();
				count++;
			}
			
			if (count > 0)
				list.add(count);
		}
		
		return list.stream()
				   .mapToInt(Integer::intValue)
				   .toArray(); // ArrayList > Array 과정
	}
}
