import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String l[] = bf.readLine().split(" ");
		LinkedList<Integer> pos = new LinkedList<Integer>();
		LinkedList<Integer> pos2 = new LinkedList<Integer>();
		LinkedList<Integer> neg = new LinkedList<Integer>();
		LinkedList<Integer> neg2 = new LinkedList<Integer>();
		String[] result = new String[l.length];
		for (int i = 0; i < l.length - 2; i += 2) {
			if (i != 0)
				result[i - 1] = l[i - 1];
			if (i == 0 || l[i - 1].charAt(0) == '+') {
				pos.add(i);
				pos2.add(i);
			} else {
				neg.add(i);
				neg2.add(i);
			}
		}
			while (!neg.isEmpty() && !pos.isEmpty()) {
				result[neg.removeFirst()] = 1 + "";
				result[pos.removeFirst()] = 1 + "";
			}
			int left = Integer.parseInt(l[l.length - 1]);
			int N = left;
			result[l.length - 1] = left + "";
			result[l.length - 2] = "=";
			while (!pos.isEmpty()) {
				if (pos.size() > 1) {
					result[pos.removeFirst()] = 1 + "";
					left--;
				} else {
					if (left <= 0) {
						result[pos.removeFirst()] = 1 + "";
						left--;
					} else {
						result[pos.removeFirst()] = left + "";
						left = 0;
					}
				}
			}
			while (!neg.isEmpty()) {
				result[neg.removeFirst()] = 1 + "";
				left++;
			}
			if (left < 0 && !fill(neg2, -left, result, N)) {
				System.out.println("Impossible");
				return;
			}
			if (left > 0 && !fill(pos2, left, result, N)) {
				System.out.println("Impossible");
				return;
			}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println("Possible");
		System.out.println(sb);
	}

	private static boolean fill(LinkedList<Integer> neg, int left,
			String[] result, int N) {
		int n;
		left = left;
		while (!neg.isEmpty()) {
			n = Integer.parseInt(result[neg.getFirst()]);
			int canAdd = N - n;
			canAdd = Math.min(left, canAdd);
			n += canAdd;
			left -= canAdd;
			result[neg.removeFirst()] = n + "";
			if (left == 0)
				return true;
		}
		return false;
	}
}