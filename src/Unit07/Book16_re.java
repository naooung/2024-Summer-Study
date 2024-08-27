package Unit07;

import java.util.*;

public class Book16_re {

	public static void main(String[] args) {
		
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
	
		int function = progresses.length;
		
		// 100%가 되기까지 걸리는 일수를 배열에 저장
		int[] days = new int[progresses.length];
		for (int i = 0; i < function; i++) 
			days[i] = (int) Math.ceil((100 - progresses[i]) / speeds[i]); // 반올림 필요
		
		ArrayList<Integer> result = new ArrayList<>();
		int max = days[0]; // 비교 기준일
		int count = 0; // 하루에 배포되는 기능 수
		
		for (int i = 0; i < function; i++) {
			if (max >= days[i])
				count++;
			else {
				result.add(count);
				count = 1;
				max = days[i];
			}
		}
		result.add(count);
		
		return result.stream()
				   .mapToInt(Integer::intValue)
				   .toArray(); // ArrayList > Array 과정
	}
}
