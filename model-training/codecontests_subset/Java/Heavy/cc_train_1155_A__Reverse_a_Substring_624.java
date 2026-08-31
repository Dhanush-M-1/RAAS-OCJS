//package com.krakn.CF.A1155;

import java.util.Scanner;

public class Main {

    private static String word;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int index = 0, i;
        sc.nextLine();
        word = sc.next();
//        System.out.println("Word --> " + word);

        for (i = 0; i < n; i++) {
//            System.out.println("Current index --> " + i +
//                    " -- Current char --> " + word.charAt(i));
            index = getIndexOfGreaterChar(word.charAt(i), i);
//            System.out.println("From --> " + i + " -- To --> " + index);
            if (index > 0) {
                break;
            }
        }

        if (index > 0) {
            System.out.println("YES");
            System.out.println((i + 1) + " " + (index + 1));
        } else {
            System.out.println("NO");
        }
    }

    private static int getIndexOfGreaterChar(char c, int currIndex) {
        if (currIndex != 0) {
            if (word.charAt(currIndex - 1) == c) {
                return -1;
            }
        }
        currIndex++;
        while (currIndex < word.length()) {
//            System.out.println("currIndex --> " + currIndex);
//            System.out.println("currChar --> " + word.charAt(currIndex));
            if (word.charAt(currIndex) < c) {
                return currIndex;
            }
            currIndex++;
        }
        return -1;
    }
}
