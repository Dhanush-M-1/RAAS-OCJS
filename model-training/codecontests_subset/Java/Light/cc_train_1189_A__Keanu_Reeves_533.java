import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class problemstosolve {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		boolean found = false;
		int num = in.nextInt();
		in.nextLine();
		String input = in.nextLine();
		int ans = 1;
		ArrayList<StringBuilder> sbuilder = new ArrayList<>();
		StringBuilder ss1 = new StringBuilder();
		StringBuilder ss2 = new StringBuilder();
		if(isGood(input)) {
			System.out.println(ans);
			System.out.println(input);
		}
		else {
			for(int i=0;i<num-1;i++) {
				ss1.append(input.charAt(i));
				ss2.delete(0, ss2.length());
				ss2.append(input.substring(i+1));
				if(isGood(ss1.toString()) && isGood(ss2.toString())) {
					ans++;
					found = true;
					break;
				}
			}
			if(found) {
				System.out.println(ans);
				System.out.println(ss1.toString() + " " + ss2.toString());
			}
			else
				System.out.println("-1");
		}
	}
	static boolean isGood(String s) {
		boolean goods = true;
		int zeroes = 0,ones = 0;
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)=='0')
				zeroes++;
			else
				ones++;
		if(zeroes==ones)
			goods=false;
		return goods;
	}
}