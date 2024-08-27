package Unit06;

import java.util.*;

public class Book14_fail {
	
	public static void main(String[] args) {
		
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
		
		System.out.println(solution(n, k, cmd));
	}
	
	public static String solution(int n, int k, String[] cmd) {
		ArrayList<Integer> list = new ArrayList<>(); // 인덱스 삭제에 사용
		Stack<Integer> stack = new Stack<>(); // 삭제한 내용 복구할 때 사용
		
		for (int i = 0; i < n; i++)
			list.add(i);
		
		int currentNum = k; // 현재 선택되어있는 행 번호
		
		for (int i = 0; i < cmd.length; i++) {
			String s = cmd[i];
			
			// C, 즉 삭제일 때 처리 (삭제 후 아래행 선택, 마지막 행이면 그 윗행 선택)
			if (s.equals("C")) {
				stack.push(currentNum);
				list.remove(currentNum);
				
				if (currentNum == n - 1) // 마지막 행을 삭제할 때
					currentNum -= 1;
				else
					currentNum += 1;
			}
			
			// Z, 즉 삭제 복구일 때 처리 (선택한 행 변경 없음)
			if (s.equals("Z")) {
				int x = stack.pop();
				list.add(x, x);
			}

			// U or D + N, N만큼 Up 혹은 Down
			StringTokenizer st = new StringTokenizer(s);
			if (st.hasMoreTokens()) {
				if (st.nextToken().equals("U")) {
					currentNum += Integer.parseInt(st.nextToken());
				}
				if (st.nextToken().equals("D")) {
					currentNum -= Integer.parseInt(st.nextToken());
				}
			}
		}
		
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n - 1; i++) {
			if (list.get(i) == i)
				result.append("O");
			else
				result.append("X");
		}
		
		return result.toString();
	}
}
