// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF20B extends PrintWriter {
	CF20B() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF20B o = new CF20B(); o.main(); o.flush();
	}

	void main() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if (a == 0) {
			if (b == 0)
				println(c == 0 ? -1 : 0);
			else {
				println(1);
				println((double) -c / b);
			}
			return;
		}
		long d = (long) b * b - 4L * a * c;
		if (d < 0) {
			println(0);
		} else if (d == 0) {
			println(1);
			println(-b / 2.0 / a);
		} else {
			double r = Math.sqrt(d);
			double x1 = (-b - r) / 2 / a;
			double x2 = (-b + r) / 2 / a;
			if (x1 > x2) {
				double tmp = x1; x1 = x2; x2 = tmp;
			}
			println(2);
			println(x1);
			println(x2);
		}
	}
}
