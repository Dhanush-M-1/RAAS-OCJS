import java.io.*;
import java.math.*;
import java.util.*;
public class Main { 
 
	public static void main(String[] args) { 
		FastScanner I = new FastScanner(); //Input
		OutPut O = new OutPut(); //Output
		String S = I.next();
		boolean valid=false;
		int N = S.length();
		if (S.equals("keyence")) valid=true;
		else {
			if (S.charAt(0)!='k'&&S.substring(N-7,N).equals("keyence")) valid=true;
			else if (S.charAt(N-1)!='e'&&S.substring(0,7).equals("keyence")) valid=true;
			else if (S.charAt(0)=='k'&&S.substring(N-6,N).equals("keyence")) valid=true;
			else if (S.substring(0,2).equals("ke")&&S.substring(N-5,N).equals("yence")) valid=true;
			else if (S.substring(0,3).equals("key")&&S.substring(N-4,N).equals("ence")) valid=true;
			else if (S.substring(0,4).equals("keye")&&S.substring(N-3,N).equals("nce")) valid=true;
			else if (S.substring(0,5).equals("keyen")&&S.substring(N-2,N).equals("ce")) valid=true;
			else if (S.substring(0,6).equals("keyenc")&&S.substring(N-1,N).equals("e")) valid=true;
		}
		O.pln(valid?"YES":"NO");
	}
	public static long ceil(long num, long den) {long ans = num/den; if (num%den!=0) 
	ans++; return ans;}
	public static long GCD(long a, long b) {
		if (a==0||b==0) return Math.max(a,b);
		return GCD(Math.min(a, b),Math.max(a, b)%Math.min(a, b));
	}
	public static long FastExp(long base, long exp, long mod) {
		long ans=1;
		while (exp>0) {
			if (exp%2==1) ans*=base;
			exp/=2;
			base*=base;
			base%=mod;
			ans%=mod;
		}
		return ans;
	}
	public static long ModInv(long num,long mod) {return FastExp(num,mod-2,mod);}
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());};
	}
	static class OutPut{
		PrintWriter w = new PrintWriter(System.out);
		void pln(int x) {w.println(x);w.flush();}
		void pln(long x) {w.println(x);w.flush();}
		void pln(String x) {w.println(x);w.flush();}
		void pln(char x) {w.println(x);w.flush();}
		void pln(StringBuilder x) {w.println(x);w.flush();}
		void p(int x) {w.print(x);w.flush();}
		void p(long x) {w.print(x);w.flush();}
		void p(String x) {w.print(x);w.flush();}
		void p(char x) {w.print(x);w.flush();}
		void p(StringBuilder x) {w.print(x);w.flush();}
	}
}