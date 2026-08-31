import java.io.*;
import java.util.*;
public class Ishu
{
	public static void main(String[] args)
	{
	Scanner scan=new Scanner(System.in);
	int t,n,i;
	t=scan.nextInt();
	while(t-->0)
		{
		n=scan.nextInt();
		long[] a = new long[n];
		for(i=0;i<n;++i)
			a[i]=scan.nextLong();
		if(a[0]+a[1]<=a[n-1])
			System.out.println("1 2 "+n);
		else
			System.out.println("-1");
		}
	}
}
