import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;

public class test {
	

	public static void main(String[] args) throws Exception {
		
		int r1 = nextInt();
		int r2 = nextInt();
		int c1 = nextInt();
		int c2 = nextInt();
		int d1 = nextInt();
		int d2 = nextInt();

		int x1;
		int x2;
		int x3;
		int x4;
		if((r1 + r2 == c1 + c2 ) && (c1 + c2 == d1 + d2)){
			if((c1 + r1 - d2) % 2 != 0 || (c2 + r1 - d1) % 2 != 0 || (c1 + r2 - d1) % 2 != 0 || (c2 + r2 - d2) % 2 != 0){
				exit("-1");
			}
			int[] a = new int[4];
			a[0] = x1 = (c1 + r1 - d2) / 2;
			a[1] = x2 = (c2 + r1 - d1) / 2;
			a[2] = x3 = (c1 + r2 - d1) / 2;
			a[3] = x4 = (c2 + r2 - d2) / 2;
			Arrays.sort(a);
			for(int i = 1; i < 4; i++){
				if(a[i] == a[i-1] || a[i] > 9 || a[i-1] > 9 || a[i] < 1 || a[i-1] < 1) exit("-1");
			}
			println(x1+ " " + x2);
			println(x3+ " " + x4);
 		}
		else exit("-1");	
	}
	 	
		private static PrintWriter out = new PrintWriter(System.out);
        private static BufferedReader inB = new BufferedReader(new InputStreamReader(System.in));
        private static StreamTokenizer in = new StreamTokenizer(inB);
        
        private static void exit(Object o) throws Exception {
        	out.println(o);
        	out.flush();
        	System.exit(0);
        }
        private static void println(Object o) throws Exception{
        	out.println(o);
        	out.flush();
        }
        private static int nextInt() throws Exception {
        	in.nextToken();
        	return (int)in.nval;
        }  
        private static String nextString() throws Exception {
        	in.nextToken();
        	return in.sval;        
        }
}