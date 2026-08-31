//package CodeForces;

import java.util.Scanner;

public class ArraySharpening {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=s.nextInt();
			}
			
			int a=0;
			for(int i=0;i<n;i++)
			{
				if(arr[i]<i)
				{
					break;
				}
				a=i;
			}
			int b=n-1;
			for(int i=n-1;i>=0;i--)
			{
				if(arr[i]<n-i-1)
				{
					break;
				}
				b=i;
			}
			
			if(b<=a)
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
			t--;
		}

	}

}
