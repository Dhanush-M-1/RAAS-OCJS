import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = 0;
		int forIndex = Integer.parseInt(input.nextLine());
		for (int i = 0; i < forIndex; i++) {
			int number = Integer.parseInt(input.nextLine());
			int index = (int) Math.sqrt(number) + 1;
			for (; index > 1; index--) {
				if (number % index == 0 && index != number) {
					break;
				} else if (index == 2 || index == 1) {
					count++;
				}
			}
		}
		System.out.println(count);

	}

}

