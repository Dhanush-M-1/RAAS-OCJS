import java.util.*;
import static java.lang.System.*;

public class Main {

	Scanner sc = new Scanner(in);
	
	String reverse(String s) {
		String ans = "";
		int len = s.length();
		for (int i = 0; i < len; i++)
			ans += s.charAt(len-i-1);
		return ans;
	}
	
	String J(String s) {
		return s.substring(s.length()-1)+s.substring(0, s.length()-1);
	}
	
	String C(String s) {
		return s.substring(1)+s.substring(0, 1);
	}
	
	String A(String s) {	
		return reverse(s);
	}
	
	String P(String s) {
		char[] ans = s.toCharArray();
		for (int i = 0; i < ans.length; i++) {
			if (Character.isDigit(ans[i])) {
				switch(ans[i]) {
				case '0': ans[i] = '9'; break;
				case '1': ans[i] = '0'; break;
				case '2': ans[i] = '1'; break;
				case '3': ans[i] = '2'; break;
				case '4': ans[i] = '3'; break;
				case '5': ans[i] = '4'; break;
				case '6': ans[i] = '5'; break;
				case '7': ans[i] = '6'; break;
				case '8': ans[i] = '7'; break;
				case '9': ans[i] = '8'; break;
				}
			}
		}
		return String.valueOf(ans);
	}
	
	String M(String s) {
		char[] ans = s.toCharArray();
		for (int i = 0; i < ans.length; i++) {
			if (Character.isDigit(ans[i])) {
				switch(ans[i]) {
				case '0': ans[i] = '1'; break;
				case '1': ans[i] = '2'; break;
				case '2': ans[i] = '3'; break;
				case '3': ans[i] = '4'; break;
				case '4': ans[i] = '5'; break;
				case '5': ans[i] = '6'; break;
				case '6': ans[i] = '7'; break;
				case '7': ans[i] = '8'; break;
				case '8': ans[i] = '9'; break;
				case '9': ans[i] = '0'; break;
				}
			}
		}
		return String.valueOf(ans);
	}
	
	String E(String s) {
		int n = s.length();
		if (n % 2 == 0) {
			return s.substring(n/2)+s.substring(0,n/2); 
		} else {
			return s.substring(n/2+1)+s.substring(n/2, n/2+1)+s.substring(0,n/2);
		}
	}
	
	void run() {
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String order = sc.next();
			String message = sc.next();
			for (int j = order.length()-1; j >= 0; j--) {
				switch(order.charAt(j)) {
				case 'J': message = J(message); break;
				case 'C': message = C(message); break;
				case 'E': message = E(message); break;
				case 'A': message = A(message); break;
				case 'P': message = P(message); break;
				case 'M': message = M(message); break;
				}
			}
			out.println(message);
		}
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}