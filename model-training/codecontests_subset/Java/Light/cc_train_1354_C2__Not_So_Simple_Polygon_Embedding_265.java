import java.util.*;
import java.io.*;
public class c2 {
	static final FS sc = new FS();
	static final PrintWriter pw = new PrintWriter(System.out);
	
	static int n;
	public static void main(String[] args) {
		int t = sc.nextInt();
		for(int tt = 1; tt <= t; ++tt) {
			n = sc.nextInt() * 2;
			
			double ang = Math.PI * 2 / n / 2;
			
			double h = .5 / Math.tan(ang);
			
			double r = Math.sqrt(h * h + .5 * .5);
			
			double x = r * 2;
			
			double addAng = (Math.PI * 2 / n) * (n / 4);
			
			// now rotate polygon by some amount
			double lo = 0, hi = Math.PI * 2 / n / 2;
			for(int xx = 0; xx < 100; ++xx) {
				double g = (lo + hi) / 2;
				
				// get hor
				double hor = Math.cos(g) * x;
				// get ver
				double ver = Math.sin(g + addAng) * x;
				
				if(hor > ver) lo = g;
				else hi = g;
			}
			
			double out = Math.cos(lo) * x;
			
			System.out.printf("%.9f\n", out);
		}
		pw.flush();
	}
	static class FS {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String next() {
			while(!st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(Exception e) {}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}