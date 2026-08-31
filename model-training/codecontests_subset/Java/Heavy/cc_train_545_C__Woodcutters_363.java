//package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int [] x=new int[number];
        int [] h=new int[number];
        int [] dp=new int[number];
        int sum=0;


        for (int i=0;i<number;i++){
            x[i]= input.nextInt();
            h[i]= input.nextInt();

        }
        for (int j=0;j<number;j++) {

            if (j==0){
                dp[j]=x[j];
                sum++;
            }else if (x[j] - h[j] > dp[j - 1]){
                dp[j]=x[j];
                sum++;
            }else if (j<number-1 && x[j] + h[j] < x[j + 1]){
                dp[j]=x[j]+h[j];
                sum++;
            }else if (j==number-1){
                dp[j]=x[j];
                sum++;
            }else {
                dp[j]=x[j];
            }
        }
        System.out.println(sum);
    }
}