
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		int ans = s.length();
		int n = ans;
		
		int slen = 0;
		
		for(int i = 0 ; i < n ; i++) {
			if(s.charAt(i) == 'S') {
				slen++;
			}
			else {
				if(slen > 0) {
					ans -= 2;
					slen--;
				}
			}
		}
		System.out.println(ans);
	}
}
