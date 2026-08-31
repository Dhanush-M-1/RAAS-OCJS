/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dir[] = new int[n];
        int x[] = new int[n];
        int h[] = new int[n];
        for(int i = 0;i<n;i++){
            x[i]=sc.nextInt();
            h[i]=sc.nextInt();
        }
        dir[0]=-1;
        int max = x[0];
        int count = 0;
        count++;
        if(n==1){
            System.out.println(1);
        }
        else{
            for(int i = 1;i<n-1;i++){
                if(x[i]-h[i]>max){
                    dir[i]=-1;
                    max=x[i];
                    count++;
                }
                else{
                    if(x[i]+h[i]<x[i+1]){
                        dir[i]=1;
                        max=x[i]+h[i];
                        count++;
                    }
                    else{
                        max=x[i];
                    }
                }
            }
            System.out.println(count+1);
        }
    }
}