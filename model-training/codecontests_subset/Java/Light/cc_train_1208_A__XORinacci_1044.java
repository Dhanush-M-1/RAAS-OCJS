import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CodeForces
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int T = input.nextInt();
		for (int i = 0; i < T; i++)
		{
			int a = input.nextInt();
			int b = input.nextInt();
			int c = a ^ b;
			int n = input.nextInt();
			if (n % 3 == 0)
			{
				System.out.println(a);
			} else if (n % 3 == 1)
			{
				System.out.println(b);
			} else
			{
				System.out.println(c);
			}
		}
	}
}