package Unit09;

import java.util.*;

public class Book27 {
	
	public static void main(String[] args) {
		
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		
		System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
	}
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		
		// result<명단, 얻은 이익금>
		HashMap<String, Integer> calcMoney = new HashMap<>();
		for (int i = 0; i < enroll.length; i++)
			calcMoney.put(enroll[i], 0);
		
		// recommend<이름, 추천인>
		HashMap<String, String> recommend = new HashMap<>();
		for (int i = 0; i < enroll.length; i++)
			recommend.put(enroll[i], referral[i]);
		
		// seller들의 이익금 분배 과정
		for (int i = 0; i < seller.length; i++) {
			String sellerName = seller[i];
			int money = amount[i] * 100;
			
			// seller의 추천인을 거슬러 올라가서 더이상 추천인이 없을 때까지 반복
			while(true) {
				int leftMoney = money / 10; // 10%가 1원 미만인 경우 0으로 처리
				int ownMoney = money - leftMoney;
				
				// 90%는 자신의 돈에 추가
				calcMoney.put(sellerName, calcMoney.get(sellerName) + ownMoney);
				
				// 더이상 추천인이 없으면 반복문 탈출
				if (recommend.get(sellerName).equals("-") || leftMoney == 0)
					break;
				
				// 나머지 10%는 추천인에게
				sellerName = recommend.get(sellerName);
				money = leftMoney;
			}
		}
		
		int[] result = new int[enroll.length];
		for (int i = 0; i < enroll.length; i++)
			result[i] = calcMoney.get(enroll[i]);
		
		return result;
	}
}