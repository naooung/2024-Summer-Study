package Unit06;

import java.util.Stack;

public class Ex1 {
	
	public static void main(String[] args) {
		
		// Stack 객체 생성
		Stack<Integer> stack = new Stack<>();
		
		// 스택에 값 삽입
		stack.push(1);
		stack.push(3);
		
		System.out.println(stack.isEmpty());
		
		// 스택에 있는 값 중 가장 나중에 삽입된 데이터부터 반환 후 삭제
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack.isEmpty());
		
		
	}
}

/* < Stack 관련 메소드 >
 * 
 * push()		데이터 푸시
 * pop()		최근 푸시한 데이터를 팝하고 데이터 반환
 * 
 * isFull()		스택에 들어있는 데이터가 가득 차 있는지 확인하여 boolean 반환
 * 				데이터를 푸시(삽입)할 때 확인하는 용도로 사용 가능
 * isEmpty()	스택에 들어있는 데이터가 하나도 없는지 확인하여 boolean 반환
 * 				데이터를 (삭제)할 때 확인하는 용도로 사용 가능
 */