import java.util.Scanner;

public class A478
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int sum = 0;
		for (int i = 0; i < 5; i++)
		{
			sum += scan.nextInt();
		}

		if (sum == 0)
		{
			System.out.println(-1);
		}
		else if (sum % 5 == 0)
		{
			System.out.println(sum / 5);
		}
		else
		{
			System.out.println(-1);
		}
	}
}