import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long p = sc.nextLong();
		long w = sc.nextLong();
		long d = sc.nextLong();
		long cnt = (int)Math.pow(10,5)+2;
		long i = 0;
		while (cnt-->0)
		{
			if(p%w==0)
			{
				if((i+p/w)>n)
					break;
				System.out.println(p/w+" "+i+" "+(n-(i+p/w)));
				System.exit(0);
			}
			p = p - d;
			if(p<0)
				break;
			i++;
		}
		System.out.println("-1");
		System.exit(0);
	}
}