
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class CompilationErrors {
 public static void main(String [] args){
     Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
     int n = in.nextInt();
     long totalSum = 0;
     for(int i = 0;i<n;i++){
         totalSum += in.nextInt();
     }
     long sum1 = 0;
     for(int i  = 0;i<n-1;i++){
         sum1 += in.nextInt();
     }
     long sum2 = 0;
     for(int i = 0;i<n-2;i++){
         sum2 += in.nextInt();
     }
     System.out.println((totalSum-sum1));
     System.out.println((sum1-sum2));
 }   
}
