import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;
import java.text.*;

public class Main {
	public static ArrayList<Long> factorize(long n) {
		ArrayList<Long> factor = new ArrayList<>();

		for (long d = 1, i = 2; i * i <= n && factor.size() <= 3; i += d, d = 2)
			while (n % i == 0) {
				factor.add(i);
				n /= i;
			}

		if (n > 1)
			factor.add(n);

		return factor;

	}

	public static void main(String[] args) {
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Long> res = factorize(in.nextLong());
		if (res.size() <= 1)
			out.println(1 + "\n" + 0);
		else if (res.size() == 2)
			out.println(2);
		else
			out.println(1 + "\n" + res.get(0) * res.get(1));

		out.close();
	}

}

class FastReader {
	BufferedReader br;
	StringTokenizer st;

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));

	}

	public FastReader(File f) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(f));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return st.nextToken();

	}

	int nextInt() {

		return Integer.parseInt(next());
	}

	double nextDouble() {

		return Double.parseDouble(next());
	}

	long nextLong() {

		return Long.parseLong(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return str;

	}
}
