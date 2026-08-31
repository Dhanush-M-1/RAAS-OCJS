import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class D {

	static double pow(double a, double b) {
		return Math.pow(a, b);
	}

	static double log(double a) {
		return Math.log(a);
	}

	static String[] ans = new String[] { "x^y^z", "x^z^y", "(x^y)^z", "(x^z)^y", "y^x^z", "y^z^x", "(y^x)^z", "(y^z)^x",
			"z^x^y", "z^y^x", "(z^x)^y", "(z^y)^x" };

	public static int solve(double x, double y, double z) {
		double[] v = new double[12];
		Arrays.fill(v, Double.MAX_VALUE);
		if (x <= 1 && y <= 1 && z <= 1) {
			v[0] = pow(x, pow(y, z));
			v[1] = pow(x, pow(z, y));
			v[2] = pow(x, y * z);
			v[3] = pow(x, y * z);
			v[4] = pow(y, pow(z, x));
			v[5] = pow(y, pow(x, z));
			v[6] = pow(y, x * z);
			v[7] = pow(y, x * z);
			v[8] = pow(z, pow(x, y));
			v[9] = pow(z, pow(y, x));
			v[10] = pow(z, x * y);
			v[11] = pow(z, x * y);
		} else {
			v[0] = z * log(y) + log(log(x));
			v[1] = y * log(z) + log(log(x));
			v[2] = log(y * z * log(x));
			v[3] = log(y * z * log(x));
			v[4] = z * log(x) + log(log(y));
			v[5] = x * log(z) + log(log(y));
			v[6] = log(x * z * log(y));
			v[7] = log(x * z * log(y));
			v[8] = y * log(x) + log(log(z));
			v[9] = x * log(y) + log(log(z));
			v[10] = log(x * y * log(z));
			v[11] = log(x * y * log(z));
		}
		double max = -Double.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < v.length; i++)
			if (max < v[i]) {
				max = v[i];
				index = i;
			}
		return index;
	}

	public static void main(String[] args) throws IOException {
		File inputFile = new File("entradaD");
		if (inputFile.exists())
			System.setIn(new FileInputStream(inputFile));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringBuilder out = new StringBuilder();
		while ((line = in.readLine()) != null) {
			double[] v = readDoubles(line);
			out.append(ans[solve(v[0], v[1], v[2])] + "\n");
		}
		System.out.print(out);
	}

	public static long[] readLongs(String line) {
		String[] w = line.trim().split("\\s+");
		long[] a = new long[w.length];
		for (int i = 0; i < a.length; i++)
			a[i] = Long.parseLong(w[i]);
		return a;
	}

	public static int[] readInts(String line) {
		String[] w = line.trim().split("\\s+");
		int[] a = new int[w.length];
		for (int i = 0; i < a.length; i++)
			a[i] = Integer.parseInt(w[i]);
		return a;
	}

	public static double[] readDoubles(String line) {
		String[] w = line.trim().split("\\s+");
		double[] a = new double[w.length];
		for (int i = 0; i < a.length; i++)
			a[i] = Double.parseDouble(w[i]);
		return a;
	}
}
