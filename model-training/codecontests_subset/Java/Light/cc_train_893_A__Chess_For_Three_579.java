import java.util.Scanner;

public class P893A
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] win = new int[n];
		for (int i = 0; i < n; i++)
			win[i] = scan.nextInt();
		int watching = 3;
		for (int i = 0; i < n; i++)
		{
			if (win[i] == watching)
			{
				System.out.println("NO");
				return;
			}
			watching = 6-(watching+win[i]);
		}
		System.out.println("YES");
	}
}
