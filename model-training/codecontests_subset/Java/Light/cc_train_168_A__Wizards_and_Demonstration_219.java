import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Success {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int x=scan.nextInt();
		int y=scan.nextInt();
		double a=(y*n)/100.0;
		Double pa=Math.ceil(a);
		int p=pa.intValue();
		if(p-x>0)
		System.out.println(p-x);
		else
			System.out.println(0);
			}
}
