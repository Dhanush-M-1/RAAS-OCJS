import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] s = new String[n];
		int ac = 0;
		int wa = 0;
		int tle = 0;
		int re = 0;
		for(int i = 0; i < n; i++) {
			s[i] = sc.next();
			if(s[i].equals("AC"))ac++;
			else if(s[i].equals("WA"))wa++;
			else if(s[i].equals("TLE"))tle++;
			else if(s[i].equals("RE"))re++;
		}
		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.println("RE x " + re);
	}
}