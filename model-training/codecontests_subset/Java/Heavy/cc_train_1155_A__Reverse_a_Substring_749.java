//package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseSubString {
	
	static void solve(String str)
	{
		int arr[]=new int[26];
		Arrays.fill(arr,-1);
		boolean done=false;
		for(int i=0;i<str.length();i++)
		{
			arr[str.charAt(i)-'a']=i;
			for(int j=str.charAt(i)-'a'+1;j<26;j++)
			{
				if(arr[j]!=-1)
				{
					System.out.println("YES");
					System.out.println(Math.min(i+1,arr[j]+1)+" "+Math.max(i+1,arr[j]+1));
					done=true;
					break;
				}
			}
			
			if(done)
			{
				break;
			}
		}
		
		if(!done)
		{
			System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		String str=s.next();
		solve(str);

	}

}
