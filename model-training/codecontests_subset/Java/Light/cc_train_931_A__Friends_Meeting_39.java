import java.io.*;
import java.util.*;
public class cf
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		if(a>b)
		{
			int temp=a;
			a=b;
			b=temp;
		}
		if(b-a==1)
		{
			System.out.println(1);
		}
		else
		{
		int avg=(a+b)/2;
		int n=avg-a;
		int tired=n*(n+1)/2;
		n=b-avg;
		tired+=(n*(n+1))/2;
		System.out.println(tired);
	}
	}
}