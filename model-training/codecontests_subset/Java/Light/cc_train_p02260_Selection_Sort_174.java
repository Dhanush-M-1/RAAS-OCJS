import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] ary = new int[N];

		for (int i = 0; i < N; i++)
		{
			ary[i] = sc.nextInt();
		}

		int numSwap = 0;

		for (int i = 0; i < N; i++)
		{
			int minj = i;
			for (int j = i; j < N; j++)
			{
				if (ary[j] < ary[minj])
				{
					minj = j;
				}
			}

			if (i != minj)
			{
				numSwap++;
				int temp = ary[i];
				ary[i] = ary[minj];
				ary[minj] = temp;
			}
		}


		for (int i = 0; i < N; i++)
		{
			System.out.print(ary[i]);
			if (i < N - 1)
			{
				System.out.print(" ");
			}
		}
		System.out.println("");
		System.out.println(numSwap);
	}
}
