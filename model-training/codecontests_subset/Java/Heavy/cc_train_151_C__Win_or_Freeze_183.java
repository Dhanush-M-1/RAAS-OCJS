import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.StreamHandler;

public class A2 {
	static Scanner in; static long next() throws Exception {return in.nextLong();};
//	static StreamTokenizer in; static int next() throws Exception {in.nextToken(); return (int) in.nval;}
//	static BufferedReader in;
	static PrintWriter out;

	public static void main(String[] args) throws Exception {
		in = new Scanner(System.in);
//		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

        long q = next();
        long x[] = new long[100000];
        int r = 0;
        for (int i = 0;i < 100000;i++) x[i] = 1;
        long i;
        for (i = 2;q > 1 && i < 10000000;i++) {
            while (q%i == 0) {
                x[r] = i;
                r++;
                q /= i;
            }
        }
        if (i == 10000000) r++;
        if (r < 2) {
            out.println("1");
            out.println("0");
        }
        else if (r == 2) out.println("2");
        else {
            out.println("1");
            out.println(x[0]*x[1]);
        }
        out.println();
		out.close();
	}
}