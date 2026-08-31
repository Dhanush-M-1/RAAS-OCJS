import java.lang.*;
import java.io.*;
import java.util.*;

public class Codeforce_Solution1{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test!=0)
		{
			test--;
			int n = sc.nextInt();
			int first=0;
			int second=0;
			int third=0;
			int fourth=0;
			
			for(int i=0;i<n;i++)
			{
				String s=sc.next();
				for(int j=0;j<s.length();j++)
				{
					
					if(i==0)
						first=s.charAt(1)-(int)'0';
					if(i==1)
						second =s.charAt(0)-(int)'0';
					if(i==n-1)
						third =s.charAt(n-2)-(int)'0';
					if(i==n-2)
						fourth=s.charAt(n-1)-(int)'0';
				}
				
			}
			Helper(first,second,third,fourth,n);
		}
		
	}

	static void Helper(int first,int second,int third,int fourth,int n)
	{
		//int first=(int)list.get(0).charAt(1)-(int)'0';
		//int second = (int)list.get(1).charAt(0)-(int)'0';
		//int third = (int)list.get(n-1).charAt(n-2)-(int)'0';
		//int fourth = (int)list.get(n-2).charAt(n-1)-(int)'0';
		
		//System.out.print(first+" "+second+" "+third+" "+fourth);
		
		if(first == second && third == (1-first) && fourth == (1-first))
			System.out.println("0");
		else if(first == second && third ==fourth)
		{
			System.out.println("2");
			if(first == 1)
			{
				System.out.println("1 2");
				System.out.println("2 1");
			}
			else
			{
				System.out.println(n+" "+(n-1));
				System.out.println(n-1+" "+n);
			}
		}
		else if(first == second)
		{
			System.out.println("1");
			if(first == 1)
			{
				if(third == 1)
				{
					System.out.println(n+" "+(n-1));
				}
				else
				{
					System.out.println(n-1+" "+n);
				}
			}
			else
			{
				if(third == 0)
				{
					System.out.println(n+" "+(n-1));
				}
				else
				{
					System.out.println(n-1+" "+n);
				}
				
			}
		}
		else if(third == fourth)
		{
			System.out.println("1");
			if(third == 1)
			{
				if(first == 1)
				{
					System.out.println("1 2");
				}
				else
				{
					System.out.println("2 1"); 
				}
			}
			else
			{
				if(first == 0)
				{
					System.out.println("1 2");
				}
				else
				{
					System.out.println("2 1"); 
				}
				
			}
			
		}
			else
			{
				
				if(first == 1)
				{
					if(third == 0)
					{
						System.out.println("2");
						System.out.println("1 2");
						System.out.println(n+" "+(n-1));
					}
					else
					{
						System.out.println("2");
						System.out.println("1 2");
						System.out.println(n-1+" "+n);
					}
				}
				else
				{
					if(third == 1)
					{
						System.out.println("2");
						System.out.println("2 1");
						System.out.println(n-1+" "+n);
					}
					else
					{
						System.out.println("2");
						System.out.println("2 1");
						System.out.println(n+" "+(n-1));
					}
					
				}
			}
		}
	}
	
