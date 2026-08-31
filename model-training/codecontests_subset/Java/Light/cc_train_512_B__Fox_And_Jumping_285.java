import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

public class b290 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] jumps = new int[n];
		int[] costs = new int[n];

//		Random r = new Random();
		for (int i = 0; i < n; i++) {
			jumps[i] = in.nextInt();
//			jumps[i] = r.nextInt(99999999)+1;
		}

		for (int i = 0; i < n; i++) {
			costs[i] = in.nextInt();
//			costs[i] = 5;
		}

		HashMap<Integer, Integer> gcdCost = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			HashMap<Integer, Integer> next = new HashMap<Integer, Integer>();
			next.put(jumps[i], costs[i]);
			for (Entry<Integer, Integer> from : gcdCost.entrySet()) {
				if (!next.containsKey(from.getKey()) || next.get(from.getKey()) > from.getValue()) {
					next.put(from.getKey(), from.getValue());
				}

				int gcd = gcd(jumps[i], from.getKey());
				int cost = costs[i] + from.getValue();
				if (!next.containsKey(gcd) || next.get(gcd) > cost) {
					next.put(gcd, cost);
				}
			}

			gcdCost = next;
		}
		
		if (gcdCost.containsKey(1))
			System.out.println(gcdCost.get(1));
		else
			System.out.println(-1);
	}

	private static int gcd(int a, int b) {
		while (b > 0) {
			int t = a % b;
			a = b;
			b = t;
		}
		return a;
	}
}
