import java.util.*;

public class EhabandXor{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c = 0;
		int d = 0;
		int x = 29;
		boolean f = true;
		int r1 = 0;
		int r2 = 0;
		int r3 = 0;
		while(x >= 0) {
			if(f) {
				System.out.println("? "+c+" "+d);
				System.out.flush();
				r1 = in.nextInt();
			}
			c ^= 1 << x;
			d ^= 1 << x;
			System.out.println("? "+c+" "+d);
			System.out.flush();
			r2 = in.nextInt();
			f = true;
			if(r1 > r2) {
				d ^= 1<<x;
			}else if(r1 < r2) {
				c ^= 1<<x;
			}else {
				d ^= 1<<x;
				System.out.println("? "+c+" "+d);
				System.out.flush();
				r3 = in.nextInt();
				if(r3 < 0) {
					d ^= 1 << x;
				}else {
					c ^= 1 << x;
				}
				f = false;
			}
			x--;
		}
		in.close();
		System.out.println("! "+c+" "+d);
	}
}