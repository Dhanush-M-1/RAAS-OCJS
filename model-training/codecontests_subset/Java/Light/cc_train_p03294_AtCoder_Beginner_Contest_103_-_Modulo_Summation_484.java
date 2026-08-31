import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		int total = 0;
		for (int i = 0; i < n; i++) {
			total += Integer.parseInt(sc.next()) - 1;
		}

		System.out.println(total);

	}

}
