package Unit06;

import java.util.*;

public class Q10799 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.next();
		int rod = 0;
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			// 여는 괄호인 경우, 스택에 푸시
			if (c == '(')
				stack.push(c);
			
			// 닫는 괄호가 레이저인 경우, rod += 현재 '(' 개수
			else if (s.charAt(i - 1) == '(') {
				stack.pop();
				rod += stack.size();
			}
				
			// 닫는 괄호가 쇠막대기인 경우, rod += 1
			else {
				stack.pop();
				rod += 1;
			}
		}
		System.out.println(rod);
	}
}
