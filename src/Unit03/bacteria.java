package Unit03;

import java.util.Scanner;

public class bacteria {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int year = 0;
		
		// < 시간 복잡도 >
		// O(logN)
		
		while (n > 0) {
			n /= 2;
			year++;
		}
			
		System.out.println(year + "년 뒤");
	}
}
