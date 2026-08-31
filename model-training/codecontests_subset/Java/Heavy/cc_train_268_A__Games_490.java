import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        sc.nextLine();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            left.put(x, left.getOrDefault(x, 0) + 1);
            x = sc.nextInt();
            right.put(x, right.getOrDefault(x, 0) + 1);
            sc.nextLine();
        }
        for(int i : left.keySet()) {
            if(right.containsKey(i)) {
                count = count + left.get(i) * right.get(i);
            }
        }
        System.out.println(count);
    }
}