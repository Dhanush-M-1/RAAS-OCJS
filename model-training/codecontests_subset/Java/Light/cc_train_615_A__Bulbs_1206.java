import java.util.*;
import java.io.*;

public class A615
{
	
public static void main(String[] args)
{
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[] x = new int[n];
		int[][] y = new int[n][m];
		
		
		for(int i=0;i<n;i++)
		{
			x[i]=in.nextInt();
			for(int j=0;j<x[i];j++)
			    y[i][j] = in.nextInt();
		}
		
		int[] ans = new int[m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<x[i];j++)
			{
				ans[y[i][j]-1]=1;
			}
		}
		int sum=0;
		for(int i=0;i<m;i++)
			sum+=ans[i];
		
		if(sum==m)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}
	
}

