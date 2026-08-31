
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class codeforces {


	public static void main(String args[]) 
	{
      
		Scanner in = new Scanner(System.in);
		int n= in.nextInt();
		int a[] = new int [n];
		int i=0,j=0;
		int res=0;
		for(i=0;i<n;i++)
		{
			a[i]= in.nextInt();
		}
		int even=0;
		int odd=0;
		for(i=0;i<n;i++)
		{
			if(a[i]%2==0)
			{
				even++;
			}
			else
			{
				odd++;
			}
		}
		boolean status=true;
		if(Math.abs(even-odd)==1 || (even-odd)==0)
		{
			System.out.println("0");
		}
		else
		{
			if(even>odd)
			{
				Arrays.sort(a);
				int k=even-odd-1;
				j=0;
				while(j<=k)
				{
					for(i=0;i<a.length;i++)
					{
						if(a[i]%2==0)
						{
							res=res+a[i];
							j++;
						}
						if(j==k)
						{
							status=false;
							break;
						}
					}
					if(status==false)
						break;
				}
			}
			else
			{
				Arrays.sort(a);
				int k=odd-even-1;
				j=0;
				while(j<=k)
				{
					for(i=0;i<a.length;i++)
					{
						if(a[i]%2!=0)
						{
							res=res+a[i];
							j++;
						}
						if(j==k)
						{
							status=false;
							break;
						}
					}
					if(status==false)
						break;
			}
		}
			System.out.println(res);
	}
	}
	
}
