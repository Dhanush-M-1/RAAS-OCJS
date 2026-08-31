//package pack;

import java.util.Scanner;

public class first
{
	public static void main(String[] args)
	{	
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int result=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{	int current=sc.nextInt();
			int mintimetofetchcurrentprize=Math.min(current-1, 1000000-current);
			result=Math.max(result, mintimetofetchcurrentprize);
		}
		System.out.println(result);
	}
}