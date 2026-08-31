
import java.util.Scanner;

public class Main {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int s[] = new int [n * 2];
		int c[] = new int [m * 2];

		for (int i = 0; i < n; ++i)
		{
			s[i * 2] = sc.nextInt();
			s[i * 2 + 1] = sc.nextInt();

			//System.out.print(s[i * 2] + " ");
			//System.out.println(s[i * 2 + 1]);
		}

		//System.out.println();

		for (int i = 0; i < m; ++i)
		{
			c[i * 2] = sc.nextInt();
			c[i * 2 + 1] = sc.nextInt();

			//System.out.print(c[i * 2] + " ");
			//System.out.println(c[i * 2 + 1]);
		}

		//System.out.println();

		sc.close();

		for (int i = 0; i < n; ++i)
		{
			int dist = Integer.MAX_VALUE, index = -1;

			//System.out.println(index + " " + dist);

			for (int j = 0; j < m; ++j)
			{
				int tmp = Math.abs(s[i * 2] - c[j * 2]) + Math.abs(s[i * 2 + 1] - c[j * 2 + 1]);

				if (tmp < dist)
				{
					dist = tmp;
					index = j + 1;

					//System.out.println("D:" + tmp + " " + dist + " " + index);
				}
			}

			System.out.println(index);
		}
	}
}
