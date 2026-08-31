import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String[] ss = sc.next().split(",");
			double[] X = new double[4];
			double[] Y = new double[4];
			for (int i = 0; i < 8; i += 2) {
				X[i / 2] = Double.parseDouble(ss[i]);
				Y[i / 2] = Double.parseDouble(ss[i + 1]);
			}
			System.out.println(solve(X, Y));
		}
	}

	String solve(double[] X, double[] Y) {
		boolean dirs[] = new boolean[4];
		for (int i = 0; i < 4; i++) {
			int j = (i + 1) % 4;
			int k = (i + 2) % 4;

			dirs[i] = cross(X[j] - X[i], Y[j] - Y[i], X[k] - X[i], Y[k] - Y[i]);
		}
		boolean yes = true;
		for (int i = 1; i < 4; i++)
			if (dirs[i - 1] != dirs[i])
				yes = false;
		return yes ? "YES" : "NO";
	}

	boolean cross(double x1, double y1, double x2, double y2) {
		return (x1 * y2 - x2 * y1) >= 0;
	}

}