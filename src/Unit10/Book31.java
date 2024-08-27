package Unit10;

import java.util.*;

public class Book31 {
	
	public static void main(String[] args) {
		
		int[] nums = {3, 1, 2, 3};
		
		System.out.println(solution(nums));
	}
	
	public static int solution(int[] nums) {
		
		int n = nums.length / 2;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		
		if (n > map.size())
			return map.size();
		else
			return n;
	}
}
