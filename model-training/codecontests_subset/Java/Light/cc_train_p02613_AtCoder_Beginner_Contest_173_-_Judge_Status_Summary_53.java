import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[4];
		// AC:0 WA:1 TLE:2 RE:3
		String str;
		for(int i=0; i<n; i++) {
			str = sc.next();
			switch (str) {
			case "AC":
				s[0]++;
				break;
			case "WA":
				s[1]++;
				break;
			case "TLE":
				s[2]++;
				break;
			case "RE":
				s[3]++;
				break;
			}
				
		}

		System.out.println("AC x " + s[0]);
		System.out.println("WA x " + s[1]);
		System.out.println("TLE x " + s[2]);
		System.out.println("RE x " + s[3]);
	}

}
