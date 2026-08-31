import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		int a = 0;
		int w = 0;
		int t = 0;
		int r = 0;

		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		for (int i = 0; i<= N; i++) {
			String x = s.nextLine();
			if(x.equals("AC")) {
				a= a+ 1;
			}
			if(x.equals("WA")) {
				w= w+ 1;
			}
			if(x.equals("TLE")) {
				t= t+ 1;
			}
			if(x.equals("RE")) {
				r= r+ 1;
			}
		}
		System.out.println("AC x " + a);
		System.out.println("WA x " + w);
		System.out.println("TLE x " + t);
		System.out.println("RE x " + r);

	}
}