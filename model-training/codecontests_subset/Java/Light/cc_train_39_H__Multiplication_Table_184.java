import java.util.*;
import java.math.*;


public class MTable
{
	public static int decToRad(int n, int r)
	{
		String s = new String();
		int t, k;
		
		while(n > 0)
		{
			t = n % r;
			n /= r;
			s = t + s;
		}
		
		return Integer.parseInt(s);
	}
	
	public static void display(int n)
	{
		for(int i = 1; i < n; ++i)
			for(int j = 1; j < n; ++j)
			{
				if(j + 1 < n)
					System.out.print(decToRad(i * j, n) + " ");
				else
					System.out.println(decToRad(i * j, n));
			}
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		display(n);
	}
}

