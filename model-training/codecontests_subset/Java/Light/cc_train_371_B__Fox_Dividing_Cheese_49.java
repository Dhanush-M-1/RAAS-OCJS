import java.util.Scanner;

public class FoxDividingCheese
{
	public static int HasNum(int n, int[] res, int[] num)
	{
		for (int i = 0; i < num.length; ++i)
		{
			while (n % num[i] == 0)
			{
				n /= num[i];
				++res[i];
			}
		}
		return n;
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int[] num = {2, 3, 5};
		int len = num.length;
		int[] numOfa = new int[len];
		int[] numOfb = new int[len];
		for (int i = 0; i < len; ++i)
		{
			numOfa[i] = 0;
			numOfb[i] = 0;
		}
		a = HasNum(a, numOfa, num);
		b = HasNum(b, numOfb, num);
		if (a != b)
		{
			System.out.println(-1);
			return;
		}
		int sum = 0;
		for (int i = 0; i < len; ++i)
		{
			sum += numOfa[i] > numOfb[i] ? numOfa[i] - numOfb[i] : numOfb[i] - numOfa[i];
		}
		System.out.println(sum);
	}
}