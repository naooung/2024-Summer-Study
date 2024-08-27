package Unit08;

import java.util.*;

public class Book24 {
	
	public static void main(String[] args) {
		
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2, 3, 4};
		
		System.out.println(Arrays.toString(solution(orders, course)));
	}
	
	// Map <코스 개수 i에 맞는 만들 수 있는 조합, 그 조합의 주문 횟수>
	static HashMap<String, Integer> combination;
	
	public static String[] solution(String[] orders, int[] course) {
		ArrayList<String> result = new ArrayList<>();
		
		for (int c : course) {
			
			// makeCombination에서 조합을 HashMap에 추가
			combination = new HashMap<>();
			for (String order : orders) {
				char[] sortMenu = order.toCharArray(); // FG와 GF가 다른 것으로 추가되지 않게 정렬한 문자 배열
				Arrays.sort(sortMenu);

				makeCombination(sortMenu, c, 0, "");
			}
			
			// value 중 최대값인 조합을 2명 이상의 손님이 주문했을 경우 결과에 포함
			if (!combination.isEmpty()) { // 조합이 없을 때 - java.util.NoSuchElementException 발생
				Integer max = Collections.max(combination.values()); 
				if (max >= 2) {
					for (String key : combination.keySet())
						if (combination.get(key) == max)
							result.add(key);
				}
			}
		}
		
		// 리스트를 오름차순하여 배열로 반환
		Collections.sort(result);
		return result.toArray(new String[result.size()]);
	}
	
	// 이 재귀함수 부분만 GPT의 힘을 빌렸다... 도저히 조합 생성 방법을 모르겠어서...
	private static void makeCombination(char[] sortMenu, int length, int start, String current) {
        // 현재 조합의 길이가 원하는 길이와 같으면 맵에 추가
        if (current.length() == length) {
            combination.put(current, combination.getOrDefault(current, 0) + 1);
            return;
        }

        // 현재 조합의 길이가 원하는 길이보다 작으면 남은 문자들을 순차적으로 추가하여 새로운 조합 생성
        for (int i = start; i < sortMenu.length; i++) 
            makeCombination(sortMenu, length, i + 1, current + sortMenu[i]);
    }
}
