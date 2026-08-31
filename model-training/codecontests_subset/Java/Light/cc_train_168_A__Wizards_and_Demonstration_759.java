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
		double n = sc.nextDouble();
		int k = sc.nextInt();
		double y = sc.nextDouble();
		long num = (long)Math.ceil(n * y / 100);
		System.out.println(Math.max(0 , num - k));
		
		sc.close();
	}
}
