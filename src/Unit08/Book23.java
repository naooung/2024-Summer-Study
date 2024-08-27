package Unit08;

import java.util.*;

public class Book23 {
	
	public static void main(String[] args) {
		
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int k = 2;
		
		System.out.println(Arrays.toString(solution(id_list, report, k)));
	}
	
	public static int[] solution(String[] id_list, String[] report, int k) {
		
		// 동일한 유저에 대한 신고는 1회로 처리
		HashSet<String> modify = new HashSet<>();
		for (int i = 0; i < report.length; i++)
			modify.add(report[i]); // Set으로 중복 제거
		String[] modifiedReport = modify.toArray(new String[modify.size()]);
		
		// report 배열에서 신고자와 신고당한 유저를 담는 HashMap
		String[] reporting = new String[modifiedReport.length];
		String[] reported = new String[modifiedReport.length];
		for (int i = 0; i < modifiedReport.length; i++) {
			StringTokenizer st = new StringTokenizer(modifiedReport[i]);
			reporting[i] = st.nextToken();
			reported[i] = st.nextToken();
		}
		
		// 신고당한 유저와 그 횟수를 담는 Map
		HashMap<String, Integer> reportTime = new HashMap<>();
		for (int i = 0; i < reported.length; i++) 
			reportTime.put(reported[i], reportTime.getOrDefault(reported[i], 0) + 1);
		
		// 결과 메일을 전송해야 하는 유저와 그 횟수를 담는 Map
		HashMap<String, Integer> sendMail = new HashMap<>();
		for (int i = 0; i < reporting.length; i++) 
			if (reportTime.get(reported[i]) >= k) // 자신이 신고한 사람이 경고 횟수가 k번 이상이라면
				sendMail.put(reporting[i], sendMail.getOrDefault(reporting[i], 0) + 1);
		
		// 결과 메일을 보내야 한다면 sendMail의 횟수를 삽입, 아니라면 0 삽입
		int[] result = new int[id_list.length];
		for (int i = 0; i < id_list.length; i++) {
			result[i] = sendMail.getOrDefault(id_list[i], 0);
		}
		
		return result;
	}
}
