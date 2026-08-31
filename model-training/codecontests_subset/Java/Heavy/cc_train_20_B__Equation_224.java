import java.text.DecimalFormat;
import java.util.Scanner;


public class P20B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double a = in.nextInt();
		double b = in.nextInt();
		double c = in.nextInt();
		double d = b * b - 4 * a * c;
		double x = 0;
		double x1,x2;
		if (a == 0) {
			if(b == 0 && c == 0){
			System.out.println(-1);
			}
			else if (b != 0){
				System.out.println(1);
				x = -c/b;
				DecimalFormat df = new DecimalFormat("0.00000");
			    String xx = df.format(x);
				System.out.println(xx);
			}
			else if (b ==0 && c !=0){System.out.println(0);}
		} else if (d < 0) {
			System.out.println(0);
		} else if (d == 0) {
			System.out.println(1);
			x = (double) -b / (2 * a);
			DecimalFormat df = new DecimalFormat("0.00000");
		    String xx = df.format(x);
			System.out.println(xx);
		} else if (a != 0 && d > 0) {
			System.out.println(2);
			x1 = (double) ((-b - (double) Math.pow(d, 0.5))
					/ (2 * a));
			x2 = (double) ((-b + (double) Math.pow(d, 0.5))
					/ (2 * a));
			double z1 = Math.min(x1, x2);
			double z2 = Math.max(x1, x2);
			if (x1 == Math.floor(x1)){
			DecimalFormat df = new DecimalFormat("0.00000");
		    String xx1 = df.format(z1);
		    String xx2 = df.format(z2);
			System.out.println(xx1);
			System.out.println(xx2);
			}
			else if (x1 != Math.floor(x1)){
			System.out.println(Math.min(x1, x2));
			System.out.println(Math.max(x1, x2));
			}
		}
	}
}
