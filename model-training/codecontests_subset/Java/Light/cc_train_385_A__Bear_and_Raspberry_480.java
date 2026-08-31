import java.util.Scanner;

public class raspberry
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), c = in.nextInt(), a = 0, d = 0, m = 0;
		for(int i = 0; i < n; i++, d = a)
		{
			a = in.nextInt();
			m = Math.max(d-a-c, m);
		}
		System.out.println(m);
	}
}