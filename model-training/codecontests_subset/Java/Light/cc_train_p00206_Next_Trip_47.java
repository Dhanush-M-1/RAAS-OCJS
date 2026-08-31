import java.util.Scanner;

public class Main
{
	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			int ob = sc.nextInt();
			if(ob == 0)
				return;
			int total = 0;
			int month = 0;
			int x=12;
			while(x-->0)
			{
				int m = sc.nextInt();
				int n = sc.nextInt();
				total = total+m-n;
				month++;
				if(total>=ob)
				{
					System.out.println(month);
					ob = Integer.MAX_VALUE;
				}
				if(month==12 && ob!=Integer.MAX_VALUE)
				{
					System.out.println("NA");
				}
			}
		}
	}
}