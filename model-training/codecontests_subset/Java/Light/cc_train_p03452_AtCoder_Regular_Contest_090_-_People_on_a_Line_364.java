
import java.util.Scanner;

public class Main {

	public static int[] uf;
	public static long[] dis;
	public static int[] dep;

	public static int Root(int n) {
		if(uf[n] == n)
			return n;
		else
			return Root(uf[n]);
	}

	public static long RootDis(int n) {
		if(uf[n] == n)
			return 0;
		else
			return dis[n] + RootDis(uf[n]);
	}

	public static boolean Add(int l, int r, long d) {
		boolean ret = true;
		int lroot = Root(l);
		int rroot = Root(r);
		long tmp1 = RootDis(l);
		long tmp2 = RootDis(r);
		if(lroot != rroot) {
			if(dep[lroot] > dep[rroot]) {
				dis[rroot] = -d + tmp1 - tmp2;
				uf[rroot] = lroot;
			} else if(dep[lroot] < dep[rroot]) {
				dis[lroot] = d - tmp1 + tmp2;
				uf[lroot] = rroot;
			} else {
				dis[rroot] = -d + tmp1 - tmp2;
				uf[rroot] = lroot;
				dep[lroot]++;
			}
		} else {
			ret = (tmp1 - tmp2) == d;
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		uf = new int[n];
		dis = new long[n];
		dep = new int[n];
		for(int i = 0; i < n; i++) {
			uf[i] = i;
			dis[i] = 0;
			dep[i] = 0;
		}
		boolean ans = true;
		for(int i = 0; i < m; i++) {
			ans = ans && Add(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextLong());
		}
		if(ans)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
