
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author shaolin
 */
public class A_338 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int i, j, k, b;
        int[] bulbs = new int[m];
        int total = 0;
        for(i=0; i<n; i++) {
            k = scanner.nextInt();
            for(j=0;j<k;j++) {
                b = scanner.nextInt()-1;
                if(bulbs[b]==0) {
                    total++;
                    bulbs[b]=1;
                }
            }
        }
        if(total == m)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
