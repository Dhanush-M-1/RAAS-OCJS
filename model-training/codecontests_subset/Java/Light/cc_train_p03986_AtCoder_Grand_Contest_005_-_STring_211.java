import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String X = in.next();
		int sCount = 0;
		int xCount = X.length();
		for (int i = 0; i < X.length(); i++) {
			char c = X.charAt(i);
			if (c == 'S') {
				sCount++;
			} else {
				int delete = sCount > 0 ? 1 : 0;
				sCount -= delete;
				xCount -= delete == 1 ? 2 : 0;
			}
		}
		System.out.println(xCount);
		in.close();
	}
}