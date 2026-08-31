import java.util.*;
public class B {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = "0";
		int pos = 1, neg = 0, n, sum = 0;
		ArrayList<String> a = new ArrayList<String>();
		String[] input = in.nextLine().split(" ");
		for (int i = 0; i < input.length; ++i) {
			s = input[2 * i + 1];
			if (s.compareTo("-") == 0) ++neg;
			else if (s.compareTo("=") == 0) break;
			else ++pos;
			a.add(s);
		}
		n = Integer.parseInt(input[input.length - 1]);
		if (n < pos - n * neg || n > n * pos - neg) System.out.printf("Impossible\n");
		else {
			System.out.printf("Possible\n");
			for (int i = 0; i < a.size(); i++) {
				int sn = 1;
				if (i > 0 && a.get(i - 1).compareTo("-") == 0) sn = -1;
				if (sn == 1) --pos; else --neg;
				for (int j = 1; j <= n; ++j) if (sum + j * sn + pos - n * neg <= n && sum + j * sn + n * pos - neg >= n) {
					System.out.printf("%d %s ", j, a.get(i));
					sum += j * sn;
					break;
				}
			}
			System.out.printf("%d = %d\n", Math.abs(n - sum), n);
		}
		in.close();
	}
}
