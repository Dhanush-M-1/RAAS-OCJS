import java.util.*;
import static java.lang.System.out;
import static java.lang.Math.*;

public class T {
	public static void main(String... args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int f = 0, s = 0;
		for (int i = 0; i < n; ++i) {
			int w = in.nextInt();
			if (w == 100) f++;
			else s++;
		}
		
		if (f == 0) {
			if (s % 2 == 0) {
				out.println("YES");
			} else {
				out.println("NO");
			}
			return;
		}
		if (s == 0) {
			if (f % 2 == 0) {
				out.println("YES");
			} else {
				out.println("NO");
			}
			return;
		}
		
		if ((f + 2*s) % 2 == 0) {
			out.println("YES");
		} else {
			out.println("NO");
		}
		
		
	}
	
}
