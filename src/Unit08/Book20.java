package Unit08;

import java.util.*;

public class Book20 {
    
    public static void main(String[] args) {
        String[] want = {"apple"};
        int[] number = {10};
        String[] discount = {"banana", "banana", "banana", "banana", "banana", 
                             "banana", "banana", "banana", "banana", "banana"};
        
        System.out.println(solution(want, number, discount));
    }
    
    public static int solution(String[] want, int[] number, String[] discount) {
        int result = 0;

        // HashMap < 구매하고자 하는 제품명, 그 제품명의 개수 >
        HashMap<String, Integer> wanted = new HashMap<>();
        for (int i = 0; i < want.length; i++)
            wanted.put(want[i], number[i]);
        
        // 특정일 i 이후 10일 동안 할인받아서 구매할 수 있는 제품
        for (int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> dc = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) 
                if (wanted.containsKey(discount[j]))
                    dc.put(discount[j], dc.getOrDefault(discount[j], 0) + 1);
            
            if (dc.equals(wanted)) 
                result++;
        }
        
        return result;
    }
}