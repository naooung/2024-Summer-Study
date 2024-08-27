package Unit10;

import java.util.*;

public class Book30 {

	public static void main(String[] args) {
		
		int k = 4;
		int[][] operations = {{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}};
		
		System.out.println(Arrays.toString(solution(k, operations)));
	}
	
	static int[] root;
	
	public static Boolean[] solution(int k, int[][] operations) {
		
		root = new int[k];
		for (int i = 0 ; i < k; i++)
			root[i] = i;
		ArrayList<Boolean> result = new ArrayList<>();
		
		for (int i = 0; i < k; i++) {
			int calc = operations[i][0]; // 연산 종류 선택
			int x = operations[i][1];
			int y = operations[i][2];
			
			if (calc == 0) { 
				union(x, y);
			}
			else if (calc == 1) {
				result.add(equals(x, y));
			}
		}
		
		return result.toArray(new Boolean[result.size()]);
	}
	
	static void union(int x, int y) {
		
		x = find(x);
		y = find(y);
		
		if (x < y) // 루드 노드가 작은 노드(x)를 더 큰 노드(y)의 자식으로 연결인데 왜 답이 root[y] = x??
			root[x] = y;
		else 
			root[y] = x;
	}
	
	static int find(int x) { // 재귀호출로 루트 노드 찾기
		
		if (x == root[x])
			return x;
		else
			return root[x] = find(root[x]);
	}
	
	static boolean equals(int x, int y) {
		
		return root[x] == root[y]; 
	}
}
