/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package Virtual;

import java.util.Scanner;

/**
 *
 * @author Rock
 */
public class E {
  
    public static void main(String[] args) {
              Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
    int[] n = new int[]{2,3,5};
    int count=0;
    for(int i: n){
    int p=0,q=0;
    while(a%i==0){a/=i;p++;}
    while(b%i==0){b/=i;q++;}
    count+=Math.abs(p-q);
    }
    if(a==b)System.out.print(count);
    else System.out.print(-1);
    }   
}
