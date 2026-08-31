import java.util.Scanner;

public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double sum = 0;
		int counter = 0;
		while (s.hasNextInt()) {
			sum += s.nextInt();
			counter++;
		}
		if (sum != 0 && sum % counter == 0) {
			System.out.println((int) (sum / counter));
		} else {
			System.out.println("-1");
		}
	}

}
