package Unit07;

import java.util.*;

public class Q13335 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int w = scanner.nextInt();
		int L = scanner.nextInt();
		int time = 0;
		
		// 트럭의 무게를 담는 덱
		ArrayDeque<Integer> truck = new ArrayDeque<>();
		for (int i = 0; i < n; i++)
			truck.add(scanner.nextInt());
		
		// 현재 다리 위에 올라가 있는 트럭의 무게 저장
        int currentWeight = 0;
		
		// 다리 길이만큼의 덱 중 트럭 위치에 무게 삽입
		ArrayDeque<Integer> bridge = new ArrayDeque<>();
		for (int i = 0; i < w; i++)
			bridge.add(0);
		
		while (!bridge.isEmpty()) { // 모든 트럭이 다리를 지나가면 종료
			time++;
            
			// 트럭이 다리 위를 모두 지나가면 현재 하중에서 제외
			currentWeight -= bridge.poll();
			
            if (!truck.isEmpty()) {
            	// 최대하중 내에 들 때
            	if (currentWeight + truck.peek() <= L) {
            		int weight = truck.poll(); // 다리 위에 올라간 트럭의 무게를 weight
            		currentWeight += weight;
                    bridge.add(weight);
            	}
    			// 최대하중 내에 들지 않을 때 (트럭 출발 못함)
            	else
            		bridge.add(0);
            }
            else // 모든 트럭이 출발했을 때
            	continue;
		}
		
		System.out.println(time);
	}
}
