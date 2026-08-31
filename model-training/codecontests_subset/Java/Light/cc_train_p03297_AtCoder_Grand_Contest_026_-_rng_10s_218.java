import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sa = br.readLine().split(" ");
		int t = Integer.parseInt(sa[0]);
		for (int i = 0; i < t; i++) {
			sa = br.readLine().split(" ");
			long a = Long.parseLong(sa[0]);
			long b = Long.parseLong(sa[1]);
			long c = Long.parseLong(sa[2]);
			long d = Long.parseLong(sa[3]);

			if (a < b || b > d) {
				System.out.println("No");
			} else {
				long e = BigInteger.valueOf(b).gcd(BigInteger.valueOf(d)).longValue();
				long g = a % b;
				long h = (c + 1 - g + e - 1) / e;
				long min = g + e * h;
				if (min < b) {
					System.out.println("No");
				} else {
					System.out.println("Yes");
				}
			}
		}
		br.close();
	}
}
