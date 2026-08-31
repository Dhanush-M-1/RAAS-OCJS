import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = Integer.parseInt(sc.nextLine());
		int acCon,tleCon,waCon,reCon;
		acCon = tleCon = waCon = reCon = 0;
		for (int i = 0; i < len; i++) {
			switch(sc.nextLine()) {
			case "AC":
				acCon++;
				break;
			case "TLE":
				tleCon++;
				break;
			case "WA":
				waCon++;
				break;
			case "RE":
				reCon++;
				break;
			}
		}

		System.out.println("AC x " + acCon);
		System.out.println("WA x " + waCon);
		System.out.println("TLE x " + tleCon);
		System.out.println("RE x " + reCon);

	}
}
