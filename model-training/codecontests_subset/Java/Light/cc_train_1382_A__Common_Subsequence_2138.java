//package CodeForces;

import java.util.HashMap;
import java.util.Scanner;

public class Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t>0)
		{
			int n=s.nextInt();
			int m=s.nextInt();
			int arr1[]=new int[n];
			int arr2[]=new int[m];
			HashMap<Integer,Boolean> map=new HashMap<>();
			for(int i=0;i<n;i++)
			{
				arr1[i]=s.nextInt();
				map.put(arr1[i],true);
			}
			int ans=-1;
			for(int i=0;i<m;i++)
			{
				arr2[i]=s.nextInt();
				if(map.containsKey(arr2[i]))
				{
					ans=arr2[i];
				}
			}
			
			if(ans!=-1)
			{
				System.out.println("YES");
				System.out.println(1+" "+ans);
			}
			else
			{
				System.out.println("NO");
			}
			
			t--;
		}

	}

}
