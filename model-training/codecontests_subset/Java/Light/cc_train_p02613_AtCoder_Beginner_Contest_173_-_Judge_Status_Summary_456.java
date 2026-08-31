import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner stdIn = new Scanner(System.in);
		int N = stdIn.nextInt();
		int[] S = new int[4];
		for(int i = 0; i < S.length; i ++) {
			S[i] = 0;
		}
		for(int i = 0; i < N; i ++) {
			switch(stdIn.next()) {
			case "AC":
				S[0] ++;
				break;
			case "WA":
				S[1] ++;
				break;
			case "TLE":
				S[2] ++;
				break;
			case "RE":
				S[3] ++;
				break;
			}
		}
		System.out.println("AC x " + S[0]);
		System.out.println("WA x " + S[1]);
		System.out.println("TLE x " + S[2]);
		System.out.println("RE x " + S[3]);
	}
}