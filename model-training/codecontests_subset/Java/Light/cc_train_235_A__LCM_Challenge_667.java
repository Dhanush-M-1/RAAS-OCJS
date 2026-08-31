/* CodeForces 236 C */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MaxNok {
	static boolean hascd(long a, long b) {
		if (a<b) return hascd (b,a);
		else if (b==0) return a>1;
		else return hascd(b, a%b);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(
				new InputStreamReader(System.in));
		String[] ss = bin.readLine().split(" ");
		int n = Integer.parseInt(ss[0]);
		bin.close();
		long maxNok = 0;
		if (n==1) maxNok = 1;
		else if (n==2) maxNok = 2;
		else if (n == 3) maxNok = 6;
		for (int m = n-2; m>=1 && m>n-20; m--) {
			for (long a=n; a>=m; a--) {
				for (long b=a-1; b>=m; b--) {
					if (!hascd(a,b)) {
						for (long c=b-1; c>=m; c--) {
							if (!hascd(c,a) && !hascd(c,b)) {
								//System.out.printf("a,b,c = %d %d %d\n", a, b, c);
								long mo = a*(b*c);
								//System.out.println("" + mo);
								if (mo > maxNok) {
									maxNok = mo;
									// System.out.printf("maxNok = %d\n", maxNok);
								}
							}
						}
						
					}
				}
			}
		}
		System.out.println("" + maxNok);
	}

}
