import java.io.*;
import java.util.*;
import java.lang.reflect.*;


public class Main {

	static long CURRENT_TIME_NANO = System.nanoTime();

	public static void main(String[] args) throws Exception {

		int n = 26;
		
		String a = nextToken();
		String b = nextToken();
		String c = nextToken();
		
		int []aLet = new int[n];
		int []bLet = new int[n];
		int []cLet = new int[n];
		
		for (int i = 0; i < a.length(); i++){
			aLet[a.charAt(i)-'a']++;
		}
		
		for (int i = 0; i < c.length(); i++){
			cLet[c.charAt(i)-'a']++;
		}
		
		for (int i = 0; i < b.length(); i++){
			bLet[b.charAt(i)-'a']++;
		}
		
		int ans = 0;
		int bans = 0;
		int cans = 0;
		boolean good = true;
		for (int i = 0; good; i++) {
			int min = 100001;
			for(int j = 0; j < n; j++) {
				if(aLet[j] - i*bLet[j] < 0) {
					good = false;
					break;
				}
				if (cLet[j] != 0) min = Math.min(min, (aLet[j] - i*bLet[j])/cLet[j]);
			}
			if(good && (i+min > ans)) {
				ans = i + min;
				bans = i;
				cans = min;
			}
		}


	//	out.print(ans + " "+ bans + " " + cans);
		
		for (int i = 0; i < n; i++) {
//			out.println(i + " " + aLet[i] - bans*bLet[j] - cans*cLet[j]);
			for(int j = 0; j < (aLet[i] - bans*bLet[i] - cans*cLet[i]); j++)
				out.print((char)(i+'a'));
		}
		
		for (;bans>0; bans--) {
			out.print(b);
		}
		
		for (;cans>0; cans--) {
			out.print(c);
		}
		
//		out.println();
		
		
		out.println();
		out.close();
	}
	
	static void printtime() {System.out.println((System.nanoTime() - CURRENT_TIME_NANO)*1e-9);}
	static void nexttime() {printtime(); CURRENT_TIME_NANO = System.nanoTime();}
	static PrintWriter out = new PrintWriter(System.out);
	
	static BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer in = new StringTokenizer("");

	static String nextToken() throws Exception {
		if (!in.hasMoreTokens()) in = new StringTokenizer(bufferedreader.readLine());
		return in.nextToken();
	}

	static int next()  throws Exception {return Integer.parseInt(nextToken());};
	static int[] next(int n) throws Exception {
		int[] x = new int[n];
		for (int i = 0; i < n; i++) x[i] = next();
		return x;
	}
	static int[][] next(int n, int m) throws Exception {
		int[][] x = new int[n][];
		for (int i = 0; i < n; i++) x[i] = next(m);
		return x;
	}

	static long nextl() throws Exception {return Long.parseLong(nextToken());};
	static long[] nextl(int n) throws Exception {
		long[] x = new long[n];
		for (int i = 0; i < n; i++) x[i] = nextl();
		return x;
	}
	static long[][] nextl(int n, int m) throws Exception {
		long[][] x = new long[n][];
		for (int i = 0; i < n; i++) x[i] = nextl(m);
		return x;
	}

	static double nextd() throws Exception {return Double.parseDouble(nextToken());};
	static double[] nextd(int n) throws Exception {
		double[] x = new double[n];
		for (int i = 0; i < n; i++) x[i] = nextd();
		return x;
	}
	static double[][] nextd(int n, int m) throws Exception {
		double[][] x = new double[n][];
		for (int i = 0; i < n; i++) x[i] = nextd(m);
		return x;
	}

	static String nextline() throws Exception {
		in = new StringTokenizer("");
		return bufferedreader.readLine();
	}

	static void sout(String s) {System.out.println(s);}
	static void sout(long x) {System.out.println(x);}
	static void sout(int[] x) {for (int xx : x) System.out.print(xx + " "); System.out.println();}
	static void sout(long[] x) {for (long xx : x) System.out.print(xx + " "); System.out.println();}
	static void sout(int[][] x) {for (int[] xx : x) sout(xx); System.out.println();}
	static void sout(long[][] x) {for (long[] xx : x) sout(xx); System.out.println();}


}