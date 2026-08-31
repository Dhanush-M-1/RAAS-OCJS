import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 173_B
		Scanner sc = new Scanner(System.in);

		int c0=0,c1=0,c2=0,c3 = 0;
		int caseNo = sc.nextInt();

		for (int i=0; i<=caseNo; i++) {
			switch (sc.nextLine()) {
			case "AC":
				c0 += 1;
				break;
			case "WA":
				c1 += 1;
				break;
			case "TLE":
				c2 += 1;
				break;
			case "RE":
				c3 += 1;
				break;
			}
		}

		System.out.println("AC x " + c0);
		System.out.println("WA x " + c1);
		System.out.println("TLE x " + c2);
		System.out.println("RE x " + c3);

		// Scannerクラスのインスタンスをクローズ
		sc.close();
	}

}
