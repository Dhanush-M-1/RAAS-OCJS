import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CodeForces
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = input.nextInt();
		for (int i = 0; i < t; i++)
		{
			int a = input.nextInt();
			int b = input.nextInt();
			int c = input.nextInt();
			int max = 0;
			for (int x = 0; x <= a; x++)
			{
				for (int y = 0; y <= b; y++)
				{
					if (x <= a && 2 * x + y <= b && 2 * y <= c)
					{
						if (3 * x + 3 * y >= max)
						{
							max = 3 * x + 3 * y;
						}
					}
				}
			}
			System.out.println(max);
		}
	}
}