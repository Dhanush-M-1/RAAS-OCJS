//package c218;

import java.util.Scanner;

public class q2 
{

    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        int b=s.nextInt();
        int a2=0;
        while(a%2==0){
            a/=2;
            a2++;
        }
        int a3=0;
        while(a%3==0){
            a/=3;
            a3++;
        }
        int a5=0;
        while(a%5==0){
            a/=5;
            a5++;
        }
        int b2=0;
        while(b%2==0){
            b/=2;
            b2++;
        }
        int b3=0;
        while(b%3==0){
            b/=3;
            b3++;
        }
        int b5=0;
        while(b%5==0){
            b/=5;
            b5++;
        }
        if(a==b){
            int ans=Math.abs(a2-b2)+Math.abs(a3-b3)+Math.abs(a5-b5);
            System.out.println(ans);
        }
        else{
            System.out.println(-1);
        }
    }
}
