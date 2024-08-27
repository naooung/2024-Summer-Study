package Unit08;

import java.util.*;

public class Book21 {
	
	public static void main(String[] args) {
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", 
						   "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		
		System.out.println(Arrays.toString(solution(record)));
	}
	
	public static String[] solution(String[] record) {
		
		// HashMap <uid, 닉네임>
		HashMap<String, String> name = new HashMap<>();
		String[] command = new String[record.length];
		String[] uid = new String[record.length];
		
		// 이름 변경 처리 (1. 나갔다 들어오는 경우, 2. 이름을 변경하는 경우)
		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			command[i] = st.nextToken();
			uid[i] = st.nextToken();
			
			if (command[i].equals("Enter") || command[i].equals("Change"))
				name.put(uid[i], st.nextToken());
		}
		
		// uid에 맞는 이름을 HashMap으로 출력하면서 명령어 출력
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < record.length; i++) {
			if (command[i].equals("Enter"))
				result.add(name.get(uid[i]) + "님이 들어왔습니다.");
			else if (command[i].equals("Leave"))
				result.add(name.get(uid[i]) + "님이 나갔습니다.");
		}
		
		return result.toArray(new String[result.size()]);
	}
}