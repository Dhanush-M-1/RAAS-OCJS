import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int N = Integer.parseInt(scan.nextLine());
	int ac = 0;
	int wa = 0;
	int tle = 0;
	int re = 0;

	for (int i = 0; i < N; i++) {
		String A = scan.nextLine();
		if (A.equals("AC")) {
			ac++;
		}else if (A.equals("WA")) {
			wa++;
		}else if (A.equals("TLE")) {
			tle++;
		}else {
			re++;
		}
	}

	System.out.println("AC x " + ac);
	System.out.println("WA x " + wa);
	System.out.println("TLE x " + tle);
	System.out.println("RE x " + re);

	}
}