import java.util.Scanner;

public class LetsWatchFootball
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		System.out.println((int)(Math.ceil((a * c) / (double)b) - c));
	}
}