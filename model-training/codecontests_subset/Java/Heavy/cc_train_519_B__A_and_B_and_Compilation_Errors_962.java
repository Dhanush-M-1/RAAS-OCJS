import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B {

	public static void main(String[] args) throws IOException {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(in.readLine());
			List<Integer> fst = getSorted(in.readLine(), n);
			List<Integer> snd = getSorted(in.readLine(), n - 1);
			List<Integer> trd = getSorted(in.readLine(), n - 2);

			int two = find(trd, snd, n - 2);
			int one = find(snd, fst, n - 1);

			System.out.println(one);
			System.out.println(two);
		}
	}

	private static List<Integer> getSorted(String st, int n) {
		StringTokenizer data = new StringTokenizer(st);
		List<Integer> res = new ArrayList<>();

		while (data.hasMoreTokens()) {
			res.add(Integer.parseInt(data.nextToken()));
		}
		Collections.sort(res);
		return res;
	}

	private static int find(List<Integer> fst, List<Integer> snd, int n) {
		int res = -1;

		for (int i = 0; i < n; i++) {
			if (!fst.get(i).equals(snd.get(i))) {
				res = snd.get(i);
				break;
			}
		}

		if (res < 0) {
			res = snd.get(n);
		}
		return res;
	}
}