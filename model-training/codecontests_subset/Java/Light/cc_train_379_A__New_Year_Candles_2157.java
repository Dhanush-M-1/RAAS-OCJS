import java.io.BufferedReader;
import java.io.InputStreamReader;


public class NewYearCandles {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] parts = line.split(" ");
		
		int a, b;
		a = ti(parts[0]);
		b = ti(parts[1]);
		
		System.out.println(solve(a, b));
	}

	private static int solve(int a, int b) {
		int res = a;
		while (a >= b) {
			res += a/b;
			a = a/b + a%b;
		}
		return res;
	}

	private static int ti(String s) {
		return Integer.parseInt(s);
	}
}
