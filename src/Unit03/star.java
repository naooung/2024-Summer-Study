package Unit03;
import java.util.Scanner;

public class star {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		// < 시간 복잡도 >
		// O(N^2)
		
		for (int i = 0; i< n; i++) {
			for (int j = 0; j < i+1; j++)
				System.out.print("*");
			
			System.out.println();
		}
	}
}
