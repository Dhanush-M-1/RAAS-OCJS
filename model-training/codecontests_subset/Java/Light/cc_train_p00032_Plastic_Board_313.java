import java.util.Scanner;

class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in).useDelimiter("[,\n]");
		
		int rect = 0;
		int diam = 0;
		
		while (true)
		{
			try
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				if (a * a + b * b == c * c)
					rect++;
				else if (a == b)
					diam++;
			}
			catch (Exception e)
			{
				break;
			}
		}
		System.out.println(rect);
		System.out.println(diam);
	}
}