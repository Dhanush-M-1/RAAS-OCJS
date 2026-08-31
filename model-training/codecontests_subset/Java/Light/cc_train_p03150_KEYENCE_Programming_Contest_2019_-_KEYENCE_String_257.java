import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String ans = "NO";
		outer:
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if ("keyence".equals(s.substring(0, i) +
						s.substring(j))) {
					ans = "YES";
					break outer;
				}
			}
		}

		System.out.println(ans);
		sc.close();
	}

}
