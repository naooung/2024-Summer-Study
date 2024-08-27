package Unit05;

import java.util.Scanner;

public class Q2563 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		// 흰색 도화지: 100 x 100 2차원 배열
		int[][] paper = new int[100][100];
		int area = 0;
		
		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			for (int a_dot = a; a_dot < a + 10; a_dot++) 
				for (int b_dot = b; b_dot < b + 10; b_dot++) 
					
					// 색종이가 붙여지지 않은 곳에 추가할 때만 실행
					if (paper[a_dot][b_dot] == 0) {
						paper[a_dot][b_dot] = 1;
						area++;
					}
		}	
		System.out.println(area);
	}
}
