//package CodeForces;

import java.util.Scanner;

public class BadTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int arr[]=new int[n];
			boolean done=false;
			for(int i=0;i<n;i++)
			{
				arr[i]=s.nextInt();
			}
			if(arr[0]+arr[1]<=arr[n-1])
			{
				System.out.println(1+" "+2+" "+n);
			}
			else
			{
				System.out.println(-1);
			}
			t--;
			
		}

	}

}
