package Unit06;

import java.util.*;

public class Book12 {

	public static void main(String[] args) {
		
		int[] prices = { 1, 2, 3, 2, 3 };
		
		System.out.println(Arrays.toString(solution(prices)));
	}
	
	public static int[] solution(int[] prices) {
		
		// 책보고 풂... 
		int arrlength = prices.length;
		int[] result = new int[arrlength];
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < arrlength; i++) {
			
			// 가격이 떨어지는 경우에 전의 인덱스 확정 가능
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int before = stack.pop();
				result[before] = i - before;
			}
			
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			int before = stack.pop();
			result[before] = arrlength - 1 - before;
		}
		
		return result;
		
/*		< 시간 복잡도: O(n^2) >
  
 		int[] result = new int[5];
		int arrlength = 5;
		
		for (int i = 0; i < arrlength; i++) {
			for (int j = i+1; j < arrlength - 1; j++) {
				result[i]++;
				if (prices[i] > prices[j]) // 가격이 떨어지면 반복문 탈출
					break;
			}
		}
		
		return result;
*/	}
}
