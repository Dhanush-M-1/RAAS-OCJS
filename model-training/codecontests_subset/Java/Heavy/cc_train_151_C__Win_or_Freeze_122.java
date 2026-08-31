import java.util.Scanner;
import java.util.HashMap;

public class C
{
	private static HashMap<Long, Long> win;
	
	private static long toWin(long num)
	{
		Long l = win.get(num);
		if (l != null) return l;
		else
		{
			boolean canary = false;
	
			for (int i = 2; i <= num/i; i++)
			{
				if (num % i == 0)
				{
					canary = true;
					if (toWin(i) == -1)
					{
						win.put(num, (long) i);
						return i;
					}
					else if (toWin(num/i) == -1)
					{
						win.put(num, num/i);
						return num/i;
					}
				}
			}
			if (canary)
			{
				win.put(num, -1L);
				return -1;
			}
			else
			{
				win.put(num, 0L);
				return 0;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Scanner myScanner = new Scanner(System.in);
		
		win = new HashMap<Long, Long>();
		
		long number = myScanner.nextLong();
		long res = toWin(number);
		
		if (res == -1) System.out.println(2);
		else System.out.format("1\n%d\n", res);
	}
}
