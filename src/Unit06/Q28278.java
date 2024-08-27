package Unit06;

import java.util.*;

// 백준에 제출할 때는 BufferedReader 사용
public class Q28278 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<>();
		int N = scanner.nextInt();
		
		for (int i = 0; i < N; i++) {
			int order = scanner.nextInt();
			
			switch (order) {
				// 1. 정수 X를 스택에 넣기
				case 1:
					int X = scanner.nextInt();
					stack.push(X);
					break;
				// 2. 스택에 정수가 있다면 맨 위의 정수를 빼고 출력, 없다면 -1을 대신 출력
				case 2:
					if (!stack.isEmpty()) {
						System.out.println(stack.pop());
					}
					else 
						System.out.println("-1");
					break;
				// 3. 스택에 들어있는 정수의 개수를 출력	
				case 3:
					System.out.println(stack.size());
					break;
				// 4. 스택이 비어있으면 1, 아니면 0을 출력
				case 4:
					System.out.println(stack.isEmpty() ? "1" : "0");
					break;
				// 5. 스택에 정수가 있다면 맨 위의 정수를 출력, 없다면 -1을 대신 출력
				case 5:
					if (!stack.isEmpty())
						System.out.println(stack.peek());
					else 
						System.out.println("-1");
					break;
			}
		}
	}
}
