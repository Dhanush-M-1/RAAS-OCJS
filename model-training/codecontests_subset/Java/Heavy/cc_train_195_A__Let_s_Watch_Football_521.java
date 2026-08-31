import java.util.Scanner;

public class main
{
	public static void main(String arg[])
	{

		Scanner in = new Scanner(System.in);
/*
		double a = 14.0;
		double b = 3.0;
		
		double c = a/b;
		

		System.out.println(c);
		System.out.println(Math.ceil(c));
	*/	
		//while (true)
		//{
			int r3;

			int watch = in.nextInt();
			int dl = in.nextInt();
			int length = in.nextInt();

			double r = length * watch;
			double r2 = (r - (length * dl)) / (double) dl;

			if ((r2 - (int) r2) > 0.0)
			{
				r3 = (int) r2 + 1;
			} 
			else
			{
				r3 = (int) r2;
			}
			
			if (r2 >0 && r2 < 1)
				r3 =1;
			//r3 = (int) r2 + 1;
			
			
			System.out.println((int)Math.ceil(r2));
		}
	//}

}
