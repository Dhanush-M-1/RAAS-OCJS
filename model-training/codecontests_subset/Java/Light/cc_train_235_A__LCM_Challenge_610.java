import java.util.*;

public class lcmchallenge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long bayus = 0;
		if (n == 1) {
			bayus = 1;
		}
		else if (n == 2) {
			bayus = 2;
		}
//		else if (n == 763116) {
//			bayus = (long) 444394078546562430;
//		}
		else {
			if (n % 2 == 1) {
				bayus = (long) n * (long) (n - 1) * (long) (n - 2);
			}
			else {
				long maxlcm = 0;
				long srikar = (long) (n - 1) * (long) (n - 2) * (long) (n - 3);
				if (srikar > maxlcm) {
					maxlcm = (long) srikar;
				}
				for (int i = n; i > n - 1; i--) {
					for (int j = n - 1; j >= n - 2; j --) {
						for (int k = n - 2; k >= n - 3; k--) {
							long suhas = (long) GCD(k, i) * (long) GCD (k, j) * (long) GCD (j, i);
							long lcm = (long) i * (long) j * (long) k / (long) suhas;
							if ((long) lcm > (long) maxlcm) {
								maxlcm = (long) lcm;
							}

						}

					}
				}
				bayus = (long) maxlcm;
			}
		}
		System.out.println(bayus);
	}

	private static long GCD(long a, long b) {
		if (a > b) {
			return (GCD(a - b, b));
		}
		else if (a < b) {
			return (GCD(a, b - a));
		}
		else {
			return a;
		}
	}

}
