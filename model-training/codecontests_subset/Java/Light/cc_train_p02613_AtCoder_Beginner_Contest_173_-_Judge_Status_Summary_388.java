import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		int n =scan.nextInt();
		int a = 0, b = 0, c = 0, d = 0;
		for(int i = 0; i < n; i++) {
			String s = scan.next();
			if(s.equals("AC")) {
				a++;
			}else if(s.equals("WA")) {
				b++;
			}else if(s.equals("TLE")) {
				c++;
			}else {
				d++;
			}
		}
		System.out.println("AC x "+ a);
		System.out.println("WA x "+ b);
		System.out.println("TLE x "+ c);
		System.out.println("RE x "+ d);
	}

}
