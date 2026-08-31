import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class B670 {

	private static boolean home = !"true".equals(System.getProperty("ONLINE_JUDGE"));
	private static boolean debug = false;
	
	public static void main(String[] args) throws IOException {
		int nrTeste = 2;
		String[] inputs = {"2 2\n1 2\n", "4 5\n10 4 18 3\n"};
		String[] expected = {"1\n", "4\n"};
		for (int i = 0; home && i < nrTeste; i++) {
			System.out.print("\nExpect: " + expected[i] + "\n   Got: ");
			System.setIn(new ByteArrayInputStream(inputs[i].getBytes()));
			solve();
		}
		if (!home) {
			solve();
		}
		System.out.close();
	}
	
	public static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String[] line;
		line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		line = br.readLine().split(" ");
		int[] id = new int[n];
		int panala = 0;
		int prev = 0;
		for (int i = 0, j=1; i < n; i++, j++) {
			id[i] = Integer.parseInt(line[i]);
			panala += j;
			if (panala >= k) {
				pw.println(id[k-prev-1]);
				break;
			}
			prev = panala;
		}
		
		br.close();
		pw.flush();
	}
	
}
