import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	final Set<Integer> A;
	final Map<Integer, Integer> map;

	public Main(int n, Set<Integer> a) {
		A = a;
		map = new HashMap<>(n);
	}

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int n = s.nextInt();
			final int M = s.nextInt();
			Set<Integer> a = IntStream.generate(s::nextInt).limit(M).boxed().collect(Collectors.toSet());

			Main target = new Main(n, a);
			System.out.println(target.move(n));
		}
	}

	int move(int x) {
		if(x == 0) {
			return 1;
		}

		if(A.contains(x)) {
			return 0;
		}

		if(x == 1) {
			return 1;
		}

		if(map.containsKey(x)) {
			return map.get(x);
		} else {
			int v = (move(x - 1) + move(x - 2)) % 1000000007;
			map.put(x, v);
			return v;
		}
	}
}
