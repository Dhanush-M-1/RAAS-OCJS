import java.math.BigInteger;
import java.util.*;

public class cf102e {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long ax = in.nextLong();
		long ay = in.nextLong();
		long bx = in.nextLong();
		long by = in.nextLong();
		long cx = in.nextLong();
		long cy = in.nextLong();
		if(cx == 0) {
			cx = cy;
			cy = 0;
		}
		
		boolean pos = go(cx,cy,bx-ax,by-ay);
		pos |= go(cx,cy,bx+ay,by-ax);
		pos |= go(cx,cy,bx+ax,by+ay);
		pos |= go(cx,cy,bx-ay,by+ax);
		
		if(pos)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	static boolean go(long cx, long cy, long dx, long dy) {
		BigInteger a = BigInteger.valueOf(cx);
		BigInteger b = BigInteger.valueOf(cy);
		BigInteger c = BigInteger.valueOf(-cy);
		BigInteger d = BigInteger.valueOf(cx);
		BigInteger e = BigInteger.valueOf(dx);
		BigInteger f = BigInteger.valueOf(dy);

		BigInteger tmpA = a;
		BigInteger tmpB = b;
		if(!b.equals(BigInteger.ZERO)) {
			a = a.multiply(tmpB);
			b = b.multiply(tmpA);
			c = c.multiply(tmpB);
			d = d.multiply(tmpA);
			e = e.multiply(tmpB);
			f = f.multiply(tmpA);
			
			b = b.subtract(a);
			d = d.subtract(c);
			f = f.subtract(e);
		}

		BigInteger tmpC = c;
		BigInteger tmpD = d;
		
		if(!c.equals(BigInteger.ZERO)) {
			a = a.multiply(tmpD);
			b = b.multiply(tmpC);
			c = c.multiply(tmpD);
			d = d.multiply(tmpC);
			e = e.multiply(tmpD);
			f = f.multiply(tmpC);

			a = a.subtract(b);
			c = c.subtract(d);
			e = e.subtract(f);
		}

		if(a.equals(BigInteger.ZERO)) {
			tmpA = a;
			a = b;
			b = tmpA;
			tmpA = c;
			c = d;
			d = tmpA;
			tmpA = e;
			e = f;
			f = tmpA;
		}
		if(a.compareTo(BigInteger.ZERO) < 0) {
			a = BigInteger.ZERO.subtract(a);
			c = BigInteger.ZERO.subtract(c);
			e = BigInteger.ZERO.subtract(e);
		}
		if(d.compareTo(BigInteger.ZERO) < 0) {
			b = BigInteger.ZERO.subtract(b);
			d = BigInteger.ZERO.subtract(d);
			f = BigInteger.ZERO.subtract(f);
		}
		boolean x = (a.equals(BigInteger.ZERO) && c.equals(BigInteger.ZERO) && e.equals(BigInteger.ZERO));
		if(!x) {
			if(!a.equals(BigInteger.ZERO) && e.mod(a).equals(BigInteger.ZERO))
				x = true;
		}
		boolean y = (b.equals(BigInteger.ZERO) && d.equals(BigInteger.ZERO) && f.equals(BigInteger.ZERO));
		if(!y) {
			if(!d.equals(BigInteger.ZERO) && f.mod(d).equals(BigInteger.ZERO))
				y = true;
		}
		
		return x && y;
	}
	static void print(BigInteger a, BigInteger b, BigInteger c, BigInteger d, BigInteger e, BigInteger f) {
		System.out.println(a + " " + c + " " + e);
		System.out.println(b + " " + d + " " + f);
		System.out.println();
	}
}
