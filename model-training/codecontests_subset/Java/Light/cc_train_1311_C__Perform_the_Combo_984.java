

import java.util.Arrays;
import java.util.Scanner;

public class Demo04 {
	
	
	private static String findAns(int n  , int m ,String s, int []p)
	{
		
		String ans ="";
		
		int [] alpha = new int [26];
		Arrays.fill(alpha, 0);
		Arrays.sort(p);
		
		int prev =0;
		for(int i =0;i<m;i++)
		{
			for(int j =prev;j<p[i];j++)
			{
				alpha[(int)s.charAt(j)-97] =  alpha[(int)s.charAt(j)-97]+(m-i);
			}
			
			prev = p[i];
			
			
		}
		
		
		for(int i =0;i<s.length();i++)
		{
			alpha[(int)s.charAt(i)-97]++;
		}
		
		for(int k=0;k<26;k++)
		{
			
			if(k!=25)
			{
				ans+=(alpha[k]+" ");
			}
			else
			{
				ans+=(alpha[k]);
			}
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
			int m = in.nextInt();
			
			int [] p =new int [m];
			
			String s = in.next();
			
			for(int j=0;j<m;j++)
			{
				p[j] = in.nextInt();
			}
			
			System.out.println(findAns(n,m,s,p));
			
			
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
