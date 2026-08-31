import java.util.*;
import java.math.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int b1 = sc.nextInt();
		int b2 = sc.nextInt();
		
		int x = Math.abs(a1-b1);
		int y = Math.abs(a2-b2);
		x = Math.min(x, r-x);
		y = Math.min(y, c-y);
		
		int f = 1;
		if(r == 2*x) f *= 2;
		if(c == 2*y) f *= 2;
		
		int z = Math.min(x, y);
		BigInteger bi = BigInteger.ONE;
		for(int i=0;i<z;i++){
			bi = bi.multiply(new BigInteger(String.valueOf(x+y-i)));
			bi = bi.divide(new BigInteger(String.valueOf(i+1)));
		}
		bi = bi.multiply(new BigInteger(String.valueOf(f)));
		bi = bi.mod(new BigInteger("100000007"));
		System.out.println(bi);
	}	
}