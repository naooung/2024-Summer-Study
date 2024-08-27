package Unit11;

import java.util.*;

public class Book40 {
	
	public static void main(String[] args) {
		
		int n = 5;
		int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
		int k = 3;
		
		System.out.println(solution(n, road, k));
	}
	
	public static int solution(int n, int[][] road, int k) {
		
		// 마을 연결 정보 ArrayList에 저장
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) 
			list.add(new ArrayList<Node>());
		for (int i = 0; i < road.length; i++) { // 방향이 없으므로 양방향 저장
			list.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
			list.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
		}
		
		int[] result = new int[n + 1];
		for (int i = 0; i < result.length; i++)
			result[i] = Integer.MAX_VALUE; // 윽 까먹을뻔
		
		PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
		queue.add(new Node(1, 0));
		result[1] = 0;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			
			for (Node next : list.get(now.v)) {
				
				int spending = now.time + next.time;
				if (result[next.v] > spending) { // 지금까지의 거리보다 짧은 거리라면
					queue.add(new Node(next.v, spending));
					result[next.v] = spending;
				}
			}
		}
		
		int answer = 0;
		for (int i = 1; i < result.length; i++) 
			if (result[i] <= k)
				answer++;
		
		return answer;
	}
	
	public static class Node {
		int v;
		int time;
		
		Node(int v, int time) {
			this.v = v;
			this.time = time;
		}
	}
}
