package Unit05;

import java.io.*;

// 속도가 빠른 BufferReader 사용한 ver
public class Q17276_re {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(reader.readLine());
		
		for (int TestCase = 0; TestCase < T; TestCase++) {
			String[] input = reader.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int d = Integer.parseInt(input[1]);
			
			int[][] array = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				String[] row = reader.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					array[i][j] = Integer.parseInt(row[j]);
				}
			}
			
			int turnNum = ((d % 360) + 360) % 360 / 45;
			
			// 입력 각도에 따른 배열 회전
			for (int x = 0; x < turnNum; x++)
				array = turnArray(n, array);
			
			// 배열 출력
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(array[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.print(sb.toString());
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
