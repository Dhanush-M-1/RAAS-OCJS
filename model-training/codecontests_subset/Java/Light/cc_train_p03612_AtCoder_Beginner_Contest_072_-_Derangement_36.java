
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			int[] p = new int[n];

			for (int i = 0; i < n; i++) {
				p[i] = sc.nextInt() - 1;
			}

			int count = 0;
//			while (!check(p)) {
//				for (int i = 0; i < p.length; i++) {
//					if (i == p[i]) {
//						if (i < p.length - 1) {
//							int tmp = p[i];
//							p[i] = p[i + 1];
//							p[i + 1] = tmp;
//							break;
//						} else {
//							int tmp = p[i];
//							p[i] = p[0];
//							p[0] = tmp;
//							break;
//						}
//					}
//				}
//				count++;
//			}

			boolean renzoku = false;
			for (int i = 0; i < p.length; i++) {
				if (i == p[i]) {
					if (!renzoku) {
						count++;
						renzoku = true;
					} else {
						renzoku = false;
					}
				} else {
					renzoku = false;
				}
			}

			System.out.println(count);
		}
	}

	private static boolean check(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i == arr[i]) {
				return false;
			}
		}

		return true;
	}
}
