import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int suuretsu[] = { 1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1,
					4, 1, 51 };
			int inputNumber = sc.nextInt();
			System.out.println(suuretsu[inputNumber-1]);
		} finally {
			sc.close();
		}
	}
}
