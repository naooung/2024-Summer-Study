package Unit06;

import java.util.*;

public class Book09 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		System.out.println(solution(n));
		
	}
	
	public static String solution(int n) {
		Stack<Integer> stack = new Stack<>();
		
		while (true) {
			stack.push(n % 2);
			
			if ((n / 2) < 2) {
				stack.push(n/2);
				break;
			}
			n /= 2;
		}
		
		// stack에 있는 모든 데이터 반환
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty())
			result.append(stack.pop());
		
		return result.toString();
	}
}
