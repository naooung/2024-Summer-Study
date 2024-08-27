package Unit05;

import java.util.*;

public class Book02 {
	
	public static void main(String[] args) {
		
		int[] array = { 4, 2, 2, 1, 3, 4 };
		
		System.out.println(Arrays.toString(solution(array)));
	}
	
	public static int[] solution(int[] array) {
		
		return Arrays.stream(array)
					// int > Integer: boxed()
					.boxed()
					
					// 중복값 제거 메소드: distinct()
					.distinct()
					
					// 스트림 역순 정렬 메소드: sorted + Comparator 인터페이스의 reverseOrder() - 582p
					// sorted()는 지정된 Comparator로 스트림 정렬
					.sorted(Comparator.reverseOrder())
					
					// Integer > int로 mapping: mapToInt() - 578p
					.mapToInt(Integer::intValue)
					
					// 배열 반환 메소드: toArray()
					.toArray();
	}
}
