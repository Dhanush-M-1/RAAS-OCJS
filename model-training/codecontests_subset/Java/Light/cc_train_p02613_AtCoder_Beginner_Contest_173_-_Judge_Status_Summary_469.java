

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String s ;
		int ac=0;
		int wa = 0;
		int tle=0;
		int re = 0;

		for(int i=0 ; i<n ; i++) {
			s = sc.next();
			if(s.compareTo("AC")==0) {
				ac++;
			}else if(s.compareTo("WA")==0) {
				wa++;
			}else if(s.compareTo("TLE")==0) {
				tle++;
			}else {
				re++;
			}
		}

		System.out.println("AC x "+ac);
		System.out.println("WA x "+wa);
		System.out.println("TLE x "+tle);
		System.out.println("RE x "+re);


		sc.close();

	}

}
