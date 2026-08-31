import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static int base = 1000003;
	
	public static void main(String[] argv)throws IOException {
		
		StringBuilder sb = new StringBuilder();
		InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        int n = in.nextInt();
        double[] arr = new double[n];
        double min = 10000;
        double max = -10000;
        for (int i=0; i<n; i++) {
        	arr[i] = (double) in.nextInt();
        	min = Math.min(arr[i], min);
        	max = Math.max(arr[i], max);
        }
        double d = ternarySearch(arr, min, max);
        System.out.println(String.format("%.15f", poorness(arr, d)));
	}
	
	public static double poorness(double[] arr, double d) {
		double last = 0;
		double min = 0;
		double max = 0;
		double result = 0;
		for (int i=0; i<arr.length; i++) {
			double num = arr[i]-d;
			last += num;
			result = Math.max(result, Math.abs(last-min));
			result = Math.max(result, Math.abs(last-max));
			min = Math.min(min, last);
			max = Math.max(max, last);
		}
		return result;
	}
	
	public static double ternarySearch(double[] arr, double l, double r) {
		for (int i=0; i<100; i++) {
			double m1 = l + (r-l)/3;
			double m2 = r - (r-l)/3;
			double p1 = poorness(arr, m1), p2 = poorness(arr, m2);
			if (p1 < p2) r = m2;
			else l = m1;
		}
		return l;
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
        
        public long nextLong() {
        	return Long.parseLong(next());
        }

	}
}
