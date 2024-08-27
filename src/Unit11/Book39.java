package Unit11;

import java.util.*;

public class Book39 {
	
	public static void main(String[] args) {
		
		String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
		
		System.out.println(solution(maps));
	}
	
	public static int solution(String[] maps) {
		
		int n = maps.length;
        int m = maps[0].length();

        char[][] map = new char[n][m];
        destination S = null;
        destination L = null;
        destination E = null;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);

                if (map[i][j] == 'S')
                    S = new destination(i, j);
                if (map[i][j] == 'L')
                    L = new destination(i, j);
                if (map[i][j] == 'E')
                    E = new destination(i, j);
            }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // S -> L 최소 이동 거리
        int[][] StoL = new int[n][m];
        int StoLTime = 0;
        ArrayDeque<destination> deque1 = new ArrayDeque<>();
        deque1.add(S);
        StoL[S.x][S.y] = 1;

        while (!deque1.isEmpty()) {
            destination now = deque1.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                // 체크 사항: 1. 맵 밖으로 벗어나는지, 2. 방문한 곳이 아닌지, 3. 벽이 아닌지
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || StoL[nextX][nextY] != 0 || map[nextX][nextY] == 'X')
                    continue;

                StoL[nextX][nextY] = StoL[now.x][now.y] + 1;
                deque1.add(new destination(nextX, nextY));

                if (map[nextX][nextY] == 'L') // 도착하면 반환
                    StoLTime = StoL[nextX][nextY] - 1;
            }
        }

        // L -> E 최소 이동 거리
        int[][] LtoE = new int[n][m];
        int LtoETime = 0;
        ArrayDeque<destination> deque2 = new ArrayDeque<>();
        deque2.add(L);
        LtoE[L.x][L.y] = 1;

        while (!deque2.isEmpty()) {
            destination now = deque2.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || LtoE[nextX][nextY] != 0 || map[nextX][nextY] == 'X')
                    continue;

                LtoE[nextX][nextY] = LtoE[now.x][now.y] + 1;
                deque2.add(new destination(nextX, nextY));

                if (map[nextX][nextY] == 'E') // 도착하면 반환
                    LtoETime = LtoE[nextX][nextY] - 1;
            }
        }
        
        // L이나 E에 도착하지 못하면 -1 반환
        if (StoLTime == 0 || LtoETime == 0)
            return -1;
        else
            return StoLTime + LtoETime;
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
