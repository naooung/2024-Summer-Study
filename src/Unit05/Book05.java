package Unit05;

import java.util.*;

public class Book05 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[][] arr1 = {{1, 4}, 
						{3, 2}, 
						{4, 1}};
		
		int[][] arr2 = {{3, 3},
						{3, 3}};
		
		// 1차원 이상의 배열 출력 메소드: deepToString()
		System.out.println(Arrays.deepToString(solution(arr1, arr2)));
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		
		// result 행렬의 크기: arr1의 행 * arr2의 열
		int[][] result = new int[arr1.length][arr2[0].length];
		
		for (int i = 0; i < arr1.length; i++)
			for (int j = 0; j < arr2[0].length; j++) 
				for (int k = 0; k < arr1[0].length; k++)
					result[i][j] += arr1[i][k] * arr2[k][j];
		
		/*
		 * arr1[0][0] * arr2[0][0] + arr1[0][1] * arr2[1][0]
		 * arr1의 열 증가, arr2의 행 증가 (arr1의 열이 끝날 때까지 반복)
		 * arr1의 행과 arr2의 열은 같은 값으로 고정
		 */
		
		return result;
	}
}
