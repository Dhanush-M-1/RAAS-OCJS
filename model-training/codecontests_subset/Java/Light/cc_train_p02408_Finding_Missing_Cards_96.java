import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {

		int n;

		Scanner stdIn = new Scanner(System.in);
		List<String> cards = new ArrayList<>();

		n = stdIn.nextInt();

		for(int i = 0; i <= n; i++) {
			cards.add(stdIn.nextLine());
		}

		for(int i = 1; i < 14; i++) {
			if(!(cards.contains("S " + i))) {
				System.out.println("S " + i);
			}
		}
		for(int i = 1; i < 14; i++) {
			if(!(cards.contains("H " + i))) {
				System.out.println("H " + i);
			}
		}
		for(int i = 1; i < 14; i++) {
			if(!(cards.contains("C " + i))) {
				System.out.println("C " + i);
			}
		}
		for(int i = 1; i < 14; i++) {
			if(!(cards.contains("D " + i))) {
				System.out.println("D " + i);
			}
		}
	}
}