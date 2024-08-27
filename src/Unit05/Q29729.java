package Unit05;

import java.util.*;

public class Q29729 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int Size = scanner.nextInt(); 	// 현재 최대 크기
		int Using = 0;					// 현재 사용 중인 크기
		int[] array = new int[Size];
		
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		for (int i = 0; i < N + M; i++) {
			int input = scanner.nextInt();
			if (input == 1) {
				
				// 배열이 꽉 차있는 경우, Size * 2 크기의 새로운 배열 생성
				if (Size == Using) {
					Size *= 2;
					array = Arrays.copyOf(array, Size);
				}
				Using++;
			}
			
			if (input == 0) 
				Using--;
		}
		System.out.println(Size);
	}
}
