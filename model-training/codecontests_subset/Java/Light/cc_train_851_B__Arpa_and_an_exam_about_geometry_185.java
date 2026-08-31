import java.util.Scanner;

public class angle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long x1 = in.nextInt();
		long y1 = in.nextInt();
		long x2 = in.nextInt();
		long y2 = in.nextInt();
		long x3 = in.nextInt();
		long y3 = in.nextInt();
		long d1 = ((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		long d2 = ((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
		if((d1 == d2) && ((y2-y1)*(x3-x2) != (y3-y2)*(x2-x1)) )
	 	{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
		in.close();
	}

}
