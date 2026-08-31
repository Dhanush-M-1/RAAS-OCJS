import java.util.*; import java.text.*; import java.io.BufferedReader;import java.math.*; import java.util.regex.*; import java.awt.geom.*; import static java.lang.Math.*; import static java.lang.Character.*; import static java.lang.Integer.*; import static java.lang.Double.*; import static java.lang.Long.*; import static java.lang.System.*; import static java.util.Arrays.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ThisA {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream out = System.out;

    static BigInteger n,x,y,ox;
	static void readInput() throws IOException {
		String[] s = in.readLine().split("[ ]+");
		n = new BigInteger (s[0]);
		x = new BigInteger (s[1]);
		ox = new BigInteger (s[1]);
		y = new BigInteger (s[2]);
	}

	static void process() {
		BigInteger[] k = y.multiply(n).divideAndRemainder(new BigInteger("100"));
		x = x.add(k[0]);
		String s = "000" + k[1].toString();
		int xx = new Integer(s.substring(s.length()-2));
		s = s.substring(0,s.length()-2);
		x = x.add(new BigInteger(s));
		if (xx>0) x = x.add(BigInteger.ONE);
//	    System.out.println(xx+ " " + x);
		x = x.subtract(ox);
		x = x.subtract(ox);
		if (x.compareTo(BigInteger.ZERO)<0) x = BigInteger.ZERO;
		System.out.println(x.toString());
		
	}

	public static void main(String[] args) throws IOException {
		readInput();
		process();
	}

	public static void debug(Object...os) { 
		System.err.println(Arrays.deepToString(os));
	} 
	static int[] parseArrInt(String s) {
		StringTokenizer st = new StringTokenizer(s);
		int count = 0;
		int[] temp = new int[100], res;
		while (st.hasMoreTokens()) {
			temp[count++] = Integer.parseInt(st.nextToken());
		}
		res = new int[count];
		for (int i = 0; i < count; i++) {
			res[i] = temp[i];
		}
		return (res);
	}

}
