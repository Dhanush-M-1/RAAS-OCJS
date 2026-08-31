// practice with rainboy
import java.io.*;
import java.util.*;

public class CF621D extends PrintWriter {
	CF621D() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF621D o = new CF621D(); o.main(); o.flush();
	}

	String[] ss = { "x^y^z", "x^z^y", "(x^y)^z", "(x^z)^y", "y^x^z", "y^z^x",
		"(y^x)^z", "(y^z)^x", "z^x^y", "z^y^x", "(z^x)^y", "(z^y)^x" };
	int[] sign = new int[12];
	double[] aa = new double[12];
	void power(int i, double x, double y, double z) {
		if (x == 1) {
			sign[i] = 0;
		} else if (x > 1) {
			sign[i] = 1;
			aa[i] = z * Math.log(y) + Math.log(Math.log(x));
		} else {
			sign[i] = -1;
			aa[i] = z * Math.log(y) + Math.log(-Math.log(x));
		}
	}
	void power(int i, double x, double yz) {
		if (x == 1) {
			sign[i] = 0;
		} else if (x > 1) {
			sign[i] = 1;
			aa[i] = Math.log(yz) + Math.log(Math.log(x));
		} else {
			sign[i] = -1;
			aa[i] = Math.log(yz) + Math.log(-Math.log(x));
		}
	}
	void main() {
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		double z = sc.nextDouble();
		power(0, x, y, z);
		power(1, x, z, y);
		power(2, x, y * z);
		power(3, x, y * z);
		power(4, y, x, z);
		power(5, y, z, x);
		power(6, y, x * z);
		power(7, y, x * z);
		power(8, z, x, y);
		power(9, z, y, x);
		power(10, z, x * y);
		power(11, z, x * y);
		Integer[] ii = new Integer[12];
		for (int i = 0; i < 12; i++)
			ii[i] = i;
		Arrays.sort(ii, (i, j) -> {
			if (sign[i] != sign[j])
				return sign[j] - sign[i];
			if (sign[i] == 0)
				return i - j;
			return aa[i] == aa[j] ? i - j : aa[i] > aa[j] ? -sign[i] : sign[i];
		});
		println(ss[ii[0]]);
	}
}
