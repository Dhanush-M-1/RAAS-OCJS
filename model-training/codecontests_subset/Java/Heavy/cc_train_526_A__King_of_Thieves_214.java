import java.util.Scanner;

public class JavaApplication2 {

	static char[] level;

	public static boolean check(int start, int step) {
		int count = 0;
		for (int i = start; i < level.length; i += step) {
			if (level[i] == '.') {
				return false;
			} else {
				count++;
				if (count == 5) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		level = in.next().toCharArray();
		for (int step = 1; step <= level.length / 4.0; step++) {
			int maxStart = level.length - step * 4;
			for (int start = 0; start <= maxStart; start++) {
				if (check(start, step)) {
					System.out.print("yes");
					return;

				}
			}
		}
		System.out.print("no");
	}

}