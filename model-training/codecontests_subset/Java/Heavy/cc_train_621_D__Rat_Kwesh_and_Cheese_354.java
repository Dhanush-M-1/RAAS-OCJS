import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

	static class FastScanner {
		BufferedReader s;
		StringTokenizer st;

		public FastScanner(InputStream InputStream) {
			st = new StringTokenizer("");
			s = new BufferedReader(new InputStreamReader(InputStream));
		}

		public FastScanner(File f) throws FileNotFoundException {
			st = new StringTokenizer("");
			s = new BufferedReader(new FileReader(f));
		}

		public int nextInt() throws IOException {
			if (st.hasMoreTokens())
				return Integer.parseInt(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return nextInt();
			}
		}

		public BigInteger big() throws IOException {
			if (st.hasMoreTokens())
				return new BigInteger(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return big();
			}
		}

		public double nextDouble() throws IOException {
			if (st.hasMoreTokens())
				return Double.parseDouble(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return nextDouble();
			}
		}

		public long nextLong() throws IOException {
			if (st.hasMoreTokens())
				return Long.parseLong(st.nextToken());
			else {
				st = new StringTokenizer(s.readLine());
				return nextLong();
			}
		}

		public String next() throws IOException {
			if (st.hasMoreTokens())
				return st.nextToken();
			else {
				st = new StringTokenizer(s.readLine());
				return next();
			}

		}

		public String nextLine() throws IOException {
			return s.readLine();
		}

		public void close() throws IOException {
			s.close();
		}

	}

	public static void main(String[] args) throws java.lang.Exception {
		FastScanner in = new FastScanner(System.in);
		double x = in.nextDouble(), y = in.nextDouble(), z = in.nextDouble();
		if(x > 1 && y > 1 && z > 1) {
			String ans = "x^y^z";
			double val = fun1(x, y, z);
			double com = fun1(x, z, y);
			if(val < com) {
				val = com;
				ans = "x^z^y";
			}
			com = fun2(x, y, z);
			if(val < com) {
				val = com;
				ans = "(x^y)^z";
			}
			com = fun2(x, z, y);
			if(val < com) {
				val = com;
				ans = "(x^z)^y";
			}
			com = fun1(y, x, z);
			if(val < com) {
				val = com;
				ans = "y^x^z";
			}
			com = fun1(y, z, x);
			if(val < com) {
				val = com;
				ans = "y^z^x";
			}
			com = fun2(y, x, z);
			if(val < com) {
				val = com;
				ans = "(y^x)^z";
			}
			com = fun2(y, z, x);
			if(val < com) {
				val = com;
				ans = "(y^z)^x";
			}
			com = fun1(z, x, y);
			if(val < com) {
				val = com;
				ans = "z^x^y";
			}
			com = fun1(z, y, x);
			if(val < com) {
				val = com;
				ans = "z^y^x";
			}
			com = fun2(z, x, y);
			if(val < com) {
				val = com;
				ans = "(z^x)^y";
			}
			com = fun2(z, y, x);
			if(val < com) {
				val = com;
				ans = "(z^y)^x";
			}
			System.out.println(ans);
		}
		else if(x <= 1 && y > 1 && z > 1) {
			double val = fun1(y, x, z);
			String ans = "y^x^z";
			double com = fun1(y, z, x);
			if(val < com) {
				val = com;
				ans = "y^z^x";
			}
			com = fun2(y, x, z);
			if(val < com) {
				val = com;
				ans = "(y^x)^z";
			}
			com = fun2(y, z, x);
			if(val < com) {
				val = com;
				ans = "(y^z)^x";
			}
			com = fun1(z, x, y);
			if(val < com) {
				val = com;
				ans = "z^x^y";
			}
			com = fun1(z, y, x);
			if(val < com) {
				val = com;
				ans = "z^y^x";
			}
			com = fun2(z, x, y);
			if(val < com) {
				val = com;
				ans = "(z^x)^y";
			}
			com = fun2(z, y, x);
			if(val < com) {
				val = com;
				ans = "(z^y)^x";
			}
			System.out.println(ans);
		}
		else if(y <= 1 && x > 1 && z > 1) {
			String ans = "x^y^z";
			double val = fun1(x, y, z);
			double com = fun1(x, z, y);
			if(val < com) {
				val = com;
				ans = "x^z^y";
			}
			com = fun2(x, y, z);
			if(val < com) {
				val = com;
				ans = "(x^y)^z";
			}
			com = fun2(x, z, y);
			if(val < com) {
				val = com;
				ans = "(x^z)^y";
			}
			com = fun1(z, x, y);
			if(val < com) {
				val = com;
				ans = "z^x^y";
			}
			com = fun2(z, x, y);
			if(val < com) {
				val = com;
				ans = "(z^x)^y";
			}
			com = fun2(z, y, x);
			if(val < com) {
				val = com;
				ans = "(z^y)^x";
			}
			System.out.println(ans);
		}
		else if(z <= 1 && x > 1 && y > 1) {
			String ans = "x^y^z";
			double val = fun1(x, y, z);
			double com = fun2(x, y, z);
			if(val < com) {
				val = com;
				ans = "(x^y)^z";
			}
			com = fun2(x, z, y);
			if(val < com) {
				val = com;
				ans = "(x^z)^y";
			}
			com = fun1(y, x, z);
			if(val < com) {
				val = com;
				ans = "y^x^z";
			}
			com = fun1(z, y, x);
			if(val < com) {
				val = com;
				ans = "z^y^x";
			}
			com = fun2(y, x, z);
			if(val < com) {
				val = com;
				ans = "(y^x)^z";
			}
			com = fun2(y, z, x);
			if(val < com) {
				val = com;
				ans = "(y^z)^x";
			}
			System.out.println(ans);
		}
		else if(x <= 1 && y <= 1 && z > 1) {
			double val = fun1(z, x, y);
			String ans = "z^x^y";
			double com = fun1(z, y, x);
			if(val < com) {
				val = com;
				ans = "z^y^x";
			}
			com = fun2(z, x, y);
			if(val < com) {
				val = com;
				ans = "(z^x)^y";
			}
			com = fun2(z, y, x);
			if(val < com) {
				val = com;
				ans = "(z^y)^x";
			}
			System.out.println(ans);
		}
		else if(y <= 1 && z <= 1 && x > 1) {
			String ans = "x^y^z";
			double val = fun1(x, y, z);
			double com = fun1(x, z, y);
			if(val < com) {
				val = com;
				ans = "x^z^y";
			}
			com = fun2(x, y, z);
			if(val < com) {
				val = com;
				ans = "(x^y)^z";
			}
			com = fun2(x, z, y);
			if(val < com) {
				val = com;
				ans = "(x^z)^y";
			}
			System.out.println(ans);
		}
		else if(z <= 1 && x <= 1 && y > 1) {
			double val = fun1(y, x, z);
			String ans = "y^x^z";
			double com = fun1(y, z, x);
			if(val < com) {
				val = com;
				ans = "y^z^x";
			}
			com = fun2(y, x, z);
			if(val < com) {
				val = com;
				ans = "(y^x)^z";
			}
			com = fun2(y, z, x);
			if(val < com) {
				val = com;
				ans = "(y^z)^x";
			}
			System.out.println(ans);
		}
		else {
			double x1 = 1/x;
			double y1 = 1/y;
			double z1 = 1/z;
			String ans = "x^y^z";
			double val = fun1(x1, y, z);
			double com = fun1(x1, z, y);
			if(val > com) {
				val = com;
				ans = "x^z^y";
			}
			com = fun2(x1, y, z);
			if(val > com) {
				val = com;
				ans = "(x^y)^z";
			}
			com = fun2(x1, z, y);
			if(val > com) {
				val = com;
				ans = "(x^z)^y";
			}
			com = fun1(y1, x, z);
			if(val > com) {
				val = com;
				ans = "y^x^z";
			}
			com = fun1(y1, z, x);
			if(val > com) {
				val = com;
				ans = "y^z^x";
			}
			com = fun2(y1, x, z);
			if(val > com) {
				val = com;
				ans = "(y^x)^z";
			}
			com = fun2(y1, z, x);
			if(val > com) {
				val = com;
				ans = "(y^z)^x";
			}
			com = fun1(z1, x, y);
			if(val > com) {
				val = com;
				ans = "z^x^y";
			}
			com = fun1(z1, y, x);
			if(val > com) {
				val = com;
				ans = "z^y^x";
			}
			com = fun2(z1, x, y);
			if(val > com) {
				val = com;
				ans = "(z^x)^y";
			}
			com = fun2(z1, y, x);
			if(val > com) {
				val = com;
				ans = "(z^y)^x";
			}
			System.out.println(ans);
		}
	}
	
	private static double fun1(double x, double y, double z) {
		return Math.log(Math.log(x)) + z*Math.log(y);
	}
	private static double fun2(double x, double y, double z) {
		return Math.log(z * y *Math.log(x));
	}
}
