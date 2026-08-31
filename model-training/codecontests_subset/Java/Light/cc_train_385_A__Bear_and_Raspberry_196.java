import java.util.*;

import java.io.*;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while(t-->0)
//        {
            int n = sc.nextInt(),c = sc.nextInt(),a[] = new int[n],max = 0;
            for(int i=0;i<n;i++)
            {
            	a[i] = sc.nextInt();
            }
            for(int i=1;i<n;i++)max = Math.max(max,a[i-1]-a[i]-c);
            if(max>0)System.out.println(max);else System.out.println(0);
    }
}
  	   					 	      		  				   	