package Unit11;

import java.util.*;

public class Book37 {
	
	public static void main(String[] args) {
		
		int[][] maps = {{1, 0, 1, 1, 1}, 
						{1, 0, 1, 0, 1}, 
						{1, 0, 1, 1, 1}, 
						{1, 1, 1, 0, 1}, 
						{0, 0, 0, 0, 1}};
		
		System.out.println(solution(maps));
	}
	
	public static int solution(int[][] maps) {
		
		int n = maps.length;
		int m = maps[0].length;
		int[][] result = new int[n][m];
		
		ArrayDeque<destination> queue = new ArrayDeque<destination>();
		queue.add(new destination(0, 0));
		result[0][0] = 1;
		
		while(!queue.isEmpty()) {
			destination now = queue.poll();
			
			// 먼저 이동한 값이 지도 범위 내에 있는지 확인해야 배열 내 값 확인 가능 ! ArrayIndexOutOfBoundsException 발생
			// 체크할 것: 1.지도 범위 내, 2.길인 곳, 3.방문하지 않은 곳
			// down
			if ((now.x + 1) < n && maps[now.x + 1][now.y] == 1 && result[now.x + 1][now.y] == 0) { 
				queue.add(new destination(now.x + 1, now.y));
				result[now.x + 1][now.y] = result[now.x][now.y] + 1;
				
			}
			// up
			if ((now.x - 1) >= 0 && maps[now.x - 1][now.y] == 1 && result[now.x - 1][now.y] == 0) { 
				queue.add(new destination(now.x - 1, now.y));
				result[now.x - 1][now.y] = result[now.x][now.y] + 1;
			
			}
			// right
			if ((now.y + 1) < m && maps[now.x][now.y + 1] ==1 && result[now.x][now.y + 1] == 0) {
				queue.add(new destination(now.x, now.y + 1));
				result[now.x][now.y + 1] = result[now.x][now.y] + 1;
				
			}
			// left
			if ((now.y - 1) >= 0 && maps[now.x][now.y - 1] == 1 && result[now.x][now.y - 1] == 0) {
				queue.add(new destination(now.x, now.y - 1));
				result[now.x][now.y - 1] = result[now.x][now.y] + 1;
			}
		}
		
		int arrive = result[n - 1][m - 1];
		return arrive == 0 ? -1 : arrive;
	}
	
	static class destination {
		int x;
		int y;
		
		destination(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
