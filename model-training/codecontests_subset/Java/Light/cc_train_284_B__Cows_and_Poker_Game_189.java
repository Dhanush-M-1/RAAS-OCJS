import java.util.*;
public class cowsAndPokerGame
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.next();
		int a[]=new int[26];
		for(int i=0;i<s.length();i++)
		{
			a[s.charAt(i)-'A']++;
		}
		
		if(a[8]==0)
		{
			System.out.println(a[0]);
		}
		
		else if(a[8]==1)
		{
			System.out.println("1");
		}
		
		else if(a[8]>1)
		{
			System.out.println("0");
		}
	}
}
