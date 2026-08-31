
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();
		if(a == 0 && b == 0) {
			if(c == 0)
				System.out.println(-1);
			else
				System.out.println(0);
			return;
		}
		if(a == 0) {
			System.out.println(1);
			System.out.printf("%.10f", -c / b);
			return;
		}
		double dert = b * b - 4 * a * c;
		if(dert < 0) {
			System.out.println(0);
		}
		else if(dert == 0) {
			System.out.println(1);
			double root = -b / (2 * a);
			System.out.printf("%.10f", root);

		}
		else if(dert > 0) {
			System.out.println(2);
			double sqd = Math.sqrt(dert);
			double minroot = (-b - sqd) / (2 * a);
			double maxroot = (-b + sqd) / (2 * a);
			if(minroot > maxroot) {
				double temp = minroot;
				minroot = maxroot;
				maxroot = temp;
			}
			System.out.printf("%.10f", minroot);
			System.out.println();
			System.out.printf("%.10f", maxroot);
		}
	}

}
