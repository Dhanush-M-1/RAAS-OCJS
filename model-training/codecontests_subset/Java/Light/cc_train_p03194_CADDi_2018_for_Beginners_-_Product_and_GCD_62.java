import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long p = sc.nextLong();

		long ini = p;

		Map<Long, Long> map = new HashMap<>();

		double rt = Math.sqrt(p);

		for (long i = 2; i <= rt; i++) {

			while (p % i == 0) {
				long now = map.getOrDefault(i, (long) 0);
				map.put(i, now + 1);
				p = p / i;
			}
		}

		long now = map.getOrDefault(p, (long) 0);
		map.put(p, now + 1);

		List<Long> list = new ArrayList<>();

		for (Long i : map.keySet()) {
			while (map.get(i) >= n) {
				list.add(i);
				map.put(i, map.get(i) - n);
			}
		}

		long ans = list.stream().mapToLong(Long::valueOf).reduce(1, (a, b) -> a * b);

		if (n == 1) {
			ans = ini;
		}

		System.out.println(ans);

		sc.close();
	}

}
