import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		char[] X = sc.next().toCharArray();
		int S = 0;
		int ans = 0;
		for (char c : X) {
			if (c == 'S') {
				++S;
			} else {
				if (S > 0) {
					--S;
				} else {
					++ans;
				}
			}
		}
		System.out.println(ans + S);
	}

}
