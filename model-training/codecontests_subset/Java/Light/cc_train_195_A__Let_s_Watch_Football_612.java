import java.util.Scanner;


public class LetsWatchFootball {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		double x = (((a*c)/b)-(c));
		int ans  = (int)Math.ceil(x);
		System.out.println(ans);
		
	}

}
