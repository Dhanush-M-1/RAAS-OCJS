

import java.util.ArrayList;
import java.util.Scanner;

public class Mafia3 
{
	static boolean debug = false;

	public static void main(String[] args) 
	{
//		System.out.println(Math.ceil((double)(5) / 2));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[] a = new long[n];
		long max = 0;
		
		for(int i = 0; i < n; i++)
		{
			a[i] = sc.nextLong();
			max = Math.max(max, a[i]);
		}
		
		long count = 0;
		
		for(int i = 0; i < n; i++)
		{
			count += max - a[i];
		}
		
		if(count >= max)
		{
			System.out.println(max);
			return;
		}
		else
		{
//			System.out.println("B" + count);
			long plus = max-count;
			count += (plus) + Math.ceil(((double)plus / (n-1)));
		}
		
		
		System.out.println(count);
		
	}

}
