import java.util.Arrays;
import java.util.Scanner;

public class P846B
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int m = scan.nextInt();
		int[] arr = new int[k];
		for (int i = 0; i < k; i++)
			arr[i] = scan.nextInt();
		Arrays.sort(arr);
		int sum = 0;
		for (int i = 0; i < arr.length; i++)
			sum += arr[i];
		int max = 0;
		for (int e = 0; e <= n; e++)
		{
			if (sum*e > m)
				break;
			int mm = m;
			mm -= sum*e;
			int p = k*e + e;
			Outer:
			for (int i = 0; i < arr.length; i++)
			{
				for (int j = 0; j < n-e; j++)
				{					
					if (arr[i] > mm)
						break Outer;
					mm -= arr[i];
					p++;
				}
			}
			max = Math.max(max, p);
		}
		System.out.println(max);
	}
}
