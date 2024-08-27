package Unit06;

import java.util.Stack;

public class Book13 {
	
	public static void main(String[] args) {

		int board[][] = { {0, 0, 0, 0, 0},
						  {0, 0, 1, 0, 3},
						  {0, 2, 5, 0, 1},
						  {4, 2, 4, 4, 2},
						  {3, 5, 1, 3, 1} };
		int moves[] = {1, 5, 3, 5, 1, 2, 1, 4};
		
		System.out.println(solution(board, moves));
		
	}
	
	public static int solution(int[][] board, int[] moves) {
		// 스택 생성
		Stack<Integer>[] stack = new Stack[board.length];
		for (int i = 0; i < board.length; i++) {
			stack[i] = new Stack<>();
		}
		
		// 배열을 스택에 담기
		for (int i = board.length - 1; i >= 0; i--) 
			for (int j = board[0].length - 1; j >= 0; j--)
				if (board[i][j] > 0)
					stack[j].push(board[i][j]);
		
		// 크레인이 moves 배열에 있는 값을 바구니로 옮기는 과정
		Stack<Integer> bucket = new Stack<>();
		int boom = 0; 
		
		for (int crane = 0; crane < moves.length; crane++) {
			
			// stack 배열이 비지 않은 경우에만 실행
			if (!stack[moves[crane] - 1].isEmpty()) {
				int toy = stack[moves[crane] - 1].pop();
			
				if (!bucket.isEmpty() && bucket.peek() == toy) {
					bucket.pop();
					boom += 2;
				}
				else
					bucket.push(toy);
			}
		}
		return boom;
	}
}
