import java.util.*;
import java.io.*;

public class Exa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int h = 0, t = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] == 100) {
				h += 1;
			} else {
				t += 1;
			}
		}
		if (n == 1) {
			System.out.println("NO");
		} else if (h == 0 && t % 2 == 1) {
			System.out.println("NO");
		} else if (h % 2 == 1) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}

	public static Map<Character, Integer> makeMap(String s) {
		int l = s.length();
		Map<Character, Integer> map = new TreeMap<>();
		for (char ch : s.toCharArray()) {
			if (ch != ' ') map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
		}
		return map;
	}

	static class Pair {
		int first;
		int second;
		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}

