package Unit05;

import java.util.Scanner;

public class Q2167 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 2차원 배열 생성
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[][] array = new int[N][M];
		
		for (int n = 0; n < N; n++) 
			for (int m = 0; m < M; m++)
				array[n][m] = scanner.nextInt();
		
		// 합을 구할 부분의 개수
		int K = scanner.nextInt();
		
		for (int k = 0; k < K; k++) {
			// 시작 위치
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			
			// 마지막 위치
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int sum = 0;
			
			// 행 반복 횟수: i ~ x 
			for (int a = i; a <= x; a++)
				//열 반복 횟수: j ~ y
				for (int b = j; b <= y; b++) 
					sum += array[a-1][b-1];
					
			System.out.println(sum);
		}
	}
}
