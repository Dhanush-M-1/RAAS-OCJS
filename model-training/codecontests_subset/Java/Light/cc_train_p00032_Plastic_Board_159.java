import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String st;
		int a, b, c;
		int rectangle, diamond;

		rectangle = 0;
		diamond = 0;
		while (sc.hasNext()) {
			a = 0;
			b = 0;
			c = 0;
			st = sc.nextLine();
			for (int i = 0; i < st.length(); i++) {
				a *= 10;
				a += st.charAt(i) - '0';
				if (st.charAt(i + 1) == ',') {
					for (int j = i + 2; j < st.length(); j++) {
						b *= 10;
						b += st.charAt(j) - '0';
						if (st.charAt(j + 1) == ',') {
							for (int k = j + 2; k < st.length(); k++) {
								c *= 10;
								c += st.charAt(k) - '0';
							}
							break;
						}
					}
					break;
				}
			}
			if (a * a + b * b == c * c) {
				rectangle++;
			} else if (a == b) {
				diamond++;
			}
		}
		System.out.println(rectangle);
		System.out.println(diamond);
	}
}