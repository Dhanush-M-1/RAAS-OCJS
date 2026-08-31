
import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
Scanner scan=new Scanner(System.in);
        long r,s=0;
        int j;
        long n=scan.nextLong();
        long k=scan.nextLong();
          long[] a=new long[100];
        for(int i=0;i<n;i++)
        {
             a[i]=scan.nextLong();
        }
        for(int i=0;i<n-1;i++)
        {
            for(j=i;j<n;j++)
            {
            if(a[i]>a[j])
                
            {
                r=a[i];
                a[i]=a[j];
                a[j]=r;
                
            }
            
        }
        }
        //for(int i=0;i<n;i++)
       // {
        //        System.out.println(a[i]);
      //  } 
        for(int i=0;i<n;i++)
        {
            if(k%a[i]==0)
            {    //System.out.println(a[i]);
                s=(k/a[i]);
            }
        }        
    System.out.println(s);
    }
}