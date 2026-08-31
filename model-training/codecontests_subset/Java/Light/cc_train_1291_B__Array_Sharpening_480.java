

import java.util.Scanner;

public class Demo13 {
	
	
	private static String findAns(int [] a)
	{
		String ans="Yes";
		int tIndex= -1;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<i)
			{
				tIndex=i;
				break;
			}
		}
		if(tIndex == -1)
		{
			return "Yes";
		}
		
		int counter=0;
		
		for(int i=a.length-1;i>=tIndex;i--)
		{
			if(a[i]>=counter)
			{
			}
			else
			{
				return "No";
			}
				counter++;
		}
		if(a[tIndex-1]==tIndex-1 && a[tIndex] == counter-1 &&a[tIndex] == a[tIndex-1])
		{
			return "No"	;
		}
		
		return ans;
	}
	
	
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for(int i =0;i<t;i++)
		{
			int n = in.nextInt();
			
			int [] a = new int [n];
			
			for(int j=0;j<n;j++)
			{
				a[j] = in.nextInt();
			}
			
			System.out.println(findAns(a));
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
