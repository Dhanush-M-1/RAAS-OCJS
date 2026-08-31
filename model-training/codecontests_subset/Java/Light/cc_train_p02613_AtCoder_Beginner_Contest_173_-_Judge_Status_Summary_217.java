import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int ac = 0;
		int wa = 0;
		int tle = 0;
		int re = 0;

		for(int i = 0;i<=a;i++) {
			String b = sc.nextLine();
			if(b.equals("AC")) {
				ac++;
			}
			if(b.equals("WA")) {
				wa++;
			}
			if(b.equals("TLE")) {
				tle++;
			}
			if(b.equals("RE")) {
				re++;
			}
		}
		System.out.println("AC x "+ac);
		System.out.println("WA x "+wa);
		System.out.println("TLE x "+tle);
		System.out.println("RE x "+re);

	}

}
