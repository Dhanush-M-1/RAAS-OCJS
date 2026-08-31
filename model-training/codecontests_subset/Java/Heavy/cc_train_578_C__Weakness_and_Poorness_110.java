import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) {
	InputStream inputStream = System.in;
	OutputStream outputStream = System.out;
	InputReader in = new InputReader(inputStream);
	PrintWriter out = new PrintWriter(outputStream);
	Solver solver = new Solver();
	solver.solve(in, out);
	out.close();
    }

    static class Solver {
	public double kadane(double[] a) {
	    double prev = -1;
	    double curr = a[0];
	    double best = curr;
		    
	    for (int i = 1; i < a.length; i++) {
		prev = curr;
		curr = Math.max(prev+a[i], a[i]);
		best = Math.max(best, curr);
	    }
		
	    return best;
	}
	
	public double weakness(int[] a, double x) {
	    double[] pa = new double[a.length];
	    double[] na = new double[a.length];

	    for (int i = 0; i < a.length; i++) {
		pa[i] = (double)a[i] - x;
		na[i] = -1 * ((double)a[i] - x);
	    }

	    return Math.max(kadane(pa), kadane(na));
	}

	public double ternary(int[] a, double min, double max) {
	    double low = min;
	    double high = max;
	    
	    //while (Math.abs(weakness(a, high) - weakness(a, low)) > 0.000_000_1) {
	    for (int i = 0; i < 100; i++) {
		double interval = (high - low) / 3;
		double left = low + interval;
		double right = low + (interval * 2);

		double lweakness = weakness(a, left);
		double rweakness = weakness(a, right);
		
		if (rweakness > lweakness) high = right;
		else low = left;
	    }

	    return weakness(a, low);
	}
	
	public void solve(InputReader in, PrintWriter out) {
	    int N = in.nextInt();
	    int[] a = new int[N];

	    for (int i = 0; i < N; i++) a[i] = in.nextInt();

	    out.println(ternary(a, -10_100, 10_100));
	}
    }

    static class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
	    reader = new BufferedReader(new InputStreamReader(stream), 32768);
	    tokenizer = null;
	}

	public String next() {
	    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
		try {
		    tokenizer = new StringTokenizer(reader.readLine());
		} catch (IOException e) {
		    throw new RuntimeException(e);
		}
	    }
	    return tokenizer.nextToken();
	}

	public int nextInt() {
	    return Integer.parseInt(next());
	}

    }
}
