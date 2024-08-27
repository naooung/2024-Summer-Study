package Unit06;

import java.util.*;

public class Q2504 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		
		HashMap<Character, Character> pair = new HashMap<>();
		pair.put('(', ')');
		pair.put('[', ']');
		
		Stack<Character> stack = new Stack<>();
		int value = 0; // 최종 값, 더하기 전용 변수
		int subValue = 1; // 곱하기 전용 변수
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			// 여는 괄호인 경우
			if (c == '(' || c == '[') {
				stack.push(c);
				if (c == '(')
					subValue *= 2;
				if (c == '[')
					subValue *= 3;
			}
			
			// 닫는 괄호인 경우
			else {
				// 빈 스택이거나 짝이 맞지 않은 경우
				if (stack.isEmpty() || pair.get(stack.peek()) != c) {
					stack.push(c);
					break;
				}
				// 짝인 경우
				else if (pair.get(stack.peek()) == c) {
					if (c == ')') {
						stack.pop();
						// 전에 오는 문자가 동일한 괄호가 아니면 값 확정
						if (i > 0 && s.charAt(i - 1) == '(') 
	                        value += subValue;
	                    subValue /= 2;
					}
					else if (c == ']') {
						stack.pop();
						if (i > 0 && s.charAt(i - 1) == '[') 
	                        value += subValue;
						subValue /= 3;
					}
				}
			}
		}
		System.out.println(stack.isEmpty() ? value : 0);
	}
}