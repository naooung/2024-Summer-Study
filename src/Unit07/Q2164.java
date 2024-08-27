package Unit07;

import java.util.*;

public class Q2164 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		
		ArrayDeque<Integer> card = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) 
			card.add(i);
		
		while (card.size() > 1) {
			// 제일 위에 있는 카드를 버린다.
			card.pollFirst();
			// 다음 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
			card.addLast(card.pollFirst());
		}
		
		System.out.println(card.poll());
	}
}
