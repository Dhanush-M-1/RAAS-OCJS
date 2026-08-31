import java.util.Scanner;


public class ProblemB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int cc = 0;
		for (int A = 0; A <= a; A += 2) {
			for (int B = 0; B <= b; B++) {
				int buy = A/2 + B;
				if (n - buy >= 0 && ((n - buy) % 2 == 0)  && (c >= (n - buy) / 2)) {
					cc++;
				}
			}
		}
		System.out.println(cc);
	}

}
