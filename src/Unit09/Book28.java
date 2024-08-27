package Unit09;

import java.util.*;

public class Book28 {
	
	public static void main(String[] args) {
		
		int[] info = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 }; // 길이 = 12
		int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, 
						 {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}; // 행 길이 = 11
		
		System.out.println(solution(info, edges));
	}
	
	public static int solution(int[] info, int[][] edges) {
		
		int sheep = 0, wolf = 0;
		
		// 1. 인접리스트 생성 
		// ArratList<부모 노드 번호> + List<자식들의 노드 번호>
		ArrayList<List<Integer>> tree = new ArrayList<>();
		for (int i = 0; i < info.length; i++)
			tree.add(new ArrayList<>());
		
		for (int[] edge : edges)
			tree.get(edge[0]).add(edge[1]);
		
		// 2. 너비 우선 탐색으로 최대로 모을 수 있는 양 구하기
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		sheep = 1;
		info[0] = -1;
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			
			// node와 인접한 모든 노드를 가져옴
			for (int i : tree.get(node)) {
				int animal = info[i];
				
				// 방문하지 않은 노드면 조건 검사
				if (animal != -1) {
					if (animal == 1)
						wolf++;
					else if (animal == 0)
						sheep++;
					
					if (sheep > wolf) {// 가도 된다면 방문한 것으로 변경(info[i] = -1)하고 큐에 삽입
						info[i] = -1;
						queue.add(i);
					}
					else { // 가면 안된다면
						if (animal == 1)
							wolf--;
						else if (animal == 0)
							sheep--; // 값 원상복구
					}
				}
				// 방문했던 노드면 그 노드의 인접 노드로 실행
			}
		}
		return sheep;
	}
}

// 양과 늑대의 수가 같아지는 조건이면 다른 곳 탐색
// 너비 우선 탐색 사용 
// but 모은 양과 늑대의 개수를 계속 초기화하고 처음부터 탐색해야함 (((이것만 해결하면
// 양이 있는 곳(0) & 늑대가 있는 곳(1) & 아무것도 없는 곳(-1) 세군데 설정 후 탐색

