import java.util.Scanner;

public class candles
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int a = in.nextInt(), b = in.nextInt();
		System.out.println((a*b-1)/(b-1));
	}
}