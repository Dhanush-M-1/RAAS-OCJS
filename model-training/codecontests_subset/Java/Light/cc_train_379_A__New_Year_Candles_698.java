import java.util.Scanner;

public class A379
{
	static int a = 0;
	static int count = 0;
	public static void main(String... args)
	{
		Scanner in = new Scanner(System.in);
		a = in.nextInt();
		int b = in.nextInt();
		int diff = 0;
		count = a;
		while ((diff = qw(b)) >= b)
		{
			a = diff;
		}
		System.out.println(count);
	}

	public static int qw(int b)
	{
		int diff = 0;
		while (a != 0)
		{
			diff += a % b;
			a = a / b;
			count += a;
		}
		return diff;
	}
}