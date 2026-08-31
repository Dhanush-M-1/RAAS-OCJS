/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int r1=sc.nextInt();
		int r2=sc.nextInt();
		
		int c1=sc.nextInt();
		int c2=sc.nextInt();
		
		int d1=sc.nextInt();
		int d2=sc.nextInt();
		int[][] a=new int[2][2];
		int flag=1;
		
		for(int i=1;i<=9;i++)
		{
			for(int j=1;j<=9;j++)
			{
				for(int k=1;k<=9;k++)
				{
					for(int l=1;l<=9;l++)
					{
						if(i!=j && j!=k && k!=l && i!=k && i!=l && j!=l)
						{
							if((i+j==r1) && (k+l==r2) && (i+k==c1) && (j+l==c2) && (i+l==d1) && (j+k==d2))
							{
								a[0][0]=i;
								a[0][1]=j;
								a[1][0]=k;
								a[1][1]=l;
								flag=0;
							}
						}
					}
				}
			}
		}
		
		if(flag==0)
		{
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				System.out.print(a[i][j]+" ");
					System.out.println();
			}
		
		}
		
		else
		System.out.println("-1");
	}
}