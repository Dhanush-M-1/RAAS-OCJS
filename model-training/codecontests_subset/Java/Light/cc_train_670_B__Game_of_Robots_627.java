import java.util.Scanner;


public class GameOfRobots
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		int [] a = new int [n];
		for (int i = 0; i < n; i++)
		{
			a[i] = sc.nextInt();
		}
		long prevSum = 1;
		long sum = 1;
		if(k == 1)
			System.out.println(a[0]);
		else
		{
			for (int i = 1; i < n; i++)
			{
				sum = prevSum + i + 1;
				if(sum >= k)
				{
					k -= prevSum;
					System.out.println(a[k-1]);
					break;
				}
				prevSum = sum;
			}
		}
	}
}
