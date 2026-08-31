import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main
{	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for(int test = 0 ; test < t ; test++)
		{
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			String s = scanner.next();
			int[] fr = new int[26];
			int[] cum = new int[n + 2];
			cum[1] = 1;
			for(int i = 0, p ; i < m ; i++)
			{
				p = scanner.nextInt();
				cum[1] += 1;
				cum[p + 1] -= 1;
			}
			for(int i = 1 ; i <= n ; i++)
			{
				cum[i] += cum[i - 1];
			}
			for(int i = 1 ; i <= n ; i++)
			{
				fr[s.charAt(i - 1) - 'a'] += cum[i];
			}
			for(int i = 0 ; i < 26 ; i++)
			{
				System.out.print(fr[i] + " ");
			}
			System.out.println();
		}
		scanner.close();
	}
}