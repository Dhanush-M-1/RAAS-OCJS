import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String S[] = new String[N]; 
		int AC = 0;
		int WA = 0;
		int TLE = 0;
		int RE = 0;
		
		for(int i=0;i<N;i++) {
			S[i] = in.next();
			switch (S[i]) {
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
		
		System.out.println("AC x " + AC);
		System.out.println("WA x " + WA);
		System.out.println("TLE x " + TLE);
		System.out.println("RE x " + RE);
	}
}
