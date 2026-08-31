import java.util.Scanner;
public class Main
{
	public static void main(String arg[])
	{
		int re=0;
		int hi=0;
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
			String st[] = in.next().split(",");
			int a=Integer.valueOf(st[0]);
			int b=Integer.valueOf(st[1]);
			int c=Integer.valueOf(st[2]);

			if(a*a+b*b==c*c)
				re++;
			else if(a==b)
				hi++;
		}
		System.out.println(re);
		System.out.println(hi);
	}
}