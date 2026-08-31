import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int AC = 0;
		int WA = 0;
		int TLE = 0;
		int RE = 0;

		for(int i = 0; i < N ; i++) {
			String result = sc.nextLine();
			switch(result) {
			case "AC":
				AC ++;
				break;
			case "WA":
				WA ++;
				break;
			case "TLE":
				TLE ++;
				break;
			case "RE":
				RE ++;
				break;
			default:
				break;
			}
		}
		System.out.println("AC x " + AC);
		System.out.println("WA x " + WA);
		System.out.println("TLE x " + TLE);
		System.out.println("RE x " + RE);


	}
}