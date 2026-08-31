import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String str=sc.next();
		char ch=str.charAt(0);
		int s=0;int e=0;int f=0;
		for( int i=1;i<n;i++)
		{
			if(str.charAt(i)>=ch)
			{
				ch=str.charAt(i);
				s=i;
			}
			else
			{
				e=i;f=1;
				break;
			}
		}s++;e++;
		if(f==1)
		{
			System.out.println("YES");
			System.out.println((s)+" "+(e));
		}
		else
		{
			System.out.println("NO");
		}
	}
}