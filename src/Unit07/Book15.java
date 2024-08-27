package Unit07;

import java.util.*;

public class Book15 {
	
	public static void main(String[] args) {
		int N = 5;
		int K = 2;
		
		System.out.println(solution(N, K));
	}
	
	public static int solution(int N, int K) {
		
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++)
			deque.add(i);
		
		while (deque.size() > 1) {
			
			for (int i = 0; i < K - 1; i++) 
				deque.addLast(deque.pollFirst());
			
			deque.poll();
		}
		
		return deque.poll(); // 마지막 남은 데이터 반환
	}
}
