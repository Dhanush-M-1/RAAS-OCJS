import java.util.*;

public class CodeForces
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		long sum1 = 0;
		long sum2 = 0;

		for (int i = 0; i < n; i++)
		{
			sum1 += input.nextLong();
		}
		for (int i = 0; i < n - 1; i++)
		{
			long z = input.nextLong();
			sum2 += z;
			sum1 -= z;
		}
		for (int i = 0; i < n - 2; i++)
		{
			Long z = input.nextLong();
			sum2 -= z;
		}
		System.out.println(sum1);
		System.out.println(sum2);
	}
}