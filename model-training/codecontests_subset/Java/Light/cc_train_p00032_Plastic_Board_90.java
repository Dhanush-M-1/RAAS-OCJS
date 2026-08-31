import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		judgeSquare();
	}

	private static void judgeSquare() {
		int lect = 0;
		int diamond = 0;


			while (sc.hasNext()) {
				String[] str = sc.nextLine().split(",");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);
				int c = Integer.parseInt(str[2]);

					if ( c * c == a * a + b * b  ) {
						lect++;
					} else if ( a == b ) {
						diamond++;
					}
			}

		System.out.println(lect);
		System.out.println(diamond);

	}

}

