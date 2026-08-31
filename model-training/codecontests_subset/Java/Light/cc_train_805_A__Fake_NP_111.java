
import java.util.Scanner;

public class Fnp {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long n = scn.nextLong();
		long s = scn.nextLong();
		
		if(s-n<=3)
		{
			if(s%n==0)
			{
				System.out.print(n);
				return;
			}
		}
		System.out.println("2");
		
	}

}
