import java.util.*;
import java.math.*;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.next());
		int ac = 0;
		int wa = 0;
		int tle = 0;
		int re = 0;
		for(int i = 0; i < n; i++) {
			String cur = in.next();
			if(cur.equals("AC")) ac += 1;
			else if(cur.equals("WA")) wa += 1;
			else if(cur.equals("TLE")) tle += 1;
			else re += 1;
		}
		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.println("RE x " + re);
	}
}