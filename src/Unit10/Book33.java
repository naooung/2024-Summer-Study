package Unit10;

import java.util.*;

public class Book33 {
	
	public static void main(String[] args) {
		
		int n = 4;
		int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
		
		System.out.println(solution(n, costs));
	}
	
	public static int solution(int n, int[][] costs) {
		
		int result = 0;
		// 비용순으로 오름차순
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		// 연결된 섬은 set에서 제거
		HashSet<Integer> connect = new HashSet<>();
		for (int i = 0; i < n; i++)
			connect.add(i);

		for (int i = 0; i < costs.length; i++) {
			int a = costs[i][0];
			if (connect.contains(a))
				connect.remove(a);
			
			int b = costs[i][1];
			if (connect.contains(b))
				connect.remove(b);
				
			result += costs[i][2];
			
			if (connect.isEmpty())
				break;
		}
		return result;
	}
}
