package Unit11;

import java.util.*;

public class Book34 {
	
	public static void main(String[] args) {
		
		int[][] graph = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
		int start = 1;
		int n = 5;
		
		System.out.println(Arrays.toString(solution(graph, start, n)));
	}
	
	static List<ArrayList<Integer>> list;
	static boolean[] visited;
	static ArrayList<Integer> result;
	
	
	public static int[] solution(int[][] graph, int start, int n) {
		
		list = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) 
			list.add(new ArrayList<>());
		
		for (int i = 0; i < graph.length; i++)
			list.get(graph[i][0]).add(graph[i][1]);
	
		visited = new boolean[n + 1];
		result = new ArrayList<>();
		
		dfs(start);
		
		return result.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static void dfs(int n) {
		visited[n] = true;
		result.add(n);
		
		for (int i : list.get(n)) 
			if (!visited[i])
				dfs(i);
	}
}
