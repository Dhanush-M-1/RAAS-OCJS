import java.io.*;
import java.util.*;


public class Solution{  
	
 public static void main(String[] args) {
     
     Scanner in = new Scanner(System.in);
     
     int n,i,min;
     int[] a;
     
     n=in.nextInt();
     
     a=new int[n+1];
     
     for(i=1;i<=n;i++)a[i]=in.nextInt();
     
     min=Math.min(a[n]-1, 1000000-a[1]);
     
     for(i=1;i<=n-1;i++){
    	 min=Math.min(min, Math.max(a[i]-1,1000000-a[i+1]));
     }
     
     System.out.println(min);
     
     
 }
}
