import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CodeForces
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int c = input.nextInt();
		int v0 = input.nextInt();
		int v1 = input.nextInt();
		int a = input.nextInt();
		int l = input.nextInt();
		int num = 0;
		int count = 0;
		while (num < c)
		{
			if (count == 0)
			{
				num += v0;
			} else
			{
				num += (Math.min(v0 + count * a - l, v1 - l));
			}
			count++;
		}
		System.out.println(count);
	}
}