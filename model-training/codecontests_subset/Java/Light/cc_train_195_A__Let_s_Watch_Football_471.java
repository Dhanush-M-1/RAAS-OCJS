import java.util.*;
import java.io.*;

public class Main{

    BufferedReader in;
    StringTokenizer str = null;
    PrintWriter out;

    private String next() throws Exception{
    	while (str == null || !str.hasMoreElements())
    	    str = new StringTokenizer(in.readLine());
    	return str.nextToken();
    }
    
    private int nextInt() throws Exception{
	   return Integer.parseInt(next());
    }
    
    public void run() throws Exception{
    	in = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(System.out);
        int a = nextInt(), b = nextInt(), c = nextInt();
        long lo = -1, hi = 10000009;
        while(hi - lo > 1) {
            long m = lo + (hi - lo) / 2;
            long x = b * m, rem = c * a - x;
            boolean bad = false;
            while(rem > 0) {
                x += b;
                x -= a;
                if (x < 0) {
                    bad = true;
                    break;
                }
                rem -= b;
            }

            if (bad) {
                lo = m;
            }else {
                hi = m;
            }
        }

        out.println(hi);
        out.close();
    }

    public static void main(String args[]) throws Exception{
	   new Main().run();
    }
}