import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		 int N = scan.nextInt();
		String S ;
		int AC=0;
		int WA=0;
		int TLE=0;
		int RE=0;

		for(int i=0; i<N; i++) {
			S= scan.next();
			if(S.equals("AC")) {
				AC++;
			}else if(S.equals("WA")) {
				WA++;
			}else if(S.equals("TLE")) {
				TLE++;
			}else {
				RE++;
			}
 
		}
		System.out.println("AC x "+AC);
		System.out.println("WA x "+WA);
		System.out.println("TLE x "+TLE);
		System.out.println("RE x "+RE);
	}

}
