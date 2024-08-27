package Unit06;

import java.util.*;

public class Book08 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.next();
		
		System.out.println(solution(s));
	}
	
	public static boolean solution(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			// '('는 무조건 push()
			if (c == '(')
				stack.push(s.charAt(i));
			
			else if (c == ')') {
				// stack 내 데이터가 존재하면 '('와 한 쌍이 된 것으로 보아 최근의 '('을 pop()
				if (!stack.isEmpty())
					stack.pop();
				// stack 내 데이터가 없으면 더이상 짝이 될 수 없으므로 false 리턴
				else if (stack.isEmpty())
					return false;
			}
		}
		
		return stack.isEmpty();
	}
}
