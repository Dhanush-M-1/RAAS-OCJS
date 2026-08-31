import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Scanner sc1 = new Scanner(System.in);
		String s = sc1.next();
		String keyence = "keyence";

		String[] strSta = new String[6];
		String[] strEnd = new String[6];
		for ( int i = 0 ; i < 6 ; i++ ) {
			strSta[i] = keyence.substring(0,6-i);
			strEnd[i] = keyence.substring(6-i);
			//System.out.println(strSta[i]);
			//System.out.println(strEnd[i]);
		}

		if (s.startsWith(keyence)) {
			System.out.println("YES");
		}
		else if (s.endsWith(keyence)) {
			System.out.println("YES");
		}
		else {

			for (int j = 0 ; j < 6 ; j++ ) {

				if (s.startsWith(strSta[j]) && s.endsWith(strEnd[j])) {
					System.out.println("YES");
					break;
				}
				if ( j == 5) {
					System.out.println("NO");
					break;
				}
			}

		}

		sc1.close();

	}

}