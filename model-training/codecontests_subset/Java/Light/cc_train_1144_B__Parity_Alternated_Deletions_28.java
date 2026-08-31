/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package pkg1144b;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author sorooshzare
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        int even = 0 ;
        int odd = 0;
        for (int i = 0 ; i < n ; i ++) {
            a[i] = input.nextInt();
            if (a[i] % 2 == 0 ) even ++;
            else odd ++;
        }
        Arrays.sort(a);
        if (Math.abs(even - odd) <= 1){
            System.out.println(0);
        }else{
            int need = even > odd ? 0 : 1;
            int cnt = Math.max(even,odd)-Math.min(even,odd)-1;
            long total = 0;
            for (int i = 0 ; i < n && cnt > 0 ; i ++){
                if (a[i] % 2 == need){
                    total += a[i];
                    cnt --;
//                    System.out.println(a[i]);
//                    System.exit(0);
                }
            }
            System.out.println(total);
            
        }
        
    }
    
}
