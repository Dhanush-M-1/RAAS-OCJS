import java.util.*;
import java.io.*;

public class Main
{	
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Long s = 0L;
		Long m = 0L;
		for(int i = 0; i < n; i++)
		{
			Long x = in.nextLong();
			s += x;
		}
		m = s;
		for(int i = 1; i < n; i++)
		{
			Long x = in.nextLong();
			s -= x;
		}
		System.out.println(s);
		m -= s;
		for(int i = 2; i < n; i++)
		{
			Long x = in.nextLong();
			m -= x;
		}
		System.out.println(m);
	}
}