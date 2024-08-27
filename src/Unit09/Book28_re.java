package Unit09;

import java.util.*;

public class Book28_re {

	public static void main(String[] args) {
		
		int[] info = { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 }; // 길이 = 12
		int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, 
						 {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}; // 행 길이 = 11
		
		System.out.println(solution(info, edges));
	}
	
	private static int answer;
	private static ArrayList<List<Integer>> tree = new ArrayList<>();
	
	public static int solution(int[] info, int[][] edges) {
		answer = 0;
		for (int i = 0; i < info.length; i++)
			tree.add(new ArrayList<>());
		
		for (int[] edge : edges)
			tree.get(edge[0]).add(edge[1]);
		
		ArrayList<Integer> next = new ArrayList<>();
		next.add(0);
		
		dfs(info, next, 0, 0, 0);
		
		return answer;
	}
	
	// 다음 차례에 이동 가능한 정점을 list에 담아서 재귀호출
	static void dfs(int[] info, ArrayList<Integer> list, int node, int sheep, int wolf) {
		
		if (info[node] == 0)
			sheep++;
		else
			wolf++;
		
		if (sheep <= wolf) {
			return;
		}
		
		answer = Math.max(answer, sheep); // 이동한 곳이 양이면 결과값에 반영
		
		// 다음 이동할 노드 리스트
		ArrayList<Integer> next = new ArrayList<>(list); // list 요소를 복사하여 새 리스트 생성
		
		if (!tree.get(node).isEmpty()) 
			next.addAll(tree.get(node)); // 현재 노드의 자식 정점을 추가
		next.remove(Integer.valueOf(node)); // 현재 노드는 이미 방문했으므로 제거
		
		// 이동 가능한 모든 노드 재귀호출
		for (int i : next)
			dfs(info, next, i, sheep, wolf);
	}
}
