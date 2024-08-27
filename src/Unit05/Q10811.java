package Unit05;

import java.util.Scanner;

public class Q10811 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		
		int[] buckets = new int[n];
		
		for (int x = 0; x < buckets.length; x++)
			buckets[x] = x + 1;
		
		int m = scanner.nextInt();
		
		for (int x = 0; x < m; x++) {
			int i = scanner.nextInt() - 1;
			int j = scanner.nextInt() - 1;
			
			// i: 1씩 증가 & j: 1씩 감소
			while (i < j) {
				int temp = buckets[i];
				buckets[i] = buckets[j];
				buckets[j] = temp;
				
				i++;
				j--;
			}
		}
		
		for (int x = 0; x < buckets.length; x++)
			System.out.print(buckets[x] + " ");
	}
}