import java.util.*;
public class Main 
{
	public static void main(String[] args) 
	{
		int time = 7200;
		Scanner stdIn = new Scanner(System.in);
		while(stdIn.hasNext())
		{
			int h = stdIn.nextInt();
			int m = stdIn.nextInt();
			int s = stdIn.nextInt();
			if(h == -1 && m == -1 && s == -1)
			{
				break;
			}
			int sum = time - (h * 3600 + m * 60 + s);
			int sum3 = sum * 3;
			h = sum / 3600;
			sum %= 3600;
			m = sum / 60;
			sum %= 60;
			s = sum;
			System.out.print("0" + h + ":");
			if(m < 10)
			{
				System.out.print("0" + m + ":");
			}
			else
			{
				System.out.print(m + ":");
			}
			if(s < 10)
			{
				System.out.println("0" + s);
			}
			else
			{
				System.out.println(s);
			}
			int h3, m3, s3;
			h3 = sum3 / 3600;
			sum3 %= 3600;
			m3 = sum3 / 60;
			sum3 %= 60;
			s3 = sum3;
			System.out.print("0" + h3 + ":");
			if(m3 < 10)
			{
				System.out.print("0" + m3 + ":");
			}
			else
			{
				System.out.print(m3 + ":");
			}
			if(s3 < 10)
			{
				System.out.println("0" + s3);
			}
			else
			{
				System.out.println(s3);
			}
		}
	}
}