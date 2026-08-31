

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		long n = scan.nextInt();
		long ac = 0;
		long wa = 0;
		long tle = 0;
		long re = 0;
		for (int i = 0; i < n; i++) {
			String st = scan.next();
			switch (st) {
			case "AC":
				ac++;
				break;
			case "WA":
				wa++;
				break;
			case "TLE":
				tle++;
				break;
			default:
				re++;

			}
		}

		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.println("RE x " + re);
	}

}
