package Unit05;

import java.util.*;

public class Book04 {
	
	public static void main(String[] args) {
		
		int[] answers = { 1, 3, 2, 4, 2 };
		
		System.out.println(Arrays.toString(solution(answers)));
	}
	
	public static int[] solution(int[] answers) {
		
		int right1 = 0, right2 = 0, right3 = 0;
		
		// 1번 수포자: 12345 (5회마다 반복) 
		// student1[answer index % 5] == answers[index]
		int[] student1 = { 1, 2, 3, 4, 5 };
		
		// 2번 수포자: 21232425 (8회마다 반복)
		// student2[answer index % 8] == answers[index]
		int[] student2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		
		// 3번 수포자: 3311224455 (10회마다 반복)
		// student3[answer index % 10] == answers[index]
		int[] student3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == student1[i % 5])
				right1++;
			if (answers[i] == student2[i % 8])
				right2++;
			if (answers[i] == student3[i % 10])
				right3++;
		}
		
		ArrayList<Integer> winner = new ArrayList<>();
		
		// 맞힌 개수 비교 후 누구인지 리스트에 담아서 배열로 변환
		int max = Math.max(Math.max(right1, right2), right3);
		
		if (max == right1)
			winner.add(1);
		if (max == right2)
			winner.add(2);
		if (max == right3)
			winner.add(3);
		
		return winner.stream()
					 .sorted()
					 .mapToInt(Integer::intValue)
					 .toArray();
					
	}
}
