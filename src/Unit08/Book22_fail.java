package Unit08;

import java.util.*;

public class Book22_fail {
	
	public static void main(String[] args) {
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		System.out.println(Arrays.toString(solution(genres, plays)));
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		
		HashMap<String, ArrayList<int[]>> map = new HashMap<>();
		HashMap<String, Integer> time = new HashMap<>();
		
		for (int i = 0; i < genres.length; i++) {
			if (!map.containsKey(genres[i])) {
				// map에 동일한 장르 이름이 없으면 장르를 Key에 넣고 새로운 리스트 생성
				map.put(genres[i], new ArrayList<>());
				time.put(genres[i], 0);
			}
			// 이미 존재하는 map에 [인덱스,재생횟수] 삽입
			map.get(genres[i]).add(new int[] {i, plays[i]});
			// 이미 존재하는 time에 장르명에 맞는 재생횟수 더하기
			time.put(genres[i], time.get(genres[i]) + plays[i]);
		}
		
		// time의 value를 사용하여 많이 재생된 장르 순서대로 내림차순 정렬
		
		
		// map에 있는 value[1]의 재생횟수를 사용하여 value[0] 내림차순 정렬
		
		
		//time의 key 순서대로 map의 value[0]을 두 곡씩만 결과 리스트에 추가
		ArrayList<Integer> result = new ArrayList<>();
		
		return result.stream()
					 .mapToInt(Integer::intValue)
					 .toArray();
	}
}
