package Unit05;

import java.util.Scanner;

public class Q17276 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for (int TestCase = 0; TestCase < T; TestCase++) {
			int n = scanner.nextInt();
			int[][] array = new int[n][n];
			int d = scanner.nextInt();
			
			for (int i = 0; i < n; i++) 
				for (int j = 0; j < n; j++) 
					array[i][j] = scanner.nextInt();
			
			int turnNum = d < 0 ? (360 + d) / 45 : d / 45;
			
			// 입력 각도에 따른 배열 회전
			for (int x = 0; x < turnNum; x++)
				array = turnArray(n, array);
			
			// 배열 출력
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					System.out.print(array[i][j] + " ");
				System.out.println();
			}
		}
	}
	
	// 배열을 45도 회전시키는 메소드
	public static int[][] turnArray(int n, int[][] array) {
		int[][] result = new int[n][n];
		
		// 2차원 배열의 깊은 복사 수행
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < n; j++) 
				result[i][j] = array[i][j];
		
		for (int i = 0; i < n; i++) {
			// 주 대각선을 가운데 열로 옮긴다
			result[i][n/2] = array[i][i];
			
			// 가운데 열을 부 대각선으로 옮긴다
			result[i][n-i-1] = array[i][n/2];
			
			// 부 대각선을 가운데 행으로 옮긴다
			result[n/2][n-i-1] = array[i][n-i-1];
			
			// 가운데 행을 주 대각선으로 옮긴다
			result[i][i] = array[n/2][i];
		}
		
		return result;
	}
}

/* 
 * 배열의 깊은 복사: 원래 배열을 그대로 가져오는 것
 * 배열의 얕은 복사: 원래 배열의 주소값을 가져오는 것
 * 		ex) result = array.clone();
 * 
 * 1차원 배열: clone() 사용 가능
 * 2차원 배열: arraycopy() / 2중 반복문 사용
 * 			 깊은 복사만 가능 > clone() 사용 불가
 * 객체 배열:	 반복문, clone(), arraycopy() 모두 사용 가능 
 */
