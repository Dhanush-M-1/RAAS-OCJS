import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(System.out);
		FastScanner in = new FastScanner(System.in);
		
		int [] a= new int[2];
		int [] b= new int[2];
		int [] c= new int[2];
		for (int i = 0; i < 2; i++) {
			a[i]= in.nextInt();
		}
		for (int i = 0; i < 2; i++) {
			b[i]= in.nextInt();
		}
		for (int i = 0; i < 2; i++) {
			c[i]= in.nextInt();
		}
		
		long d1= dist(a[0],a[1], b[0], b[1]);
		long d2= dist(c[0],c[1], b[0], b[1]);
		//System.out.println(d1+" "+ d2);
		//System.out.println(cross(a,b,c));
		if(d1==d2&&cross(a,b,c)!=0){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}
		
	}
	public static long dist(int x1, int y1, int x2, int y2){
		long xx= (long) (x2-x1)*(x2-x1);
		long yy= (long) (y2-y1)*(y2-y1);
		return xx+yy;
	}
	public static long cross(int[] A, int[] B, int[] C){
        int [] AB = new int[2];
        int [] AC = new int[2];
        AB[0] = B[0]-A[0];
        AB[1] = B[1]-A[1];
        AC[0] = C[0]-A[0];
        AC[1] = C[1]-A[1];
        long cross = (long) AB[0] * AC[1] - (long) AB[1] * AC[0];
        return cross;
    }

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer("");
		}

		public String next() throws IOException {
			if (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
				return next();
			}
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
		public double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}
