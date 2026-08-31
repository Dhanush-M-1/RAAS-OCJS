import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		long n = sc.nextLong();
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += sc.nextLong() - 1;
		}
		System.out.println(sum);
	}
}
