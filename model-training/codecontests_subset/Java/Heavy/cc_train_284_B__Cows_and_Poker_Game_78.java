/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Ghost
 */
public class B {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int I = 0;
        int A = 0;
    
        for(int i = 0; i < n; i++){
            if (s.charAt(i) == 'I')
                I++;
            if (s.charAt(i) == 'A')
                A++;
        }
        
        if (I > 0){
            if (I == 1)
                System.out.println(1);
            else
                System.out.println(0);
        }else
            System.out.println(A);
    }
}
