import java.util.Scanner;

public class p348a_mafia {
	
	public static boolean enough(int[] a, long rounds) {
		long supervisors = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > rounds) {
				return false;
			}
			supervisors += rounds - a[i];
		}
		if (supervisors >= rounds) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		long left = 0, right = 2000000000L;
		while (left < right) {
			long middle = (left + right) / 2;
			if (enough(a, middle)) {
				right = middle;
			} else {
				left = middle + 1;
			}
		}
		System.out.println(right);
		
		in.close();
	}

}
