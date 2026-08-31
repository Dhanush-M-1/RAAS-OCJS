//package CodeForces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MathShow {
	
	static int solve(int n,int arr[],int index,int m)
	{
		if(index==arr.length)
		{
			return 0;
		}
		int ans=0;
		if(arr[index]*n<=m)
		{
			m=m-n*arr[index];
			ans=n;
			return ans+solve(n,arr,index+1,m);
		}
		else
		{
			int temp=m/arr[index];
			return temp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt();
		int m=s.nextInt();
		int arr[]=new int[k];
		int sum=0;
		for(int i=0;i<k;i++)
		{
			arr[i]=s.nextInt();
			sum=sum+arr[i];
		}
		Arrays.sort(arr);
		if(sum*n<=m)
		{
			System.out.println((k+1)*n);
		}
		else
		{
			int ans=0;
			for(int i=0;i<n;i++)
			{
				int p=m;
				if(p>=i*sum)
				{
					p=p-i*sum;
				}
				else
				{
					break;
				}
				int points=i*(k+1);
				for(int j=0;j<k&&p>0;j++)
				{
					if(arr[j]*(n-i)<=p)
					{
						p=p-arr[j]*(n-i);
						points=points+n-i;
					}
					else
					{
						points=points+p/arr[j];
						break;
					}
				}
				ans=Math.max(ans, points);
			}
			System.out.println(Math.max(ans,solve(n,arr,0,m)));
		}
		
		
		

	}

}
