import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long p = sc.nextLong();
		sc.close();

		Map<Long, Integer> soinsu = bunkai(p);
		long ans = 1;
		for (Long l : soinsu.keySet()) {
			long v = soinsu.get(l) / n;
			for (int i = 0; i < v; i++) {
				ans *= l;
			}
		}
		System.out.println(ans);
	}

	static Map<Long, Integer> bunkai(long n) {
		Map<Long, Integer> soinsu = new HashMap<>();
		int end = (int) Math.sqrt(n);
		long d = 2;
		while (n > 1) {
			if (n % d == 0) {
				n /= d;
				if (soinsu.containsKey(d)) {
					soinsu.put(d, soinsu.get(d) + 1);
				} else {
					soinsu.put(d, 1);
				}
				end = (int) Math.sqrt(n);
			} else {
				if (d > end) {
					d = n - 1;
				}
				d++;
			}
		}
		return soinsu;
	}
}
