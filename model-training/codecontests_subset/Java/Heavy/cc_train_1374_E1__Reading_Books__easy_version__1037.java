import java.io.*;
import java.math.*;
import java.util.*;
public class Q5 { //Where were you during the damn contest!!!!!!!!!!!
 
	public static void main(String[] args) { 
		FastScanner I = new FastScanner(); //Input
		OutPut O = new OutPut(); //Output
		int N = I.nextInt();
		int K = I.nextInt();
		int A = 0;
		int B = 0; //Alice and Bob
		ArrayList<Long> both = new ArrayList<Long>();
		ArrayList<Long> Al = new ArrayList<Long>();
		ArrayList<Long> Bo = new ArrayList<Long>();
		long ans = -1;
		for (int i = 0; i < N; i++) {
			long T = I.nextLong();
			int a = I.nextInt();
			int b = I.nextInt();
			if (a==1) A++;
			if (b==1) B++;
			if (a==1&&b==1) both.add(T);
			else if (a==1) Al.add(T);
			else if (b==1) Bo.add(T);
		}
		Collections.sort(both);
		Collections.sort(Al); //Sorting options by time
		Collections.sort(Bo);
		int a = 0;
		int b = 0;
		int bo = 0; //Pointers on array lists
		if (A>=K&&B>=K) { //If even possible to begin with
			ans++; //Convert answer to realistic time value
			long curA = K;
			long curB = K;
			while (curA>0&&curB>0) {
				boolean cheap = false;
				if (a<Al.size()&&b<Bo.size()) {
					if (bo>=both.size()||Al.get(a)+Bo.get(b)<=both.get(bo)) {
						ans+=Al.get(a)+Bo.get(b);
						a++;
						b++; //Shifting over pointers
						cheap=true;
					}
				}
				if (!cheap) {
					ans+=both.get(bo);
					bo++;
				}
				curA--;
				curB--;
			}
		}
		O.pln(ans);
	}
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