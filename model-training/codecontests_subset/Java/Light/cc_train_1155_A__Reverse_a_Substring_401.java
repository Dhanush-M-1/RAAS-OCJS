//package com.netease.music.codeforces.edu63;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by dezhonger on 2019/4/22
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String str = scanner.nextLine();
        int[] a = new int[n];
        Arrays.fill(a, -1);
        Stack<Integer> stack = new Stack<>();
        boolean f = false;
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && str.charAt(stack.peek()) > str.charAt(i)) {
                f = true;
                x = stack.peek();
                y = i;
                a[stack.peek()] = i - stack.peek();
                stack.pop();
                break;
            }
            if (f) {
                break;
            }
            stack.push(i);
        }
        if (f) {
            System.out.println("YES");
            x++;
            y++;
            System.out.println(x + " " + y);

        } else {
            System.out.println("NO");
        }
    }


}
