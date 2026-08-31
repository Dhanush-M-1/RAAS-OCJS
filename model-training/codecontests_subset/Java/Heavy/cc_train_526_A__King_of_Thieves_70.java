import java.util.Scanner;

public class Zepto2015_A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int N = in.nextInt();

		char[] lines = in.next().toCharArray();

		for (int start = 0; start < N; start++) {

			// if(lines[start] == '.') {
			// break;
			// }

			outer: for (int stepLen = 1; stepLen < N; stepLen++) {

				for (int platCount = 0; platCount < 5; platCount++) {

					int ind = start + stepLen * platCount;

					if (ind >= N || lines[ind] == '.') {
						continue outer;
					}

				}

				System.out.println("yes");
				return;

			}

		}

		System.out.println("no");

	}
}
