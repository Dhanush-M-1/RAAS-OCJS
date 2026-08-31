
import java.util.Scanner;

public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		int sub = (int) Math.ceil(y*n/100.0);
		if(sub > x)
			System.out.println(sub-x);
		else
			System.out.println(0);
	}

}
