import java.util.*;
import java.io.*;

public class C915 {
	
	public static void main(String args[])  throws Exception{
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt() , x = sc.nextInt() ;
	    int a[] = new int[n];
        	    
	    for(int i=0;i<n;i++)        a[i] = sc.nextInt();
	    Arrays.sort(a);
	    long l = 0 , r = 0;
	    for(int i=0;i<n/2;i++){
	        if(a[i] > x)        l += a[i]-x;
	        if(a[n-1-i] < x)    r += x - a[n-1-i];
	    }
	    long ans = l + r + (long)Math.abs(a[n/2] - x);
	    System.out.println(ans);
	}
}