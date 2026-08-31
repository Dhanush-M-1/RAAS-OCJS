import java.util.*;
import java.math.*;
public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = 1; i <= n - 1; i++)
		{
			for (int j = 1; j <= n - 1; j++)
			{
				BigInteger temp = new BigInteger(String.valueOf(i * j));
				
				if (j != n - 1)
					System.out.print(temp.toString(n) + " ");
				else
					System.out.println(temp.toString(n));
			}
		}
	}
}
