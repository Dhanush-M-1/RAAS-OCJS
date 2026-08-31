//package first;
import java.util.*;
import java.util.Arrays;
public class myfirst{
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		int n,k,p;
		n = sc.nextInt();
		k = sc.nextInt();	
		p = sc.nextInt();
		int A[] = new int[n];
		int B[] = new int[k];
		for(int i = 0;i<n;i++)
		{
			A[i] = sc.nextInt();
		}
		for(int i = 0;i<k;i++)
		{
			B[i] = sc.nextInt();
		}
		Arrays.sort(B);
		Arrays.sort(A);
		long ans = 999999999999999999L;
		for(int i = 0;i<=k-n;i++)
		{
			long dist = 0L;
			for(int j = 0;j<n;j++)
			{
				dist=Math.max(dist, (Math.abs(A[j]-B[i+j])+Math.abs(B[i+j]-p))); 
		//		System.out.print(dist);
		//		System.out.print(" ");
			}
		//	System.out.println(ans);
			ans = Math.min(ans, dist);
		}
		System.out.println(ans);
		
	}
}