/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;


public class Spoj5 {

    /**
     * @param args the command line arguments
     */
   

    
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int n = ip.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = ip.nextInt();
        }
        
        if(1000000 - a[n-1] >= a[n-1] - 1)
        {
            System.out.println(a[n-1] - 1);
        }
        else
        {
            if(n > 1)
            {
                int i = n - 2;
                while(i > 0 && 1000000 - a[i] <= a[i] - 1)
                {
                    i--;


                }
                if(1000000 - a[i] < a[i] - 1)
                {
                    System.out.println(1000000 - a[i]);
                }
                else
                {
                    if (1000000 - a[i + 1] < a[i] - 1) {
                        System.out.println(a[i] - 1);
                    } else {
                        System.out.println(1000000 - a[i + 1]);
                    }
                }
            }
            else
            {
                System.out.println(1000000 - a[n-1]);
            }
        }
    }
}
