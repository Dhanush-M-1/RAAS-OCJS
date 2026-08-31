import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		char[] in = input.toCharArray();
		for (int n = 1; n < N; n++) {
			if (in[n - 1] > in[n]) {
				System.out.println("YES");
				System.out.println(n + " " + (n + 1));
				return;
			}
		}
		System.out.println("NO");

	}

}