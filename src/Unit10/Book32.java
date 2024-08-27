package Unit10;

import java.util.*;

public class Book32 {

	public static void main(String[] args) {
		
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		
		System.out.println(Arrays.toString(solution(n, words)));
	}
	
	public static int[] solution(int n, String[] words) {
		
		int[] result = {0, 0};
		
		HashSet<String> speaking = new HashSet<>();
		char lastWord = words[0].charAt(0);
		
		for (int i = 0; i < words.length; i++) {
			
			// 동일한 단어 or 앞사람의 마지막 철자와 말한 첫번째 철자가 다를 때
			if (speaking.contains(words[i]) || lastWord != words[i].charAt(0)) {
				
				result[0] = (i % n) + 1; // 가장 먼저 탈락하는 사람 번호
				result[1] = (i / n) + 1; // 자신이 몇번째로 말할 때 탈락하는지
				
				break;
			}
			else {
				speaking.add(words[i]);
				lastWord = words[i].charAt(words[i].length() - 1);
			}
		}
		
		return result;
	}
}
