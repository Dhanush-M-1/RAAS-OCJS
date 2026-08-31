import java.util.Scanner;

public class CF2
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int c = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = scan.nextInt();
		}
		int max = 0;
		for (int i = 1; i < n; i++)
			max = Math.max(max, arr[i-1]-arr[i]);
		System.out.println(Math.max(max-c, 0));
		
		scan.close();
	}
}