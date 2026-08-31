//package codeforces.Educational.Round45;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MicroWorld {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int total = s.nextInt();
        int k = s.nextInt();

        ArrayList<Integer> a = new ArrayList<>(total);
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < total; i++) {
            int num  = s.nextInt();
            if (count.containsKey(num)) {
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
                a.add(num);
            }
        }
        Collections.sort(a);

        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i) < a.get(i + 1) && a.get(i) + k >= a.get(i+1)) {
                total -= count.get(a.get(i));
            }
        }

        System.out.println(total);
    }
}
