import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

/**
 * Best Pizza
 * JOI 11th, Pre 3
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String[] words;

		int N, A, B, C;
		int[] D;

		N = parseInt(br.readLine());
		line = br.readLine();
		A = parseInt(line.substring(0, line.indexOf(' ')));
		B = parseInt(line.substring(line.indexOf(' ') + 1));
		C = parseInt(br.readLine());

		D = new int[N];
		for (int i = 0; i < N; i++) D[i] = parseInt(br.readLine());
		Arrays.sort(D);

		int max = 0, _C = C, j = 0;
		for (int i = N - 1; i >= 0; i--) {
			_C += D[i];
			j++;
			max = Math.max(max, _C / (A + j * B));
		}
		System.out.println(max);
	}
}