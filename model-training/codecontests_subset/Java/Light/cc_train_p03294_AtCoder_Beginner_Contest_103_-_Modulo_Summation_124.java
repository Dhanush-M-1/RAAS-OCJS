import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);) {

			int a = Integer.parseInt(sc.next());
			int all = 0;
			for (int i = 0; i < a; i++) {
				all += Integer.parseInt(sc.next());
			}
			System.out.println(all - a);
		}

	}

}
