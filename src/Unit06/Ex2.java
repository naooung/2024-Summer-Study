package Unit06;

import java.util.Stack;

public class Ex2 {
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(6); 											// 6
		stack.push(5); 											// 5 6
		
		System.out.println(stack.peek());						// 반환: 5 (데이터 삭제 없
		System.out.println(stack.pop());						// 5 (최근 데이터 5 삭제)
		
		System.out.println("현재 stack의 크기: " + stack.size());	// 크기: 1
		
		stack.push(7);											// 7 6
		stack.push(4);											// 4 7 6
		
		System.out.println(stack.pop());						// 반환: 4 (최근 데이터 4 삭제)
		System.out.println(stack.pop());						// 반환: 7 (최근 데이터 7 삭제)
		System.out.println(stack.pop());						// 반환: 6 (최근 데이터 6 삭제)
		
		System.out.println("현재 stack의 크기: " + stack.size());	// 크기: 0
	}
}
