
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mankank
 */
public class Elections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int c = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int j = sc.nextInt(); if (j > max) max = j;
            c += j;
        } int i = 1;
        while (true) {
            if ((i * n) - c > c && i >= max) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
