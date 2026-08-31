
import java.util.*;
public class C {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int ca = 0; ca < t; ca++) {
			long a = s.nextLong(), b = s.nextLong();
			if (a < b) { long tmp = a; a = b; b = tmp; }
			List<Long> as = new ArrayList<Long>();
			List<Long> bs = new ArrayList<Long>();
			while (b != 0) {
				as.add(a);
				bs.add(b);
//				System.out.println("Steps from "+a+" to "+b+": "+a/b);
				long tmp = b;
				b = a%b;
				a = tmp;
			}
			Collections.reverse(as);
			Collections.reverse(bs);
			boolean win = false;
			for (int i = 0; i < as.size(); i++) {
				long A = as.get(i);
				long B = bs.get(i);
				long steps = A/B;
				if (win == false) {
					// jump to this one with %, then we win
					win = true;
				} else {
					if (B % 2 == 1) {
						win = steps % 2 == 0;
					} else {
						long which = steps % (B+1);
						win = which % 2 == 0;
					}
//					System.out.println("we need to make "+steps+" steps in intervals of "+B+"^k, if even number possible, then win");
				}
			}
			if (win) System.out.println("First");
			else System.out.println("Second");
		}
	}
}
