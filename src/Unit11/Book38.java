package Unit11;

import java.util.*;

public class Book38 {
    
    public static void main(String[] args) {
        
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        
        System.out.println(solution(n, computers));
    }
    static int[] parent;
    
    public static int solution(int n, int[][] computers) {
    	// 네트워크 개수 = 부모 노드 종류
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        
        // 연결된 컴퓨터를 같은 집합으로 합치기
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) 
                if (computers[i][j] == 1) 
                    union(i, j);
        }
        
        // 모든 컴퓨터의 부모 노드 확인
        Set<Integer> networks = new HashSet<>();
        for (int i = 0; i < n; i++)
            networks.add(find(i));
        
        return networks.size();
    }
    
    public static int find(int x) {

		if (x == parent[x])
			return x;
		else
			return parent[x] = find(parent[x]);
    }
    
    public static void union(int x, int y) {
    	
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX < rootY)
            parent[rootY] = rootX;
        else
        	parent[rootX] = rootY;
    }
}