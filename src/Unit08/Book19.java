package Unit08;

import java.util.*;

public class Book19 {
	
	public static void main(String[] args) {
		
		String[] participant = {"marina", "josipa", "mikola", "marina"};
		String[] completion = {"marina", "josipa", "mikola"};
		
		System.out.println(solution(participant, completion));
	}
	
	public static String solution(String[] participant, String[] completion) {
		String failure = "";
		
		// Map에 (참가자 이름, 해당 이름 인원수)
		HashMap<String, Integer> people = new HashMap<>();
		for (String i : participant) {
			if (people.containsKey(i))
				people.put(i, people.get(i) + 1); // 동명이인이면 인원수 변경
			else
				people.put(i, 1);
		}
		
		// 완주자와 같은 이름을 가지고 있으면 인원수 제거
		for (String i : completion) {
			if (people.containsKey(i))
				people.put(i, people.get(i) - 1); 
		}
		
		// 인원수 값이 0이 아닌 사람 (완주 못한 사람) 찾아서 출력
		for (String i : participant) {
			if (people.get(i) != 0) {
				failure = i;
				break;
			}
		}
		return failure;
	}
}
