
import java.util.Scanner;

public class Cola
{
	public static void main(String [] args)
	{
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		int count=0;
		for(int i=0;i<=a;i+=2) 
		{
			for(int j=0;j<=c;j++) 
			{
				if(n-(i/2+j*2)<=b&&n-(i/2+j*2)>=0) 
				{
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
