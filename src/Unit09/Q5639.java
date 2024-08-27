package Unit09;

import java.util.*;

public class Q5639 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// ArrayList에 전위순회 결과 담기
		ArrayList<Integer> node = new ArrayList<>();
		while(scanner.hasNext()) 
			node.add(scanner.nextInt());
				
		// 첫번쨰 값(루트 노드)으로 Node 객체 생성
		Node tree = new Node(node.get(0));
		
		// 뒤의 값들을 순차적으로 트리에 추가
		for (int i = 1; i < node.size(); i++) 
			tree.add(node.get(i));
		
		postOrder(tree);
	}
	
	// 왼쪽 노드와 오른쪽 노드를 가진 Node 객체
	public static class Node {
		int num;
		Node left, right;
		
		Node(int num) {
			this.num = num;
			left = null;
			right = null;
		}
		
		void add(int n) {
			// root 노드보다 작을 때 -> 왼쪽으로
			if (num > n) {
				if (left == null)
					left = new Node(n); // 노드가 없으면 왼쪽에 노드 추가
				else
					left.add(n); // 왼쪽에 노드가 있으면 왼쪽 노드로 add() 재실행
			}
			// root 노드보다 클 때 -> 오른쪽으로
			else {
				if (right == null)
					right = new Node(n);
				else
					right.add(n);
			}
		}
	}
	
	// 후위 순회 실행
	static void postOrder(Node tree) {
		// 밑에 더이상 노드가 없으면 해당 노드 반환
		if (tree == null)
			return;
		
		postOrder(tree.left);
		postOrder(tree.right);
		System.out.println(tree.num); // 현재 노드 출력
	}
}
