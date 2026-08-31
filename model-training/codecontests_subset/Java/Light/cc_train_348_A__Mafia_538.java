

import java.io.*;
import java.util.*;
/**
 *
 * @author Do Quoc bao
 */
public class ProblemC {
    static ArrayList<Long> arr=new ArrayList<>();
    static boolean cothe(long x) {
	long sup=0;
	for (int i=0;i<arr.size();++i) if ((x-arr.get(i))>=0) sup+=(x-arr.get(i)); else return false;
	if (sup>=x) return true;
	return false;
    }
    public static void main(String[] args) throws java.lang.Exception {
	in.init(System.in);
	int n=in.nextInt(),i;
	arr=new ArrayList<>();
	for (i=0;i<n;++i) arr.add((long)in.nextInt());
	long dau=0,cuoi=10000000,kq;
	cuoi=cuoi*10000000;kq=Long.MAX_VALUE;
	while (dau<=cuoi) {
	    long giua=(dau+cuoi)/2;
	    if (cothe(giua)) {cuoi=giua-1;kq=Math.min(kq,giua);}
	    else dau=giua+1;
	}
	System.out.println(kq);
    }
}

/**/
class in {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
/**/