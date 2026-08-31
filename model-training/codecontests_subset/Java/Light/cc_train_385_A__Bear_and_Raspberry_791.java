import java.util.*;
import java.lang.*;
import java.io.*;

public class rasberry{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
        int ar[]=new int[n];
        for(int i=0;i<n;i++){
            ar[i]=sc.nextInt();
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            if(ar[i]-ar[i+1]-c >=max){
                max=ar[i]-ar[i+1]-c;
            }
            
        }
        if(max<0){
            max=0;}
        
        System.out.println(max);
    }
}