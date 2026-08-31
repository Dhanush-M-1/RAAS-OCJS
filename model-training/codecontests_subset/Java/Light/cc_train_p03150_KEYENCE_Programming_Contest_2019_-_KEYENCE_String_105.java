import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Solver solver = new Solver();
		solver.init();
		solver.readHead(in.readLine());
		// for (; solver.hasNext();) {
		// solver.readBody(in.readLine());
		// }
		// solver.solve();
	}
}

class Solver {
	int N;
	int cnt;

	public void init() {
		N = 0;
		cnt = 0;
	}

	public void readHead(String str) {
		String[] strArr = str.split(" ");
		// N = Integer.parseInt(strArr[0]);
		// System.out.println(N);

		boolean ans = false;

		ans = ans || str.matches("k.*eyence");
		ans = ans || str.matches("ke.*yence");
		ans = ans || str.matches("key.*ence");
		ans = ans || str.matches("keye.*nce");
		ans = ans || str.matches("keyen.*ce");
		ans = ans || str.matches("keyenc.*e");

		if (ans)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public boolean hasNext() {
		return cnt < N;
	}

	public void readBody(String str) {
		// System.out.println(str);
		cnt++;
	}

	public void solve() {

	}
}
