
import java.util.*;
import java.lang.*;
import java.io.*;
public class Solve_CF {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int test;
		test=sc.nextInt();
		while(test-->0) {
			int n;
			n=sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) arr[i]=sc.nextInt();
			if((arr[0]+arr[1])<=arr[n-1]) {
				System.out.println(1+" "+2+" "+n);
				
			}
			else
			{
				System.out.println(-1);
			}
		}
		sc.close();
	}
}
