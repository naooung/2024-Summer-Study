package Unit06;

import java.util.*;

public class Book11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.next();
		
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			
			// 최근 데이터 존재
			// 최근 데이터의 값과 같은 알파벳(짝)인 경우
			if (!stack.isEmpty() && s.charAt(i) == stack.peek())
					stack.pop();
			
			// stack에 데이터 미존재 or 다른 알파벳인 경우
			else
				stack.push(s.charAt(i));
		}
		
		if (stack.isEmpty())
			return 1;
		else 
			return 0;
	}
}
