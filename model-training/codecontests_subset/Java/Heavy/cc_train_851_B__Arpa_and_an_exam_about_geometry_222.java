import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solutions {

	public static PrintWriter writer;

	public static final int NMAX = 200001;
	public static final double EPS = 1E-6;

	public static long dist2(long x1, long y1, long x2, long y2) {
		return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out);

		String[] s = reader.readLine().split(" ");
		long[] x = new long[3];
		long[] y = new long[3];
		for (int i = 0; i < 3; i++) {
			x[i] = Long.parseLong(s[i * 2]);
			y[i] = Long.parseLong(s[i *2 + 1]);
		}
		
		long d1 = dist2(x[0], y[0], x[1], y[1]);
		long d2 = dist2(x[2], y[2], x[1], y[1]);
		//writer.println(d1 + " " + d2);
		//writer.println((x[0] - x[1])*(y[2] - y[1]));
		//writer.println((x[2] - x[1])*(y[0] - y[1]));
		if(d1 == d2) {
			if((x[0] - x[1])*(y[2] - y[1]) != (x[2] - x[1])*(y[0] - y[1])) {
				writer.println("Yes");
			}else {
				writer.println("No");
			}
		}else {
			writer.println("No");
		}
		
		
		reader.close();
		writer.close();
	}

}
