/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Help_Vasilisa_the_Wise2 {

    public static void solve() {
        Scanner nera = new Scanner(System.in);
        int r1 = nera.nextInt();
        int r2 = nera.nextInt();
        int c1 = nera.nextInt();
        int c2 = nera.nextInt();
        int d1 = nera.nextInt();
        int d2 = nera.nextInt();

        int i = 0, j = 0, k = 0, a = 0, b = 0, c = 0, x = 0;

        ArrayList<Integer> list = new ArrayList();
        for (i = 1; i < 10; ++i) {
            list.add(i);
        }

        for (i = 1; i < 10; ++i) {
            list.clear();
            for (j = 1; j < 10; ++j) {
                list.add(j);
            }          
            
            
            x = i;
            a = r1 - x;
            list.remove(list.indexOf(x));
            if (list.contains(a)) {
                list.remove(list.indexOf(a));
                
            } else {
                continue;
            }
            b = c1 - x;
            if (list.contains(b)) {
                 list.remove(list.indexOf(b));
            } else {
                continue;
            }

            c = r2 - b;
            if (list.contains(c)) {
                  list.remove(list.indexOf(c));
            } else {
                continue;
            }

            if (c != c2 - a) {
                continue;
            }
            if ((x + c) != d1) {
                continue;
            }
            if ((b + a) != d2) {
                continue;
            }
            System.out.println(x + " " + a);
            System.out.println(b + " " + c);
            return;

        }
        System.out.println("-1");




    }

    public static void main(String[] args) {

        solve();
    }
}
