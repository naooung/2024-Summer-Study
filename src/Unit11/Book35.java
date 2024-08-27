package Unit11;

import java.util.*;

public class Book35 {

	public static void main(String[] args) {
		
		int[][] graph = {{1, 3}, {3, 4}, {3, 5}, {5, 2}};
		int start = 1;
		int n = 5;
		
		System.out.println(Arrays.toString(solution(graph, start, n)));
	}
	
	public static int[] solution(int[][] graph, int start, int n) {
		
		List<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) 
			list.add(new ArrayList<>());
		
		for (int i = 0; i < graph.length; i++)
			list.get(graph[i][0]).add(graph[i][1]);
	
		boolean[] visited = new boolean[n + 1];
		ArrayList<Integer> result = new ArrayList<>();
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			result.add(poll);
			
			for (int i : list.get(poll)) 
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
		}
			
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
}
