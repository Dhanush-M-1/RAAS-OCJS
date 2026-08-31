//package com.company;

import java.util.Scanner;

public class New_Year_Candles {
    static int candles (int x, int y){
        int candleCount = 0;
        int meltedExtraCandles = 0;
        while (x != 0) {
            candleCount += x;
            meltedExtraCandles += x % y;
            x = x/ y;
            if (meltedExtraCandles >= y) {
                candleCount += meltedExtraCandles/y;
                meltedExtraCandles = meltedExtraCandles%y + 1;
            }
        }
        return candleCount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(candles(a,b));
    }
}
