import java.util.Scanner;

public class Main {
	public static void main(String[] args){

		int ac = 0;
		int wa = 0;
		int tle = 0;
		int re = 0;

		try (Scanner scanner = new Scanner(System.in)) {

			int num = scanner.nextInt();

			for (int i = 0; i < num; i++) {

				String s = scanner.next();

				switch (s) {

				case "AC":
					ac++;
					break;

				case "WA":
					wa++;
					break;

				case "TLE":
					tle++;
					break;

				case "RE":
					re++;
					break;

				}
			}

			System.out.println("AC x " + ac + "\nWA x " + wa + "\nTLE x " + tle + "\nRE x " + re);
		}
	}
}