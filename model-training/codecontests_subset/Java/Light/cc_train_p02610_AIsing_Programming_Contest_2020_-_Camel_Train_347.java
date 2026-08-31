import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		for (int x = 0; x < t; x++) {
			int n = Integer.parseInt(br.readLine());
			Obj[] arr = new Obj[n];
			for (int i = 0; i < n; i++) {
				String[] sa = br.readLine().split(" ");
				Obj o = new Obj();
				o.k = Integer.parseInt(sa[0]);
				o.l = Integer.parseInt(sa[1]);
				o.r = Integer.parseInt(sa[2]);
				o.d = Math.abs(o.l - o.r);
				arr[i] = o;
			}
			Arrays.sort(arr, (o1, o2) -> o1.k - o2.k);

			long ans = 0;
			Queue<Obj> fix = new ArrayDeque<>();
			PriorityQueue<Obj> ok = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
			Queue<Obj> ng = new ArrayDeque<>();
			int used = 0;
			for (int i = 0; i < n; i++) {
				Obj o = arr[i];
				if (o.l == o.r) {
					fix.add(o);
				} else if (o.l > o.r) {
					if (o.k > used) {
						ok.add(o);
						used++;
					} else {
						Obj f = ok.peek();
						if (o.d > f.d) {
							ng.add(ok.poll());
							ok.add(o);
						} else {
							ng.add(o);
						}
					}
				}
			}

			PriorityQueue<Obj> ok2 = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
			Queue<Obj> ng2 = new ArrayDeque<>();
			used = n;
			for (int i = n - 1; i >= 0; i--) {
				Obj o = arr[i];
				if (o.l < o.r) {
					if (o.k < used) {
						ok2.add(o);
						used--;
					} else {
						if (!ok2.isEmpty() && o.d > ok2.peek().d) {
							ng2.add(ok2.poll());
							ok2.add(o);
						} else {
							ng2.add(o);
						}
					}
				}
			}
			for (Obj o : fix) {
				ans += Math.max(o.l, o.r);
			}
			for (Obj o : ok) {
				ans += Math.max(o.l, o.r);
			}
			for (Obj o : ok2) {
				ans += Math.max(o.l, o.r);
			}
			for (Obj o : ng) {
				ans += Math.min(o.l, o.r);
			}
			for (Obj o : ng2) {
				ans += Math.min(o.l, o.r);
			}
			pw.println(ans);
		}
		br.close();
		pw.flush();
	}

	static class Obj {
		int k, l, r, d;
	}
}
