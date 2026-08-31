import java.util.*;
import java.io.*;


import java.util.Collections;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int c = sc.nextInt();

        int x = sc.nextInt();
        int ans = Integer.MIN_VALUE;

        for(int i=1; i<n; i++){
            int xx = sc.nextInt();
            if(x-xx-c>ans){
                ans = x-xx-c;
            }
            x = xx;

        }

        


        System.out.println((ans>=0)?ans:0);
        


    }
}