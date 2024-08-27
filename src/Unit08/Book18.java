package Unit08;

import java.util.HashSet;

public class Book18 {
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 8};
		int target = 6;
		
		System.out.println(solution(arr, target));
	}
	
	public static boolean solution(int[] arr, int target) {
		
		HashSet<Integer> set = new HashSet<>();
		
		for (int i : arr) {
			
			if (set.contains(target - i))
				return true;
			
			set.add(i);
		}
		return false;
	}
}
