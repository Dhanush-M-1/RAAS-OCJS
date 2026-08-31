import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] res = new int[4];
		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			if (tmp.equals("AC")) {
				res[0]++;
			} else if (tmp.equals("WA")) {
				res[1]++;
			} else if (tmp.equals("TLE")) {
				res[2]++;
			} else if (tmp.equals("RE")) {
				res[3]++;
			}

		}
		System.out.println("AC x " + res[0]);
		System.out.println("WA x " + res[1]);
		System.out.println("TLE x " + res[2]);
		System.out.println("RE x " + res[3]);

	}
}