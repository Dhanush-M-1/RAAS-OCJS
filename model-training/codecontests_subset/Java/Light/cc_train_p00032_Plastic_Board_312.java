import java.util.Scanner;


public class Main
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		int rc = 0;
		int lz = 0;
		for(; scanner.hasNext();)
		{
			String str = scanner.next();
			String[] s = str.split(",");
			
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			if(a*a + b*b == c*c)
			{
				rc ++;
			}
			else if(a>=c && b>=c)
			{
				lz ++;
			}
		}
		
		System.out.println(rc);
		System.out.println(lz);
	}
}