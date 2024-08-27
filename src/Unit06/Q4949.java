package Unit06;

import java.util.*;

public class Q4949 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		HashMap<Character, Character> pair = new HashMap<>();
		pair.put('(', ')');
		pair.put('[', ']');
		
		while (true) {
			String s = scanner.nextLine();
			
			if (s.equals("."))
				break;
			
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				
				if (c == '(' || c == '[')
					stack.push(c);
				
				else if (c == ')' || c == ']') {
					// 괄호의 짝이 있는지 확인
					if (!stack.isEmpty() && pair.get(stack.peek()) == c)
						stack.pop();
					else {
						stack.push(c); // 닫힌 괄호로 끝나므로 균형 X
						break;
					}
				}
			}
			System.out.println(stack.isEmpty() ? "yes" : "no");
		}
	}
}
