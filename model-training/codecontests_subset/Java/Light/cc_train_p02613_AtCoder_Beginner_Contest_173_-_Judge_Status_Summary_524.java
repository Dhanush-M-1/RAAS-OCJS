import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int c4 = 0;
		for (int i = 0; i < n; i++) {
			String s = kb.next();
			if (s.equals("AC")) {
				c1 += 1;
			} else if (s.equals("WA")) {
				c2 += 1;
			} else if (s.equals("TLE")) {
				c3 += 1;
			} else {
				c4 += 1;
			}
		}
		System.out.println("AC x " + c1 + "\nWA x " + c2 + "\nTLE x " + c3 + "\nRE x " + c4);
		kb.close();
	}

}
