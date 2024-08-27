package Unit07;

import java.util.*;

public class Book17 {
	
	public static void main(String[] args) {
		
		String[] cards1 = {"i", "water", "drink"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};
		
		System.out.println(solution(cards1, cards2, goal));
	}
	
	public static String solution(String[] cards1, String[] cards2, String[] goal) {
		
		ArrayDeque<String> deque1 = new ArrayDeque<>();
        for (int i = 0; i < cards1.length; i++)
            deque1.add(cards1[i]);
        ArrayDeque<String> deque2 = new ArrayDeque<>();
        for (int i = 0; i < cards2.length; i++)
            deque2.add(cards2[i]);
        
        for (int i = 0; i < goal.length; i++) {
            String word = goal[i];
            
            if (!deque1.isEmpty() && word.equals(deque1.peekFirst())) {
                deque1.pollFirst();
                continue;
            }
            
            if (!deque2.isEmpty() && word.equals(deque2.peekFirst())) {
                deque2.pollFirst();
                continue;
            }
            
            return "No"; // 만들 수 없는 경우
        }
        
        return "Yes"; // 반복문이 다 돌아가면 만들 수 있는 경우를 뜻함
	}
}
