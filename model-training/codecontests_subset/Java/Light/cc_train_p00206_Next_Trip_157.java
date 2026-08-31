import java.util.Scanner;

class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			int n = sc.nextInt(), total = 0;
			if (n == 0) break;
			boolean finish = false;
			for (int i = 0; i < 12; i++)
			{
				total += sc.nextInt() - sc.nextInt();
				if (!finish && total >= n)
				{
					System.out.println(i + 1);
					finish = true;
				}
			}
			if (!finish)
			{
				System.out.println("NA");
			}
		}
	}
}