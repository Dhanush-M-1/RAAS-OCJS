import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		long d=s.nextLong();
		
		long[] arr=new long[n];
		
		for(int i=0;i<n;i++)
		{
			arr[i]=s.nextLong();
		}
		
		int p=0;
		
		int count=0;
		long balance=0;
		long canadd=0;
		
		for(int i=0;i<n;i++)
		{
			if(arr[i]>0)
			{
				balance=balance+arr[i];
				
				if(balance>d)
				{
					p=1;
					break;
				}
				else
				{
					canadd=Math.min(canadd,d-balance);
				}
			}
			else if(arr[i]<0)
			{
				balance=balance+arr[i];
			}
			else
			{
				if(balance<0)
				{
					if(canadd+balance>=0)
					{
						canadd=canadd+balance;
						balance=0;
					}
					else
					{
						count++;
						balance=0;
						canadd=d;
					}
				}
			}
		}
		
		if(p==0)
		{
			System.out.println(count);
		}
		else
		{
			System.out.println(-1);
		}
		
	}
	
}