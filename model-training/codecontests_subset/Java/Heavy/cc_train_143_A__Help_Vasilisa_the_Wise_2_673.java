import java.util.Scanner;

public class HelpVasilisatheWise2
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int r1 = input.nextInt();
		int r2 = input.nextInt();
		int c1 = input.nextInt();
		int c2 = input.nextInt();
		int d1 = input.nextInt();
		int d2 = input.nextInt();
		if ((r1 + c1 - d2) % 2 != 0)
		{
			System.out.println(-1);
		}
		int a00 = (r1 + c1 - d2) / 2;
		int a01 = r1 - a00;
		int a10 = c1 - a00;
		int a11 = d1 - a00;
		if (a00 >= 1 && a00 <= 9 &&
			a01 >= 1 && a01 <= 9 &&
			a10 >= 1 && a10 <= 9 &&
			a11 >= 1 && a11 <= 9)
		{
			int[] res = new int[10];
			for (int i = 0; i < 10; ++i)
			{
				res[i] = 0;
			}
			++res[a00];
			++res[a01];
			++res[a10];
			++res[a11];
			if (res[a00] == 1 &&
				res[a01] == 1 &&
				res[a10] == 1 &&
				res[a11] == 1)
			{
				if (a00 + a01 == r1 &&
					a10 + a11 == r2 &&
					a00 + a10 == c1 &&
					a01 + a11 == c2 &&
					a00 + a11 == d1 &&
					a01 + a10 == d2)
				{
					System.out.println(a00 + " " + a01 + "\n" + a10 + " " + a11);
				}
				else
				{
					System.out.println(-1);
				}
			}
			else
			{
				System.out.println(-1);
			}
		}
		else
		{
			System.out.println(-1);
		}
	}
}