import java.util.Scanner;
import java.io.*;

public class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n, m;
		while(true)
		{
			n = sc.nextInt();
			m = sc.nextInt();
			if(n == 0 && m == 0)
			{
				break;
			}
			for (int i = 0; i < n; i++)
			{
				for (int j =0; j < m; j++)
				{
					if((i+j)%2==0)
					{
						System.out.print("#");
					}
					else
					{
						System.out.print(".");
					}
				}
				System.out.println();
			}
			System.out.println();
		}
		sc.close();
	}
}
