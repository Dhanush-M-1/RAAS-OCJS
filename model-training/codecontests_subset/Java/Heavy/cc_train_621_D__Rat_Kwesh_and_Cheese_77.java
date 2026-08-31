import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class D {

	static StringTokenizer st;
	static BufferedReader br;
	static PrintWriter pw;
	static class Number {
		double x, y, z;
		int t;
	}
	static int n;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		double x = nextDouble();
		double y = nextDouble();
		double z = nextDouble();
		Number[]a = new Number[13];
		for (int i = 1; i <= 12; i++) {
			a[i] = new Number();
		}
		String[]s = new String[13];
		go(x, y, z, a, 'x', 'y', 'z', s);
		go(y, x, z, a, 'y', 'x', 'z', s);
		go(z, x, y, a, 'z', 'x', 'y', s);
		int max_id = 1;
		for (int i = 2; i <= 12; i++) {
			double x1 = a[max_id].x;
			double y1 = a[max_id].y;
			double z1 = a[max_id].z;
			double x2 = a[i].x;
			double y2 = a[i].y;
			double z2 = a[i].z;
			if (a[max_id].t==1 && a[i].t==1) {
				if (Math.log(x2) > 0 && Math.log(x1) <= 0) {
					max_id = i;
				}
				else if (Math.log(x2) >= 0 && Math.log(x1) >= 0) {
					if (z2*Math.log(y2)+Math.log(Math.log(x2)) > z1*Math.log(y1)+Math.log(Math.log(x1)) + 1e-8)
						max_id = i;
				}
				else if (Math.log(x2) <= 0 && Math.log(x1) <= 0) {
					if (z2*Math.log(y2)+Math.log(-Math.log(x2))+1e-8 < z1*Math.log(y1)+Math.log(-Math.log(x1)))
						max_id = i;
				} 
			}
			else if (a[max_id].t==2 && a[i].t==2) {
				if (y2*z2*Math.log(x2) > y1*z1*Math.log(x1) + 1e-8)
					max_id = i;
			}
			else if (a[max_id].t==1 && a[i].t==2) {
				if (y2*z2*Math.log(x2) > Math.pow(y1, z1)*Math.log(x1) + 1e-8)
					max_id = i;
			}
			else {
				if (Math.pow(y2, z2)*Math.log(x2) > y1*z1*Math.log(x1) + 1e-10)
					max_id = i;
			}
		}
		System.out.println(s[max_id]);
		pw.close();
	}
	private static void go(double x, double y, double z, Number[] a, char xx, char yy, char zz, String[]s) {
		a[++n].x = x;
		a[n].y = y;
		a[n].z = z;
		a[n].t = 1;
		s[n] = xx+"^"+yy+"^"+zz;
		a[++n].x = x;
		a[n].y = z;
		a[n].z = y;
		a[n].t = 1;
		s[n] = xx+"^"+zz+"^"+yy;
		a[++n].x = x;
		a[n].y = y;
		a[n].z = z;
		a[n].t = 2;
		s[n] = "("+xx+"^"+yy+")"+"^"+zz;
		a[++n].x = x;
		a[n].y = z;
		a[n].z = y;
		a[n].t = 2;
		s[n] = "("+xx+"^"+zz+")"+"^"+yy;
	}
	private static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	private static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	private static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	private static String next() throws IOException {
		while (st==null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}
}
