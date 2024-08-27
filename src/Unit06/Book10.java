package Unit06;

import java.util.*;

public class Book10 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.next();
		
		System.out.println(solution(s));
	}
	
	// pair(짝)이 있는 경우는 Map 사용하자 제발 ~.~ 개고생하고 바보냐 이렇게 하면 경우들 처리 못하게 되면 틀리는겨
	public static int solution(String s) {
		 
		int correctStr = 0;
		int slen = s.length();
		
		for (int x = 0; x < slen; x++) {
			Stack<Character> stack = new Stack<>();
			boolean matching = true;
			
			for (int y = 0; y < slen; y++) {
				char c = s.charAt((x + y) % slen);
				
				// 열린 괄호인 경우
				if (c == '(' || c == '[' || c == '{')
					stack.push(c);
				
				// 닫힌 괄호인 경우
				else {
					if (stack.isEmpty()) {
						matching = false; // 비어있는 상태에서 닫힌 괄호가 온 경우
						break;
					}
					
					char recentc = stack.peek();
					if (c == ')' && recentc == '(' || 
						c == ']' && recentc == '[' || 
						c == '}' && recentc == '{') 
						stack.pop();
					else {
						matching = false; // 열린 괄호 이후에 잘못된 닫힌 괄호가 온 경우
						break;
					}
				}
			}
			// stack이 비어있고 닫힌 괄호로 끝나지 않으면 모두가 짝이므로 올바른 문자열에 해당
			if (stack.isEmpty() && matching)
				correctStr++;
		}
		return correctStr;
	}
}
