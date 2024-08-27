package Unit09;

import java.util.*;

public class Q11725 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); // 노드의 개수
		ArrayList<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < n + 1; i++)
			list.add(new ArrayList<>());
		
		for (int i = 0; i < n - 1; i++) {
			int a = scanner.nextInt();
		    int b = scanner.nextInt();
			
		    // 양방향으로 추가
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		int[] parent = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		
		// BFS로 부모 노드 찾아서 기록
		while (!queue.isEmpty()) {
			int node = queue.poll();
			
			// node와 인접한 모든 노드를 가져옴
			for (int i : list.get(node)) {
				
				// 방문하지 않은 노드면 방문한 것으로 표시하고 큐에 삽입
				if (!visited[i]) {
					visited[i] = true;
					parent[i] = node;
					queue.add(i);
				}
			}
		}
		
		for (int i = 2; i < n + 1; i++)
			System.out.println(parent[i]);
	}
}
