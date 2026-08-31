import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		sc.close();
		int l = S.length();

		if(l == 7) {
			if(S.equals("keyence")) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			System.exit(0);
		}
		List<String> list = new ArrayList<String>();
		int k = l - 7;
		String[]s = new String[l];
		for(int i = 0; i < l; i++) {
			s[i] = S.substring(i, i + 1);
		}
		for(int i = 0; i < l - k; i++) {
			int a = i;
			int b = k + i;
			String t = "";
			for(int j = 0; j < l; j++) {
				if(j < a || j >= b) {
					t += s[j];
				}
			}
			if(t.equals("keyence")) {
				System.out.println("YES");
				System.exit(0);
			}
		}
		System.out.println("NO");
	}
}