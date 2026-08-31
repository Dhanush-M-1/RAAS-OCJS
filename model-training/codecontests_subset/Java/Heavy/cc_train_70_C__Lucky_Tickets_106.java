import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(System.out);
	
	static class Fraction implements Comparable<Fraction> {
		int n, d;
		public Fraction (int _n, int _d) {
			n = _n;
			d = _d;
		}
		@Override
		public boolean equals(Object f) {
			return (long)n*((Fraction)f).d == (long)d*((Fraction)f).n;
		}
		@Override
		public int hashCode () {
			return n/d + d/n;
		}
		public int compareTo(Fraction f) {
			long q = (long)n*f.d - (long)d*f.n;
			return q > 0L ? 1 : q < 0L ? -1 : 0;
		}
		public String toString() {
			return n + "/" + d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		int mx = Integer.parseInt(st.nextToken());
		int my = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int x = 1000000, y = 1000000;
		
		int cx;
		int cy = 1;
		
		Map<Fraction, Integer> c1 = new HashMap<Fraction, Integer>();
		Map<Fraction, Integer> c2 = new HashMap<Fraction, Integer>();
		
		Fraction f;
		
		for (int i = 1; i <= mx; i++) {
			f = new Fraction(i, rev(i));
			c1.put(f, 1 + c1.getOrDefault(f, 0));
		}
		f = new Fraction(1,1);
		c2.put(f, 1);
		
		int nTickets = c1.get(f);
		
		table:for (cx = mx; cx > 0; cx--) {
			while (nTickets < w) {
				cy++;
				if (cy > my)
					break table;
				f = new Fraction(rev(cy), cy);
				nTickets += c1.getOrDefault(f, 0);
				c2.put(f, 1 + c2.getOrDefault(f, 0));
			}
			if ((long)cx*cy < (long)x*y) {
				x = cx;
				y = cy;
			}
			f = new Fraction(cx, rev(cx));
			nTickets -= c2.getOrDefault(f, 0);
			c1.put(f, c1.get(f) - 1);
		}
		if (x == 1000000) {
			pw.print("-1\n");
		}
		else {
			pw.printf("%d %d\n", x, y);
		}
		pw.close();
	}

	private static int rev(int i) {
		int res = 0;
		while (i > 0) {
			res *= 10;
			res += i%10;
			i /= 10;
		}
		return res;
	}
}
