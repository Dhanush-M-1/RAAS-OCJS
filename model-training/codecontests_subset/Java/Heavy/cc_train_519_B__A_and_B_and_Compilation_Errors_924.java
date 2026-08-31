import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {
    public static void main(String[] args) {
           long ab =(long)Math.pow(2,63);
           Scanner sc =new Scanner(System.in);
           
           long n , m, o,p,sum = 0 , sum2 = 0 , sum3=0 ;
           n = sc.nextLong();
           o = n -1;
           p = n-2;
           while(n-->0){
               m = sc.nextInt();
               if(sum + m < 0){
                   sum = ab-sum;
                   sum+= m;
               }else{
                   sum += m;
               }
           }
           while(o-->0){
               m = sc.nextInt();
               if(sum2 + m < 0){
                   sum2 =ab-sum2;
                   sum2 +=m; 
               }else{
                   sum2 += m;
               }
           }
           while(p-->0){
               m = sc.nextInt();
               if(sum3 + m < 0){
                   sum3 = ab-sum3;
                   sum3+= m;
               }else{
                   sum3 += m;
               }
           }
           if(sum -sum2 < 0){
               sum = sum-sum2;
               sum = ab+sum;
           }else{
               System.out.println(sum-sum2);
           }
           if(sum2 -sum3 < 0){
               sum2 = sum2-sum3;
               sum2 = ab+sum2;
           }else{
               System.out.println(sum2-sum3);
           }
    }
}