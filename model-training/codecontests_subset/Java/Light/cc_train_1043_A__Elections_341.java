/*package whatever //do not write package name here */

import java.util.*;

public class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),sum=0;;
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
		 a[i]=sc.nextInt();
		 sum+=a[i];
		}
		Arrays.sort(a);
		int v=(n*(a[n-1]))-sum;
		int q=(sum-v+1)/n;
			int r=(sum-v+1)%n;
		int r1=r>0?1:0;
		
		System.out.println(v>sum?a[n-1]:a[n-1]+q+r1);
		
	/*	int q=2*sum/n;
		int r=(2*sum)%n;
		int r1=r>0?1:0;
		if((q+r1)>a[n-1])
		System.out.println(q+r1);
		else*/
	//	System.out.println((sum-(a[n-1]))>a[n-1]?(sum-2*(a[n-1])):a[n-1]);
	}
}