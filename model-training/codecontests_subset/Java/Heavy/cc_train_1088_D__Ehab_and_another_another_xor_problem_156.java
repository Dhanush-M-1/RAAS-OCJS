import java.util.*;

public class ContestD {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c=0,d=0;
		int x = 29;
		boolean f = true;
		int r1=0,r2=0;
		while(x>=0) {
			if(f) {
				System.out.println("? "+c+" "+d);
				System.out.flush();
				r1 = in.nextInt();
			}
			c ^= 1<<x;
			d ^= 1<<x;
			System.out.println("? "+c+" "+d);
			System.out.flush();
			r2 = in.nextInt();
			f = true;
			if(r1>r2) {
				d ^= 1<<x;
			}else if(r1<r2) {
				c ^= 1<<x;
			}else {
				d ^= 1<<x;
				System.out.println("? "+c+" "+d);
				System.out.flush();
				int r3 = in.nextInt();
				if(r3<0) {
					d^=1<<x;
				}else {
					c^=1<<x;
				}
				f = false;
			}
			x--;
		}
		in.close();
		System.out.println("! "+c+" "+d);
	}
}
