import java.util.Scanner;

public class Equation {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();
		in.close();
		
		if (a == 0 && b == 0 && c == 0) {
			System.out.println("-1");
			return;
		}
		else if (a == 0 && b == 0 && c != 0) {
			System.out.println("0");
			return;
		}
		
		double doubleRoot = -b / (2*a);
		double delta = Math.pow(b, 2) - 4*a*c;
		
		if (delta < 0) {
			System.out.println("0");
		}
		else if (a == 0) {
			System.out.println("1");
			System.out.format("%.5f%n", -c / b);
		}
		else if (delta == 0) {
			System.out.println("1");
			System.out.format("%.5f%n", doubleRoot);
		}
		else {
			System.out.println("2");
			double d = Math.sqrt(delta)/(2*a);
			if (d < 0) d = -d;
			System.out.format("%.5f%n", doubleRoot - d);
			System.out.format("%.5f%n", doubleRoot + d);
		}
	}
}