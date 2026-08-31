//package xubiker.archive;

import java.util.*;

/**
 * Created by xubiker on 22-Dec-16.
 */
public class Task_519B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> d1 = new HashMap<>();
        Map<Integer, Integer> d2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            Integer v = d1.get(k);
            if (v == null) {
                d1.put(k, 1);
            } else {
                d1.put(k, v + 1);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int k = in.nextInt();
            Integer v = d2.get(k);
            if (v == null) {
                d2.put(k, 1);
            } else {
                d2.put(k, v + 1);
            }
            d1.put(k, d1.get(k) - 1);
        }
        for (int i = 0; i < n - 2; i++) {
            int k = in.nextInt();
            d2.put(k, d2.get(k) - 1);
        }
        for (Map.Entry<Integer, Integer> i : d1.entrySet()) {
            if (i.getValue() > 0) {
                System.out.println(i.getKey());
            }
        }
        for (Map.Entry<Integer, Integer> i : d2.entrySet()) {
            if (i.getValue() > 0) {
                System.out.println(i.getKey());
            }

        }
        in.close();
    }
}
