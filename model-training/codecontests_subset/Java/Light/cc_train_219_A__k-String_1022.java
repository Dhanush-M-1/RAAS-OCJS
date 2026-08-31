//package com.morazow.cf;

import java.util.*;

public class CF219A {

    public static String solve1(String text, int K) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!freq.containsKey(ch)) {
                freq.put(ch, 0);
            }
            freq.put(ch, freq.get(ch) + 1);
        }

        StringBuilder word = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int value = entry.getValue();
            if (value % K != 0) {
                return "-1";
            }
            for (int i = 0; i < value / K; i++) {
                word.append(entry.getKey() + "");
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < K; i++) {
            result.append(word);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        String text = scanner.next();
        System.out.println(solve1(text, K));
    }

}
