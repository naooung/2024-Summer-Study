package Unit10;

import java.util.*;

public class Q1822 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int nA = scanner.nextInt();
		int nB = scanner.nextInt();
		
		HashSet<Integer> A = new HashSet<>();
		for (int i = 0; i < nA; i++) 
			A.add(scanner.nextInt());
		HashSet<Integer> B = new HashSet<>();
		for (int j = 0; j < nB; j++)
			B.add(scanner.nextInt());
		
		// B와 동일한 원소가 있으면 HashSet에서 삭제
		for (int e : B) 
			A.remove(e);
		
		// ArrayList로 변환해서 오름차순 정렬
		ArrayList<Integer> result = new ArrayList<>(A);
		Collections.sort(result);
		
		System.out.println(result.size());
		
		if (!result.isEmpty())
			for (int i = 0; i < result.size(); i++)
				System.out.print(result.get(i) + " ");
	}
}

/* < List remove() 메소드 >
 * remove(int index): int형을 넣으면 해당 인덱스 삭제
 * remove(Object o): 객체를 넣으면 해당 객체(ex.Integer) 삭제
 * 
 * < List & Set >
 * remove() & contains()에서 List는 O(n), Set은 O(1)의 시간복잡도를 가짐
 */