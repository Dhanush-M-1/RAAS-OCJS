//package codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by nitin.s on 14/03/16.
 */
public class Treasure {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int balance = 0;
        for(int i = 0; i <s.length(); ++i) {
            if(s.charAt(i) == '(') {
                ++balance;
            } else {
                --balance;
            }
            if(balance < 0) {
                System.out.println(-1);
                return;
            }
        }

        int lastHash = s.lastIndexOf('#');
        List<Integer> answer = new ArrayList<Integer>();
        int add = balance;
        balance = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                ++balance;
            } else {
                --balance;
            }
            if(i == lastHash) {
                answer.add(add + 1);
                balance -= add;
            } else if(s.charAt(i) == '#') {
                answer.add(1);
            }
            if(balance < 0) {
                System.out.println(-1);
                return;
            }
        }
        for(int i = 0; i < answer.size(); ++i) {
            System.out.println(answer.get(i));
        }
    }
}