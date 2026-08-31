// upsolve with rainboy
import java.io.*;
import java.util.*;

public class CF920E {
	static Random rand = new Random();
	static class V {
		V l, r;
		int key;
		int x;
		V(int key) {
			this.key = key;
			x = rand.nextInt();
		}
	}
	static V v_, l_, r_;
	static V split(V u, int key) {
		V v;
		if (u == null) {
			v = null;
			l_ = null;
			r_ = null;
		} else if (u.key < key) {
			v = split(u.r, key);
			u.r = l_; l_ = u;
		} else if (u.key > key) {
			v = split(u.l, key);
			u.l = r_; r_ = u;
		} else {
			v = u;
			l_ = u.l;
			r_ = u.r;
			u.l = u.r = null;
		}
		return v;
	}
	static V merge(V l, V r) {
		if (l == null)
			return r;
		if (r == null)
			return l;
		if (l.x <= r.x) {
			l.r = merge(l.r, r);
			return l;
		} else {
			r.l = merge(l, r.l);
			return r;
		}
	}
	static V first(V u) {
		if (u != null)
			while (u.l != null)
				u = u.l;
		return u;
	}
	static void tr_add(int key) {
		V v = split(v_, key);
		if (v == null)
			v = new V(key);
		v_ = merge(merge(l_, v), r_);
	}
	static void tr_remove(int key) {
		split(v_, key);
		v_ = merge(l_, r_);
	}
	static V tr_higher(int key) {
		V v = split(v_, key);
		V w = first(r_);
		v_ = merge(merge(l_, v), r_);
		return w;
	}
	static ArrayList[] aa;
	static int dfs(int i) {
		ArrayList<Integer> a = aa[i];
		int m = a.size(), c = 1;
		for (int h = 0; h < m - 1; h++) {
			int p = a.get(h), q = a.get(h + 1);
			while (true) {
				V v = tr_higher(p);
				if (v == null || v.key >= q)
					break;
				tr_remove(v.key);
				c += dfs(v.key);
			}
		}
		return c;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		aa = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			aa[i] = new ArrayList<Integer>();
			aa[i].add(-1);
			aa[i].add(n);
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			aa[i].add(j);
			aa[j].add(i);
		}
		for (int i = 0; i < n; i++)
			Collections.sort(aa[i]);
		for (int i = 0; i < n; i++)
			tr_add(i);
		ArrayList<Integer> cc = new ArrayList<>();
		while (v_ != null) {
			V v = first(v_);
			int i = v.key;
			tr_remove(i);
			cc.add(dfs(i));
		}
		pw.println(cc.size());
		Collections.sort(cc);
		for (int c : cc)
			pw.print(c + " ");
		pw.println();
		pw.close();
	}
}
