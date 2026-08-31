/**
 * 30/12/19
 */

import java.util.*;

public class A0615_Bulbs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();

        Set<Integer> bulbs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            while (num-- > 0) {
                bulbs.add(scanner.nextInt());
            }
        }

        System.out.println(bulbs.size() == m ? "YES" : "NO");
    }
}