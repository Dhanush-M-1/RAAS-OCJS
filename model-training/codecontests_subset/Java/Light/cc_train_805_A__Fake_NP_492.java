import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CodeForces
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int l = input.nextInt();
		int r = input.nextInt();
		if (l == r)
		{
			System.out.println(l);
		} else
		{
			System.out.println(2);
		}
	}
}