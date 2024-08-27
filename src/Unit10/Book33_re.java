package Unit10;

import java.util.*;

public class Book33_re {
	
	public static void main(String[] args) {
		
		int n = 4;
		int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
		
		System.out.println(solution(n, costs));
	}
	
	static int[] root;
	
	public static int solution(int n, int[][] costs) {
		
		// 비용순으로 오름차순
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
	
		root = new int[n];
		for (int i = 0; i < n; i++)
			root[i] = i;
		
		int result = 0;
		
		for (int i = 0; i < costs.length; i++) {
			int parent = costs[i][0];
			int child = costs[i][1];
			int cost = costs[i][2];
			
			if (find(parent) != find(child)) { // 이미 연결되어 있는 경우 제외
				union(parent, child);
				result += cost;
			}
		}
		return result;
	}
	
	static int find(int index) {
		
		if (root[index] == index)
			return index;
		else
			return root[index] = find(root[index]);
	}
	
	static void union(int parent, int child) {
		parent = find(parent);
		child = find(child);
		
		root[child] = parent;
	}
}