import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int N = S.length();
		int cnt = 0;
		String str = "keyence";
		for(int i = 0; i < 7; i++) {
			if(S.substring(i, i + 1).equals(str.substring(i, i + 1))) {
				cnt++;
			} else {
				break;
			}
		}
		if(cnt == 7) {
			System.out.println("YES");
			return;
		}
		
		for(int i = 0; i < 7; i++) {
			if(S.substring(N - 1 - i, N - i).equals(str.substring(6 - i, 7 - i))) {
				cnt++;
				if(cnt == 7) break;
			} else {
				break;
			}
		}
		if(cnt == 7) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
