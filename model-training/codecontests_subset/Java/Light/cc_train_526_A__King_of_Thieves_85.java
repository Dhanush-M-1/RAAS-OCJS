import java.util.*;
import static java.lang.System.out;
import static java.lang.Math.*;

public class T {
	public static void main(String... args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
			
		for (int i = 0; i < n; ++i) {
			for (int d = 1; d < n; ++d) {
				boolean ok = true;
				for (int j = 0; j < 5; ++j) {
					int k = i + j*d;
					if (k >= n || s.charAt(k) != '*') {
						ok = false;
						break;
					}
				}
				if (ok) {
					out.println("yes");
					return;
				}
			}
		}
		out.println("no");
		
	}
	
	
}
