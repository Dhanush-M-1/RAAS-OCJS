import java.util.*;

public class Compiler {

	static HashMap<Integer, Integer> err = new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
	static int first;
	static int second;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			if (err.containsKey(k)) {
				err.put(k, err.get(k) + 1);
			} else {
				err.put(k, 1);
			}
		}

		for (int i = 0; i < n - 1; i++) {
			int k = sc.nextInt();
			if (err.containsKey(k)) {
				if (err.get(k) == 1) {
					err.remove(k);
					addToTemp(k);
				} else {
					err.put(k, err.get(k) - 1);
					addToTemp(k);
				}
			}
		}

		for (int k : err.keySet()) {
			System.out.println(k);
		}

		for (int i = 0; i < n - 2; i++) {
			int k = sc.nextInt();
			if (temp.containsKey(k)) {
				if (temp.get(k) == 1) {
					temp.remove(k);
				} else {
					temp.put(k, temp.get(k) - 1);
				}
			}
		}

		for (int k : temp.keySet()) {
			System.out.println(k);
		}
	}

	private static void addToTemp(int k) {
		if (temp.containsKey(k)) {
			temp.put(k, temp.get(k) + 1);
		} else {
			temp.put(k, 1);
		}
	}
}
