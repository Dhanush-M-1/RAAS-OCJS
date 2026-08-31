
import java.util.LinkedList;
import java.util.Scanner;

public class C {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		long a = scan.nextLong();
		factorize(a);
	}

	public static void factorize(long num)
	{
		long a = num;
		LinkedList<Long> q = new LinkedList<Long>();
		for (long i = 2; i * i <= num && num > 1; i++)
			if (num % i == 0)
			{
				while (num % i == 0 && num > 1)
				{
					q.add(i);
					num /= i;
				}
			}
		if (num > 1 && num != a)
			q.add(num);
		if (q.isEmpty())
		{
			System.out.println(1 + "\n0");
		} else if (q.size() <= 2)
		{
			System.out.println(2);
		} else
		{
			System.out.println("1\n" + q.get(0) * q.get(1));
		}
	}
}
