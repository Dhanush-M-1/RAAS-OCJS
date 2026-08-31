import java.util.*;

public class Main {
	Scanner sc = new Scanner(System.in);

	void doIt() {
		String key = "keyence"; 
		char keyset[] = key.toCharArray();
		final int LEN = 7;
		String s = sc.next();
		int slen = s.length();
		for(int i = 0; i < LEN; i++) {
			if(s.substring(0, LEN - i).concat(s.substring(slen - i, slen)).equals(key)){
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}


	public static void main(String[] args) {
		new Main().doIt();
	}
}
