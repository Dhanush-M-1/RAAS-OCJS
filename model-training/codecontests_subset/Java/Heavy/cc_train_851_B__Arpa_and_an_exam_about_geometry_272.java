import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.*;

public class Main {

	Scanner cin = new Scanner(new BufferedInputStream(System.in));
	
	BigInteger len(int x1, int y1, int x2, int y2) {
		BigInteger res = BigInteger.ZERO;
		res = res.add(BigInteger.valueOf(y2-y1).multiply(BigInteger.valueOf(y2-y1)));
		res = res.add(BigInteger.valueOf(x2-x1).multiply(BigInteger.valueOf(x2-x1)));
		return res;
	}
	
	void solve() {
		while (cin.hasNext()) {
			int a0 = cin.nextInt();
			int a1 = cin.nextInt();
			int a2 = cin.nextInt();
			int a3 = cin.nextInt();
			int a4= cin.nextInt();
			int a5 = cin.nextInt();
			BigInteger s1 = BigInteger.valueOf(a5).subtract(BigInteger.valueOf(a3));
			BigInteger s2 = BigInteger.valueOf(a2).subtract(BigInteger.valueOf(a0));
			BigInteger s3 = BigInteger.valueOf(a4).subtract(BigInteger.valueOf(a2));
			BigInteger s4 = BigInteger.valueOf(a3).subtract(BigInteger.valueOf(a1));
			s1 = s1.multiply(s2);
			s3 = s3.multiply(s4);
			if(len(a0,a1,a2,a3).compareTo(len(a2,a3,a4,a5)) == 0 && /*((a5-a3)*(a2-a0)!=(a4-a2)*(a3-a1))*/ s3.compareTo(s1) != 0) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
	
	public static void main(String[] args) {
		new Main().solve();
	}
}