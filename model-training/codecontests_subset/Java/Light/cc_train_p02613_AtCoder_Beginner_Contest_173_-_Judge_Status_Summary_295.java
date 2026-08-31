import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int acCnt = 0;
		int waCnt = 0;
		int tleCnt = 0;
		int reCnt = 0;

		for (int i = 0; i < N; i++) {
			String status = sc.next();
			switch (status) {
			case "AC":
				acCnt++;
				break;
			case "WA":
				waCnt++;
				break;
			case "TLE":
				tleCnt++;
				break;
			case "RE":
				reCnt++;
				break;
			}

		}
		System.out.println("AC x "+acCnt);
		System.out.println("WA x "+waCnt);
		System.out.println("TLE x "+tleCnt);
		System.out.println("RE x "+reCnt);

	}
}