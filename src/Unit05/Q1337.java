package Unit05;

import java.util.*;

public class Q1337 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		ArrayList<Integer> array = new ArrayList<>();
		
		for (int i = 0; i < N; i++) 
			array.add(scanner.nextInt());
		
		// 추가해야 되는 원소의 최소 개수
		int min = 4;
		
		for (int i = 0; i < N; i++) {
			int need = 4;
			
			// 배열 전체 요소에서 (index + 1) ~ (index + 4) 범위의 수가 있는지 조사
			for (int j = array.get(i) + 1; j <= array.get(i) + 4; j++) {
				if (array.contains(j))
					need--;
			}
			
			if (need < min)
				min = need;
		}
		System.out.println(min);
	}	
}

/*
 * < Two 포인터 알고리즘 >
 * 
 * 리스트에 순차적으로 접근해야 할 때 두 개의 점 위치를 기록하면서 처리하는 알고리즘
 * 
 * for (int start = 0; start < T; i++) {
 *  int end = start;
 *  
 *  while (end < T && list.get(end) <= list.get(start) + 4)
 *      end++;
 */
