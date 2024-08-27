package Unit06;

import java.util.*;

public class Q12605 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		scanner.nextLine();
		
		for (int i = 0; i < N; i++) {
			String s = scanner.nextLine();
			Stack<String> stack = new Stack<>();
			
			// 입력받은 문자열을 공백을 기준으로 분리하고, 입력받은 단어 순서대로 push()
			StringTokenizer token = new StringTokenizer(s);
			while (token.hasMoreTokens())
				stack.push(token.nextToken());
			
			// 단어 뒤에서부터 출력
			System.out.print("Case #" + (i + 1) + ": ");
			
			while (!stack.isEmpty())
				System.out.print(stack.pop() + " ");
			System.out.println();
		}
	}
}
