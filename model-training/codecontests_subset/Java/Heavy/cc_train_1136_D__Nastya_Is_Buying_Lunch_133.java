import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D1136 {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new FileReader("F:/books/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int[] q = new int[n];
		String[] qs = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			q[i] = Integer.parseInt(qs[i]);
		}
		Map<Integer,List<Integer>> mp = new HashMap<Integer,List<Integer>>();
		for(int i=0;i<m;i++) {
			String[] ms = br.readLine().split(" ");
			int u = Integer.parseInt(ms[0]);
			int v = Integer.parseInt(ms[1]);
			insertToMap(mp,u,v);
		}
		if(n==1) {
			System.out.println("0");
			return;
		}
		int cnt = 0;
		for(int i=n-2;i>=0;i--) {
			if(path(i,n-1-cnt,q,mp))
				cnt++;
		}
		System.out.println(cnt);
	}

	private static boolean path(int x, int y, int[] q,
			Map<Integer, List<Integer>> mp) {
		List<Integer> l = mp.get(q[x]);
		if(l==null) return false;
		for(int i=x+1;i<=y;i++) {
			if(Collections.binarySearch(l, q[i])<0) return false;
		}
		int tmp = q[x];
		for(int i=x;i<y;i++) q[i] = q[i+1];
		q[y] = tmp;
		return true;
	}

	private static void insertToList(List<Integer> l, int v) {
		int pos = Collections.binarySearch(l, v);
		l.add(-pos-1,v);
	}

	private static void insertToMap(Map<Integer, List<Integer>> mp,
			int u, int v) {
		List<Integer> l = mp.get(u);
		if(l==null) {
			l = new ArrayList<Integer>();
			mp.put(u, l);
		}
		insertToList(l,v);
	}

}
