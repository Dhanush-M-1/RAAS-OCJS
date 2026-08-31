/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author Centrino
 */
public class mama {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int x = sc.nextInt();
        String s = sc.next();
        for (int i = 1; i < x; i++) {
            if((int)(s.charAt(i))<(int)(s.charAt(i-1))){
                System.out.println("YES");
                System.out.println(i+" "+(i+1));
                return;
            }
        }
           System.out.println("NO");
    }
}
