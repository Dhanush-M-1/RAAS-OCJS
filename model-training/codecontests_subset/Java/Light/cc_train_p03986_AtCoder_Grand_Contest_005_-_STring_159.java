import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char[] X = sc.next().toCharArray();
		StringBuffer buf = new StringBuffer();

		//int count = 0;

		for (int i = 0; i < X.length; i++) {
			if (X[i] == 'T' && buf.length() != 0) {
				if (buf.charAt(buf.length() - 1) == 'S') {
					buf.deleteCharAt(buf.length() -1);

					continue;
				}
			}


			buf.append(X[i]);



		}

		System.out.println(buf.length());

		sc.close();
	}
}
