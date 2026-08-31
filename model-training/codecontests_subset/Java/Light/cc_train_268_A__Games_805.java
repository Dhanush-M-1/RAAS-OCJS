//package acm_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javafx.util.Pair;

public class Acm_practice {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ArrayList<Pair<Integer, Integer>> al = new ArrayList<>();
        int n, x, y, ans = 0;
        n = s.nextInt();
        for (int i = 0; i < n; i++) {
            x = s.nextInt();
            y = s.nextInt();
            al.add(new Pair<Integer, Integer>(x, y));
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n ; j++) {
                if (al.get(i).getKey() == al.get(j).getValue()) {
                    ans++;
                }
                if (al.get(i).getValue() == al.get(j).getKey()) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
