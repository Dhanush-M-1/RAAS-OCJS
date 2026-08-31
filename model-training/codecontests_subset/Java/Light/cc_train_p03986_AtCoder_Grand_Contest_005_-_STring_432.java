import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char[] chars = s.toCharArray();
		int cash = 0;
		int l = s.length();
		for(int i = 0; i < chars.length; i++) {
			if(chars[i]=='S') {
				cash++;
			} else {
				if(cash>0) {
					cash--;
					l-=2;
				}
			}
		}
		System.out.println(l);
	}
}
