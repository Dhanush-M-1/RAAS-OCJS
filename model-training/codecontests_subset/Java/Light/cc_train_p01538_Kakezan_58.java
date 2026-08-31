import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

/**
 * Kakezan
 */
public class Main {

	public static int MAX = 7;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;


		while ((line = br.readLine()) != null && !line.isEmpty()) {

			int Q = parseInt(line);

			for (int i = 0; i < Q; i++) {

				int N = parseInt(br.readLine());
				int c = 0;

				while (N >= 10) {
					// split
					int _N = 0;
					for (int j = 1; j <= MAX; j++) {
						if (Math.pow(10, j) > N) continue;
						int l = (int) (N / Math.pow(10, j));
						int r = (int) (N % Math.pow(10, j));
						_N = Math.max(_N, l * r);
					}
					//
					if (N == _N) {
						c = -1;
						break;
					}
					c++;
					N = _N;
				}
				System.out.println(c);
			}
		} //end while
	} //end main
}