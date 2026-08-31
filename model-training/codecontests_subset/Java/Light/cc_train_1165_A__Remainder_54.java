import java.util.*;
public class Solution
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		String str  = sc.next();
		int count=0;
		int j=0;
		for(int i=n-1;j<x;i--)
		{
			if(j==x || j==y)
			{
				if(str.charAt(i)!='1')
				count++;
			}
			else
			if(str.charAt(i)!='0')count++;
			j++;
//			System.out.println(count);
		}
		System.out.println(count);
	}
}