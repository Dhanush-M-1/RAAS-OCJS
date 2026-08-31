import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		boolean flag = false;
		for(int i = 0; i < S.length(); i++) {
			for(int j = i; j <= S.length(); j++) {
				StringBuilder sb = new StringBuilder(S);
				if(sb.delete(i, j).toString().equals("keyence")) {
					flag = true;
				}
			}
		}
		if(flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
