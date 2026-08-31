//package codeforcesQuestions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cdf350b 
{
	public static void main(String args[])throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		String ss[]=s.split(" ");
		int n=Integer.parseInt(ss[0]);
		int k=Integer.parseInt(ss[1]);
		k--;
		int arr[]=new int[n];
		s=br.readLine();
		String str[]=s.split(" ");
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(str[i]);
		long temp=1;
		while(!((temp*(temp+1))/2>k))
			temp++;
		//System.out.println(temp);
		k-=((temp*(temp-1))/2);
		System.out.println(arr[k]);
	}
}
