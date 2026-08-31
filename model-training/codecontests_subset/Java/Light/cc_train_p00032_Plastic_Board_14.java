import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int rectangular = 0;
		int dimond = 0;

		while(sc.hasNext()) {
			String[] numbers = sc.nextLine().split(",");

			int a = Integer.parseInt(numbers[0]);
			int b = Integer.parseInt(numbers[1]);
			int c = Integer.parseInt(numbers[2]);

			if(a * a + b * b == c * c) {
				rectangular++;
			}
			if(a == b) {
				dimond++;
			}
		}

		System.out.println(rectangular);
		System.out.println(dimond);

	}

}