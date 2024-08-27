package Unit05;

import java.util.*;

public class Book06 {
	
	public static void main(String[] args) {
		
		int N = 5;
		int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
		
		System.out.println(Arrays.toString(solution(N, stages)));
	}
	
	// solution()의 시간 복잡도: O(stages.length + N logN)
	public static int[] solution(int N, int[] stages) {
		
		// HashMap (Key: 스테이지 & Value: 실패율) 
		HashMap<Integer, Double> failureRate = new HashMap<>();
		
		for (int i = 1; i <= N; i++) {
			int failedUser = 0, reachedUser = 0;
			
			for (int j = 0; j < stages.length; j++) {
				// 스테이지 i에 머물러 있는 User 수
				if (i == stages[j])
					failedUser++;
				
				// 스테이지 i에 도달한 User 수 (stages[User]의 값이 i보다 커야함)
				if (i <= stages[j])
					reachedUser++;
			}
			/*
			 *  reachedUser가 0인 경우(0/0) 결과: NaN (Not a Number)
			 *  reachedUser이 0인 경우 실패율 0 설정
			 */
			failureRate.put(i, reachedUser == 0 ? 0 : (double)failedUser / reachedUser);
		}
		
		// Value 값이 높은 순서부터 내림차순 정렬하여 배열 반환
		return failureRate.entrySet().stream()

									 /*
									  * HashMap 중 Value 오름차순 메소드	comparingByValue()
									  * Comparator 반전 메소드 			reverseOrder() or reversed() 
									  */
									 .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
									 
									 // HashMap.Entry 객체에서 Key 값을 가져와서 int로 mapping
								 	 .mapToInt(HashMap.Entry::getKey) 
									 .toArray();
	}
}
