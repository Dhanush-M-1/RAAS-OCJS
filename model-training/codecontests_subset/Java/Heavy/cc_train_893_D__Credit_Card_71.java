

import java.util.Scanner;

public class CreditCard {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int lim = sc.nextInt();
		long[] a = new long[n];
		long[] stan = new long[n];
		
		for(int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		
		stan[0] = a[0];
		for(int i = 1; i < n; i++)
		{
			stan[i] = stan[i-1] + a[i];
		}
		
		long[] maxfrom = new long[n];
		
		maxfrom[n-1] = stan[n-1];
		for(int i = n-2; i >= 0; i--)
			maxfrom[i] = Math.max(maxfrom[i+1], stan[i]);
		
		long money = 0;
		long offset = 0;
		int times = 0;
		for(int i = 0; i < n; i++)
		{
			money += a[i];
			
			if(money > lim)
			{
				System.out.println(-1);
				return;
			}
			
			if(a[i] == 0 && money + offset < 0)
			{
				//we need to add at least -money, but we want to add as much as possible
				//lim - (maxfrom + offset)
				long add = lim - (maxfrom[i] + offset);
				if(add < -(money+offset))
				{
					System.out.println(-1);
					return;
				}
				//add "add" amount of money
				offset += add;
				times++;
			}
		}
		System.out.println(times);
	}

}
