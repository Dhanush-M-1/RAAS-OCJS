import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();
		long P = sc.nextLong();
		long num = 1;
		long n = 1;

		if(N==1) {
            System.out.println(P);
            return;
        }

		for (long i = 1; n <= P; i++) {

			if (P%n == 0) {
				num = i;
			}
			n = (long) Math.pow(i+1, N);
		}
		System.out.println(num);
	}
}
