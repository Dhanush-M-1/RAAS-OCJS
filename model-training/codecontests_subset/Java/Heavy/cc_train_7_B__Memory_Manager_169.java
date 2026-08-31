import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Main()).start();
	}

	public void run() {
		Locale.setDefault(Locale.US);
		try {
			run1();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	int nextInt(StreamTokenizer st) throws IOException {
		st.nextToken();
		return (int) st.nval;
	}

	double nextDouble(StreamTokenizer st) throws IOException {
		st.nextToken();
		return st.nval;
	}

	String nextLine(StreamTokenizer st) throws IOException {
		st.nextToken();
		return st.sval;
	}

	public void run1() throws IOException {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		// Scanner sc = new Scanner(new File("input.txt"));
		int tn = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[m];
		int[] ne = new int[m + 1];
		for (int i = 0; i < m; i++)
			ne[i] = m - i;
		int cur = 1;
		for (int t = 0; t < tn; t++) {
			String s = sc.next();
			if (s.equals("alloc")) {
				int req = sc.nextInt();
				int u = 0;
				while (u < m && ne[u] < req)
					u++;
				if (u == m) {
					System.out.println("NULL");
				} else {
					for (int i = 0; i < req; i++) {
						ne[u + i] = 0;
						arr[u + i] = cur;
					}
					System.out.println(cur);
					cur++;
				}
			} else if (s.equals("erase")) {
				boolean ok = false;
				int req = sc.nextInt();
				if (req != 0)
					for (int i = m - 1; i >= 0; i--)
						if (arr[i] == req) {
							ok = true;
							arr[i] = 0;
							ne[i] = ne[i + 1] + 1;
						}
				if (!ok) {
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
				}
			} else {
				int h = 0;
				for (int i = 0; i < m; i++)
					if (arr[i] != 0)
						arr[h++] = arr[i];
				while (h < m) {
					arr[h] = 0;
					h++;
				}
				Arrays.fill(ne, 0);
				for (int i = m - 1; i >= 0; i--)
					if (arr[i] == 0) {
						ne[i] = ne[i + 1] + 1;
					}
			}
		}
	}
}