import java.util.*;
import java.io.*;

public class KingofThieves
{
	public static int n;
	public static String m;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.next();
		boolean c = test();
		if (c) System.out.println("yes");
		else System.out.println("no");
	}
	
	public static boolean test()
	{
		//iterate upward the starting index
		int start = -1;
		while (true)
		{
			start++;
			if (start >= m.length()) return false;
			
			//if start isn't on a platform, don't bother
			if (m.charAt(start) == '*')
			{
				//iterate upward the jumping interval
				int jump = 1;
				while (jump < m.length())
				{
					
					//perform the check - for loop - iterate, then check 4 times
					int index = start;
					boolean c = true;
					for (int i = 0; i < 4; i++)
					{
						index += jump;
						if (index >= m.length() || m.charAt(index) == '.')
						{
							c = false;
							break;
						}
					}
					if (c) return true;
					
					//if nothing was found, iterate jump up
					jump++;
				}
			}
		}
	}
}