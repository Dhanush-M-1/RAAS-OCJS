import java.util.*;

public class equation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long d = (long) b*b-4*a*c;
		if (d < 0) {
			System.out.println(0);
		}
		else if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					System.out.println(-1);
				}
				else {
					System.out.println(0);
				}
			}
			else {
				System.out.println(1);
				System.out.println(-1.0*c/b);
			}
		}
		else if (d == 0) {
			System.out.println(1);
			System.out.println((double) ((-b)/(2*a)));
		}
		else {
			double r = (double) (-b- Math.sqrt((long) d))/((long) 2*a);
			double s = (double) (-b+ Math.sqrt((long) d))/((long) 2*a);
			System.out.println(2);
			if (a < 0) {
				System.out.println(s);
				System.out.println(r);
			}
			else {
				System.out.println(r);
				System.out.println(s);
			}
		}
	}

}
