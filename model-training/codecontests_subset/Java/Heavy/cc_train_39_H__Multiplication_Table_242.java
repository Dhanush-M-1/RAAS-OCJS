import java.util.Scanner;

/**
 * Created on 2/1/17 at 8:43 AM by Christopher Skalnik
 * for Data Structures under Ryan Ritz, Park Tudor
 * Project: SchoolContest; Module: H-MultiplicationTable; File: Driver
 * Made with: IntelliJ IDEA
 * Copyright (C) 2017 Christopher Skalnik
 * Code Sources:
 * References:
 */
public class Driver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int radix = s.nextInt();
        int[][] table = new int[radix - 1][radix - 1];
        for (int r = 0; r < table.length; r ++) {
            for (int c = 0; c < table.length; c ++) {
                table[r][c] = (r + 1) * (c + 1);
            }
        }
        for (int[] row : table) {
            String toPrint = "";
            for (int n : row)
                toPrint += Integer.toString(n, radix) + " ";
            System.out.println(toPrint.substring(0, toPrint.length() - 1));
        }
    }
}
