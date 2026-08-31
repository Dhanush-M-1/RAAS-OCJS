import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.next());
		int AC = 0;
		int WA = 0;
		int TLE = 0;
		int RE = 0;
		for (int n = 0;n < N ;n++ ) {
			String S = scan.next();
			switch (S) {
				case "AC":
					AC++;
					break;
				case "WA":
					WA++;
					break;
				case "TLE":
					TLE++;
					break;
				case "RE":
					RE++;
					break;
			}
		}
		scan.close();
		System.out.printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d\n",AC,WA,TLE,RE);
	}

}
