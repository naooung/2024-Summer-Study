package Unit09;

import java.util.Arrays;

public class Book25 {

	public static void main(String[] args) {
		
		int[] nodes = {1, 2, 3, 4, 5, 6, 7};
		
		System.out.println(Arrays.toString(solution(nodes, 0)));
	}
	
	public static String[] solution(int[] nodes, int index) {
		
		String[] result = new String[3];
		result[0] = preorder(nodes, 0).strip(); 
		result[1] = inorder(nodes, 0).strip(); 
		result[2] = postorder(nodes, 0).strip(); 
		
		return result;
	}
	
	// 전위 순회 (루트 노드 -> 왼쪽 -> 오른쪽)
	public static String preorder(int[] nodes, int index) {
		
		if (index >= nodes.length)
			return "";
		
		return nodes[index] + " " + preorder(nodes, 2 * index + 1) + preorder(nodes, 2 * index + 2);
	}
	
	// 중위 순회 (왼쪽 -> 루트 노드 -> 오른쪽)
	public static String inorder(int[] nodes, int index) {
		
		if (index >= nodes.length)
			return "";
		
		return inorder(nodes, 2 * index + 1) + nodes[index] + " " + inorder(nodes, 2 * index + 2);
	}

	// 후위 순회 (왼쪽 -> 오른쪽 -> 루트 노드)
	public static String postorder(int[] nodes, int index) {
	
		if (index >= nodes.length)
			return "";
		
		return preorder(nodes, 2 * index + 1) + preorder(nodes, 2 * index + 2) + nodes[index] + " ";
	}
}

/* < 공백을 제거하는 trim & strip 차이점 >
 * trim(): '\u0020' 이하의 공백들만 제거
 * strip(): 유니코드의 공백 모두 제거
 */