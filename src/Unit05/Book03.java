package Unit05;

import java.util.*;

public class Book03 {
	
	public static void main(String[] args) {
		
		int[] numbers = { 2, 1, 3, 4, 1 };
		
		System.out.println(Arrays.toString(solution(numbers)));
	}
	
	public static int[] solution(int[] numbers) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		// 중복 인덱스 값을 제외한 2개의 수의 합을 리스트에 추가
		for (int i = 0; i < numbers.length; i++) 
			for (int j = (i + 1); j < numbers.length; j++)
				list.add(numbers[i] + numbers[j]);
		
		// 중복 제거 > 오름차순 정렬 > 기본형으로 변환 > 배열로 변경
		return list.stream()
					.distinct()
					.sorted()
					.mapToInt(Integer::intValue)
					.toArray();
	}
}

/*	
 *	length		배열의 길이
 * 	length()	문자열의 길이
 *	size()		Collection, 자료구조의 크기
 */
