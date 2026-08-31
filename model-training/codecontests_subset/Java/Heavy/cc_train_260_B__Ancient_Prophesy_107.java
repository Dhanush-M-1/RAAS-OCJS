import java.io.*;
import java.math.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

//codeforces
public class MainCodeforces1 {
	private static MyScanner in;
	private static PrintStream out;

	public static void main(String[] args) throws IOException {
		// helpers for input/output
		boolean LOCAL_TEST = false;
		// LOCAL_TEST = true;// comment it before submitting
		out = System.out;
		if (LOCAL_TEST) {
			in = new MyScanner("E:\\zin2.txt");
		}
		else {
			boolean usingFileForIO = false;
			if (usingFileForIO) {
				// using input.txt and output.txt as I/O
				in = new MyScanner("input.txt");
				out = new PrintStream("output.txt");
			}
			else {
				in = new MyScanner();
				out = System.out;
			}
		}

		solve();
	}

	private static void solve() throws IOException
	{
		HashMap<String, Integer> dict = new HashMap<>();
		String s = in.nextString();
		int nmax = 0;
		for (int i = 0; i < s.length(); i++) {
			String sub = s.substring(i, Math.min(i + 10, s.length()));
			if (IsValid(sub))
			{
				if (!dict.containsKey(sub)) {
					dict.put(sub, 1);
				}
				else {
					dict.put(sub, dict.get(sub) + 1);
				}
				nmax = Math.max(nmax, dict.get(sub));
			}
		}
		for (String key : dict.keySet()) {
			if (dict.get(key) == nmax)
			{
				out.println(key);
				return;
			}
		}
	}

	private static boolean IsValid(String sub) {
		Date dt1 = new Date(2013 - 1900, 1 - 1, 1);
		Date dt2 = new Date(2015 - 1900, 12 - 1, 31);
		try
		{
			if (sub.charAt(2) != '-' || sub.charAt(5) != '-')
				throw new Exception();
			int d = Integer.valueOf(sub.substring(0, 2));
			int m = Integer.valueOf(sub.substring(3, 5));
			int y = Integer.valueOf(sub.substring(6, 10));
			if (d < 1 || m < 1 || y < 1)
				throw new Exception();
			Date dt = new Date(y - 1900, m - 1, d);
			if (IsDateValid(y, m, d) && !dt.after(dt2) && !dt.before(dt1))
				return true;
		} catch (Exception e)
		{
		}
		return false;
	}

	public static boolean IsDateValid(int y, int m, int d)
	{
		if (y < 0 || m < 0 || d < 0)
			return false;
		int[] ndays = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (d <= ndays[m - 1])
			return true;
		if (y % 4 == 0 && m == 2 && d == 29)
			return true;
		return false;
	}

	// =====================================
	static class MyScanner {
		Scanner inp = null;

		public MyScanner() throws IOException
		{
			inp = new Scanner(System.in);
		}

		public MyScanner(String inputFile) throws IOException {
			inp = new Scanner(new FileInputStream(inputFile));
		}

		public int nextInt() throws IOException {
			return inp.nextInt();
		}

		public long nextLong() throws IOException {
			return inp.nextLong();
		}

		public double nextDouble() throws IOException {
			return inp.nextDouble();
		}

		public String nextString() throws IOException {
			return inp.next();
		}

	}

}
