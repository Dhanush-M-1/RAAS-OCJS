import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int AC = 0;
		int WA = 0;
		int TLE = 0;
		int RE = 0;
		String c[] = new String[N];

		for(int i = 0; i < N; i++) {
			c[i] = sc.next();
			if(c[i].equals("AC")) {
				AC++;
			}else if(c[i].equals("WA")) {
				WA++;
			}else if(c[i].equals("TLE")) {
				TLE++;
			}else if(c[i].equals("RE")) {
				RE++;
			}
		}
		System.out.println("AC x " + AC);
		System.out.println("WA x " + WA);
		System.out.println("TLE x " + TLE);
		System.out.println("RE x " + RE);

	}

}