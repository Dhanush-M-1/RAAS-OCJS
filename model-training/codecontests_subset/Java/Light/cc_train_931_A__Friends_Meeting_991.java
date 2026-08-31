import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Codeforces 
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int l = Math.min(a , b);
		int r = a + b - l;
		int i;
		int m = (l + r) / 2;
		a = (m - l);
		b = (r - m);
		l = a * (a + 1) / 2;
		r = b * (b + 1) / 2;
		System.out.println(l + r);
		
		sc.close();
	}
}


