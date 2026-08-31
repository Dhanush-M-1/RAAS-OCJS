import java.util.Scanner;

class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		while (true)
		{
			int n = sc.nextInt();
			if (n == 0) break;
			long num[] = new long[n];
			for (int i = 0; i < n; i++)
			{
				num[i] = sc.nextLong();
			}
			long count = 0;
			for (int i = n; i > 0; i--)
			{
				for (int j = 1; j < i; j++)
				{
					if (num[j-1] > num[j])
					{
						long tmp = num[j-1];
						num[j-1] = num[j];
						num[j] = tmp;
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}