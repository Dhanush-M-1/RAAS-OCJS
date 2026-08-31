import java.util.*;

class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		int ac=0;
		int re=0;
		int wa=0;
		int tle=0;
		for(int i=0;i<n;i++)
		{
			String s=in.next();
			if(s.charAt(0)=='A')
			{
				ac++;
			}
			else if(s.charAt(0)=='R')
			{
				re++;
			}
			else if(s.charAt(0)=='W')
			{
				wa++;
			}
			else if(s.charAt(0)=='T')
			{
				tle++;
			}
		}
		System.out.println("AC x "+ac);
		System.out.println("WA x "+wa);
		System.out.println("TLE x "+tle);
		System.out.println("RE x "+re);
	}
}