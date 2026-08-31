import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String keyence = "keyence";
		String[][] keyarr = new String[8][2];
		for(int i = 0;i < 8;i ++) {
			keyarr[i][0] = keyence.substring(0, i);
			keyarr[i][1] = keyence.substring(i, 7);
			if(s.startsWith(keyarr[i][0]) && s.endsWith(keyarr[i][1])) {
				System.out.println("YES");
				return;
			}
			/*if(i < 7) {
				if(s.indexOf(keyarr[i][0]) == 0 && 
						s.indexOf(keyarr[i][1]) == s.length() - keyarr[i][1].length()) {
					System.out.println("YES");
					return;
				}
			}else {
				if(s.indexOf(keyarr[i][0]) == 0) {
					System.out.println("YES");
					return;
				}
			}*/
		}
		System.out.println("NO");
	}
}