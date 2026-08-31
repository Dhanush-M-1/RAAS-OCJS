import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.next());

		int[] c = new int[4];
		Arrays.fill(c, 0);

		for (int i = 0; i < n; i++) {
			switch (sc.next()) {
			case "AC":
				c[0]++;
				break;
			case "WA":
				c[1]++;
				break;
			case "TLE":
				c[2]++;
				break;
			case "RE":
				c[3]++;
				break;
			default:
				System.exit(1);
			}
		}
		
		System.out.println("AC x " + c[0]);
		System.out.println("WA x " + c[1]);
		System.out.println("TLE x " + c[2]);
		System.out.println("RE x " + c[3]);
	}

}
