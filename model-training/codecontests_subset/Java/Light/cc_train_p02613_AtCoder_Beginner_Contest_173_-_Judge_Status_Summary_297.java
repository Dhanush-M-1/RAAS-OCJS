import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		int ac = 0;
		int wa = 0;
		int tle = 0;
		int re = 0;
		for(int i = 0; i < n; i ++)
		{
			String temp = console.next();
			if(temp.equals("AC"))
			{
				ac ++;
			}
			else if(temp.equals("WA"))
			{
				wa ++;
			}
			else if(temp.equals("TLE"))
			{
				tle ++;
			}
			else
			{
				re ++;
			}
		}
		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.print("RE x " + re);		
	}
}
