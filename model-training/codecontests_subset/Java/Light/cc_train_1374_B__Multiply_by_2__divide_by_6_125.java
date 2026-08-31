import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		for(int i = 0; i<t; i++) {
			int n = readInt();
			if(n==1) {
				System.out.println(0);
				continue;
			}
			if(n%3!=0) {
				System.out.println(-1);
				continue;
			}
			int num3 = 0, num2 = 0;
			while(n%3==0) {
				n/=3;
				num3++;
			}
			while(n%2==0) {
				n/=2;
				num2++;
			}
			if(n!=1 ||num2>num3) {
				System.out.println(-1);
			} else {
				System.out.println(2*num3-num2);
			}
			
		}
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
