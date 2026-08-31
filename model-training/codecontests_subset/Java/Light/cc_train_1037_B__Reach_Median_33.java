import java.util.*;
import java.math.*;

public class Main {
	public static int Mod = (int)1e9+7; 
	public static void main(String ards[])
	{
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		long m = cin.nextLong();
		long[] a = new long[200010];
		for(int i = 0; i < n; i++){
			a[i] = cin.nextLong();
		}
		Arrays.sort(a,0,n);
		
		long ans = 0;
		ans = Math.abs(a[n/2]-m);
	    for(int i = n/2+1; i < n; i++)
	        if(a[i] < m) ans += m-a[i];

	    for(int i = 0; i < n/2; i++)
	        if(a[i] > m) ans += a[i]-m;
	    
	    System.out.println(ans);
	}
}
   				 			 		 			 	 	 	    	 	