public class Main {

	private static boolean match(int[] pattern, int[] s, int pos) {
		int sp = 0;
		int cr = 0;
		for (int i = pos; i < s.length; ++i) {
			cr += s[i];
			if (pattern[sp] < cr)
				break ;
			if (pattern[sp] == cr) {
				++sp; cr = 0;
				if (sp == pattern.length)
					return true;
			}
		}
		return false;
	}
	
	private static int match(int[] pattern, int[] s) {
		for (int i = 0; i < s.length; ++i) {
			if (match(pattern, s, i))
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
			for (;;) {
				final int[] w = new int[sc.nextInt()];
				if (w.length == 0) break ;
				for (int i = 0; i < w.length; ++i) {
					w[i] = sc.next().length();
				}
				System.out.println(match(new int[]{5, 7, 5, 7, 7}, w) + 1);
			}
		}
	}

}