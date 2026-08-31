//package com.morazow.cf;

import java.util.*;

public class CF235A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();

        if (N <= 2) {
            System.out.println(N);
            return ;
        }

        long result = 1;
        if (N % 2 == 0 && N % 3 != 0) {
            result = N * (N - 1) * (N - 3);
        } else if (N % 2 == 0 && N % 3 == 0) {
            result = (N - 1) * (N - 2) * (N - 3);
        } else {
            result = N * (N - 1) * (N - 2);
        }

        System.out.println(result);
    }

}
