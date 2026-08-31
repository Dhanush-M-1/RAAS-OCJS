
import java.util.*;
import java.util.Scanner;
import java.math.*;
public class Main {
	static BigInteger x=BigInteger.valueOf(0),y=BigInteger.valueOf(0);
	static BigInteger exgcd(BigInteger a,BigInteger b) {
		if(b.equals(BigInteger.valueOf(0))) {
			x = BigInteger.valueOf(1);y = BigInteger.valueOf(0);
			return a;
		}
		BigInteger tmp = y;
		y = x;
		x = tmp;
		BigInteger d = exgcd(b,a.mod(b));
		tmp = y;
		y = x;
		x = tmp;
		y = y.subtract(x.multiply(a.divide(b)));
		
		return d;
	}
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		BigInteger n,p,w,d;
		n = cin.nextBigInteger();
		p = cin.nextBigInteger();
		w = cin.nextBigInteger();
		d = cin.nextBigInteger();
//			Main my = new Main();
		if(p.mod(w.gcd(d)).equals(BigInteger.valueOf(0))){
		BigInteger gcd = exgcd(w,d);
		BigInteger x1 = x.multiply(p.divide(gcd));
		BigInteger y1 = y.multiply(p.divide(gcd));
		BigInteger s = w.divide(gcd);
		y1 = y1.mod(s).add(s).mod(s);
		x1 = p.subtract(d.multiply(y1)).divide(w);
		if(x1.add(y1).compareTo(n) <= 0 && x1.compareTo(BigInteger.valueOf(0)) >= 0) System.out.println(x1+" "+y1+" "+n.subtract(x1).subtract(y1));
		else System.out.println("-1");
		}
		else System.out.println("-1");
	}
	
}
