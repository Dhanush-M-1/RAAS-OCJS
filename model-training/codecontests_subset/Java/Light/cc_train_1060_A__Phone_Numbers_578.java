import java.util.Locale;
import java.util.Scanner;

public class TelefonNomeri1060A {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), i, k = 0;
		String s = in.next();
		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '8') {
				k++;
			}
		}
		for(i = n/11;i>=1;i--) {
			if(n-i*10<=k) {
				System.out.println(i);
				return;
			}
		}
		if((n-k)/10>k) {
			System.out.println(k);
		}else {
			System.out.println((n-k)/10);
		}
	}
}
