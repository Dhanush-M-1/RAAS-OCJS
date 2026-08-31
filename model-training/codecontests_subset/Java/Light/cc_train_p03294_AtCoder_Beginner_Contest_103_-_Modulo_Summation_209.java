import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		long answer = 0;
		for (int i = 0; i < N; i++) {
			answer+=input.nextLong();
		}
		System.out.println(answer-N);
	}
}