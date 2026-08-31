import java.util.*;
import java.io.PrintWriter;
import static java.lang.Integer.*;
import static java.lang.Long.*;
import static java.lang.Math.*;
import static java.lang.System.*;

public class Main {
	public static void main(String[] args) {
		int i,j;
		Scanner sc = new Scanner(in);
		int n = parseInt(sc.next());
		int m = parseInt(sc.next());
		long[] a = new long[n];
		long[] b = new long[n];
		for (i = 0; i < n; i++) {
			a[i] = parseLong(sc.next());
			b[i] = parseLong(sc.next());
		}
		long[] c = new long[m];
		long[] d = new long[m];
		for (i = 0; i < m; i++) {
			c[i] = parseLong(sc.next());
			d[i] = parseLong(sc.next());
		}
		sc.close();
		int[] xy = new int[n];
		for (i = 0; i < n; i++) {
			long mn = 400000000L;
			for (j = 0; j < m; j++) {
				long ma = abs(a[i]-c[j])+abs(b[i]-d[j]);
				if(ma<mn) {
					mn = ma;
					xy[i]=j+1;
				}
			}
		}
		PrintWriter pw = new PrintWriter(out);
		for(i=0;i<n;i++) {
			pw.println(xy[i]);
		}
		pw.flush();
	}
}
