
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		String s ;
		int ac=0;
		int wa=0;
		int tle=0;
		int re =0;

		for(int i=0; i<n; i++) {

			s = scan.next();

			if(s.equals("AC")) {
				ac++;
			}else if(s.equals("WA")) {
				wa++;
			}else if(s.equals("TLE")) {
				tle++;
			}else {
				re++;
			}

		}
		System.out.println("AC x "+ac);
		System.out.println("WA x "+wa);
		System.out.println("TLE x "+tle);
		System.out.println("RE x "+re);



		}

	}

