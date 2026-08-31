import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Codeforces 
{

	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int i , j;
		int q = sc.nextInt();
		while(q-- > 0)
		{
			long l = sc.nextLong();
			long r = sc.nextLong() + 1;
			long d = sc.nextLong();
			if(d < l)
				System.out.println(d);
			else
				System.out.println(((r + d - 1) / d) * d);
		}
		
		sc.close();
	}
}
