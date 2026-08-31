import java.io.*;
import java.util.*;

public class c1 {	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int m = in.nextInt();
		int w[] = new int[n + 1];
		int b[] = new int[m + 1];
		for (int i = 0; i < n; i++) {
			w[i] = in.nextInt();
		}
		boolean was[] = new boolean[n];
		Arrays.fill(was, false);
		ArrayDeque<Integer> st = new ArrayDeque<Integer>();
		for (int i = 0; i < m; i++) {
			b[i] = in.nextInt();
			b[i]--;
			if (!was[b[i]]){
				st.addLast(b[i]);
				was[b[i]] = true;
			}
		}
		for (int i = 0; i < m; i++) {
			if (!was[b[i]]){
				st.addLast(b[i]);
				was[b[i]] = true;
			}
		}
		long ans = 0;
		int st1[] = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int count = 0;
			while (st.getFirst() != b[i]){
				st1[count] = st.getFirst();
				st.remove(st.getFirst());
				count++;
				ans += w[st1[count - 1]];
			}
			st.remove(st.getFirst());
			for (int j = count - 1; j > -1; j--) {
				st.addFirst(st1[j]);
			}
			st.addFirst(b[i]);
		}
		out.print(ans);
		out.close();
	}
}
