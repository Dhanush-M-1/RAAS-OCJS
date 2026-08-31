
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
		
		stan[0] = a[0]; //stan: amount of money per day if we didn't deposit at all.
		for(int i = 1; i < n; i++)
			stan[i] = stan[i-1] + a[i]; 
		
		long[] maxfrom = new long[n]; //max of stan from i onwards, for each i.
		//this is used to determine how much money we can deposit at a given day,
		//without triggering an over-limit at a later date.
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
				//we need to add at least -(money+offset), but we want to add as much as possible
				//max amount that we can add, without exceeding any limit ahead:
				long add = lim - (maxfrom[i] + offset); 
				if(add < -(money+offset))
				{ //if that's not enough to make balance non-negative, resign.
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
