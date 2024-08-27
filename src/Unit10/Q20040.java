package Unit10;

import java.util.*;

public class Q20040 {
	
	static int[] root;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int result = 0;
		
		int n = scanner.nextInt();
		root = new int[n];
		for (int i = 0; i < n; i++)
			root[i] = i;
		
		int m = scanner.nextInt();
		int[][] node = new int[m][2];
		for (int i = 0; i < m; i++) {
			node[i][0] = scanner.nextInt();
			node[i][1] = scanner.nextInt();
		}
		
		for (int i = 0; i < m; i++) {
			int parent = node[i][0];
			int child = node[i][1];
			
			if (find(parent) == find(child)) {
				result = i + 1;
				break;
			}
			
			union(parent, child);
		}
		System.out.println(result);
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
		
		if (parent != child)
			root[child] = parent;
	}
}
