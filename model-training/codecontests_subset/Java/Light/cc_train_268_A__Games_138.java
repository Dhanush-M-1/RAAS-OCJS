import java.io.*;
import java.util.*;

public class solution
{
	public static void main(String args[])
	{
		int MAX = 30;
		Scanner sc = new Scanner(System.in);
		int NumTestCases = sc.nextInt();
		int[] h = new int[MAX];
		int[] a = new int[MAX];
		for(int i=0;i<NumTestCases;i++)
		{
			a[i]=sc.nextInt();
			h[i]=sc.nextInt();
		}

		int count=0;
		for(int i =0 ; i<NumTestCases ; i++)
		{
			for(int j=0;j<NumTestCases;j++)
			{
				if(a[i]==h[j])
					count++;
			}
		}
	System.out.println(count);
	}
}