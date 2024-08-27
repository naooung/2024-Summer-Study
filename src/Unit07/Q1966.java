package Unit07;

import java.util.*;

public class Q1966 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int test = scanner.nextInt();
		
		for (int i = 0; i < test; i++) {
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			
			ArrayDeque<Integer> deque = new ArrayDeque<>(); // deque에는 인덱스 저장
			int[] important = new int[N]; // Array에는 중요도 저장
			int count = 0;
			
			for (int j = 0; j < N; j++) {
				important[j] = scanner.nextInt();
				deque.add(j);
			}
			
			while (true) {
				// 최대 중요도 값 찾기
				int max = important[0];
				for (int j = 1; j < N; j++) 
					if (max < important[j])
						max = important[j];
				
				// 최대 중요도 값이 나올 때까지 deque의 맨 뒤로 이동
				while (important[deque.peekFirst()] != max)
					deque.addLast(deque.pollFirst());
				
				// 최대 중요도는 인쇄하고 deque에서 삭제
				int printing = deque.pollFirst();
				count++;
					
				// 찾는 인덱스 번호라면 몇번째로 인쇄됐는지 출력
				if (printing == M) {
					System.out.println(count);
					break;
				}
				
				important[printing] = 0; // 중요도 값에서 제외
			}
		}
	}
}
