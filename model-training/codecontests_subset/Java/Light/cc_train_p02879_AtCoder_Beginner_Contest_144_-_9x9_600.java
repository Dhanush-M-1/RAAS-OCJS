import java.util.*;

public class Main
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner (System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		if (a>9 || a<1 || b>9 || b<1)
			System.out.print (-1);
		else
			System.out.print (a*b);

	}
}