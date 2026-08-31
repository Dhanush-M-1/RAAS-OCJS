import java.util.Scanner;

public class ProblemA {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();;
		String s = scan.next();
		scan.close();
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == '8') {
				cnt ++;
			}
		}
		int k = n / 11;
		if(k <= cnt) {
			System.out.println(k);
		}else if(k > cnt) {
			System.out.println(cnt);
		}
	}
}