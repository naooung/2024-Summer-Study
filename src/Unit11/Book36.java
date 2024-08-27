package Unit11;

import java.util.*;

public class Book36 {
	
	public static void main(String[] args) {
		
		int[][] graph = {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
		int start = 0;
		int n = 3;
		
		System.out.println(Arrays.toString(solution(graph, start, n)));
	}
	
	static class Node {
		int v;
		int c;
		
		Node(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
	
	public static int[] solution(int[][] graph, int start, int n) {
		
		// list에 특정 노드 + Node[연결된 노드, 가중치]로 저장
		List<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
		
		for (int i = 0; i < n; i++)
			list.add(new ArrayList<Node>());
		
		for (int i = 0; i < graph.length; i++)
			list.get(graph[i][0]).add(new Node(graph[i][1], graph[i][2]));
		
		// 최소 비용을 담는 배열, 무한대로 초기화
		int[] distance = new int[n];
		for (int i = 0; i < n; i++)
			distance[i] = Integer.MAX_VALUE;

		boolean[] visited = new boolean[n];
		distance[start] = 0;
		
		// 여기부터 모르겠음 너비 우선 탐색 사용
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.c, o2.c));
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			
			Node now = q.poll();
			
			if (visited[now.v])
				continue;
			
			visited[now.v] = true;
			
			for (Node next : list.get(now.v)) { // 현재 노드와 인접한 노드 가져오기
				
				if (distance[next.v] > distance[now.v] + next.c) { // 지금까지의 거리보다 더 짧은 거리면
					distance[next.v] = distance[now.v] + next.c; // 값 갱신
					q.add(new Node(next.v, distance[next.v])); // 큐에 삽입
				}
			}
		}
		
		return distance;
	}
}
