import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = 0, ans = 0;
		while (sc.hasNext()) {
			String s = sc.nextLine();
			if (s.charAt(0)=='+') {
				k++;
			}
			else {
				if (s.charAt(0)=='-') {
					k--;
				}
				else {
					ans += k*(s.length()-1-s.indexOf(':'));
				}
			}
		}
		System.out.println(ans);
	}

}
