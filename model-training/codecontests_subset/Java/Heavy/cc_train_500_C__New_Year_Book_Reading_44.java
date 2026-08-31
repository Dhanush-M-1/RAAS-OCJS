import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class gb_C {

	static int MB = 1 << 20;
	static BufferedReader br = new BufferedReader( new InputStreamReader( System.in, StandardCharsets.US_ASCII ), 20*MB );
	static StringTokenizer st;
	
	public static void NL() throws Exception {
		st = new StringTokenizer(br.readLine());
	}

	public static String NT() {
		return st.nextToken();
	}

	public static void main(String[] args) throws Exception {
		NL();
		int n = Integer.parseInt(NT()); // books
		int m = Integer.parseInt(NT()); // days
		
		NL();
		// w - 1-based
		long[] w = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			w[i] = Integer.parseInt(NT());
		}
		
		NL();
		int[] b = new int[m]; // book order
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(NT());
		} 
		System.out.println(solve(n, m, w, b));
		
	}

	static long solve(int n, int m, long[] w, int[] b) {
//		long res = 0;
		LinkedList<Integer> stack = new LinkedList<>();
		for (int bi = b.length - 1; bi >= 0; --bi) {
			add(stack, b[bi]);
		}
		return simulate(n, m, w, b, toArray(stack));
	}

	private static void add(LinkedList<Integer> stack, int e) {
		Iterator<Integer> iter = stack.iterator();
		while (iter.hasNext()) {
			Integer val = iter.next();
			if (val == e) {
				iter.remove();
				break;
			}
		}
		stack.addFirst(e);
	}

	private static int[] toArray(LinkedList<Integer> stack) {
		int[] res = new int[stack.size()];
		int i = 0;
		for (int se : stack) {
			res[i++] = se;
		}
		return res;
	}

	static long simulate(int n, int m, long[] w, int[] b, int[] ord) {
		LinkedList<Integer> stack = new LinkedList<>();
		for (int be : ord) {
			stack.add(be);
		}
		long res = 0;
		for (int be : b) {
			res += findAndPutOnTop(be, w, stack);
		}
		return res;
	}

	static long findAndPutOnTop(int b, long[] w, LinkedList<Integer> stack) {
		Iterator<Integer> iter = stack.iterator();
		long ws = 0;
		while (true) {
			Integer act = iter.next();
			if (act == b) {
				iter.remove();
				stack.addFirst(b);
				return ws;
			} else {
				ws += w[act];
			}
		}
	}

}
