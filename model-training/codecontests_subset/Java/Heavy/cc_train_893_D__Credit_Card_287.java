//package cow17;
/*
LANG: JAVA
TASK: 
*/

import java.io.*;
import java.util.*;
public class cf4
{
	public static void main(String[] args) throws IOException
	{
		Scanner c = new Scanner(System.in);
		int N = c.nextInt(), D = c.nextInt();
		long[] arr = new long[N];
		for(int i=0; i<N; i++) arr[i] = c.nextLong();
		long[] pre = new long[N];
		pre[0] = arr[0];
		if(pre[0] > D) 
		{
			System.out.println(-1); return;
		}
		for(int i=1; i<N; i++) 
		{
			pre[i] = pre[i-1] + arr[i];
			if(pre[i] > D)
			{
				System.out.println(-1); return;
			}
		}
		
		long[] maxPre = new long[N];
		maxPre[N-1] = pre[N-1];
		for(int i=N-2; i>=0; i--)
		{
			maxPre[i] = Math.max(maxPre[i+1], pre[i]);
		}
		
		long curSum = 0; int count = 0;
		for(int i=0; i<N; i++)
		{
			curSum += arr[i];
			if(arr[i] == 0 && curSum < 0)
			{
				long flood = maxPre[i] - pre[i];
				long add = D-(curSum+flood); 
				if(flood > D)
				{
					System.out.println(-1); return;
				}
//				System.out.println(arr[i-1]);
				curSum += add; count++;
			}
		}
		System.out.println(count);
	}
}
