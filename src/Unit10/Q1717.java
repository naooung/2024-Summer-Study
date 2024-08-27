package Unit10;

import java.util.*;

public class Q1717 {
	
	static int[] root;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		root = new int[n + 1];
		for (int i = 1; i <= n; i++)
			root[i] = i;
		
		int m = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(scanner.nextLine());
			
			int calc = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (calc == 0)  
				union(a, b);
			else if (calc == 1)
				System.out.println(result(a, b));
		}
	}
	
	public static int find(int a) { // 루트 노드의 값을 찾는 연산
		if (root[a] == a)
			return a;
		else 
			return root[a] = find(root[a]);
	}
	
	public static void union(int a, int b) { 
		
		a = find(a);
		b = find(b);
		
		if (a != b)
			root[b] = a;
	}
	
	public static String result(int a, int b) {
		
		a = find(a);
		b = find(b);
		
		if (a == b) // 같은 집합에 포함될 때
			return "YES";
		else
			return "NO";
	}
}
