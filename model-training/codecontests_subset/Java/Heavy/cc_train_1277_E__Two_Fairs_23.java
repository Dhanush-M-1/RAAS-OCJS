import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeSet;

public final class CF_606_D2_E
{


	static boolean verb=true;
	static void log(Object X){if (verb) System.err.println(X);}
	static void log(Object[] X){if (verb) {for (Object U:X) System.err.print(U+" ");System.err.println("");}}
	static void log(int[] X){if (verb) {for (int U:X) System.err.print(U+" ");System.err.println("");}}
	static void log(int[] X,int L){if (verb) {for (int i=0;i<L;i++) System.err.print(X[i]+" ");System.err.println("");}}
	static void log(long[] X){if (verb) {for (long U:X) System.err.print(U+" ");System.err.println("");}}

	static void logWln(Object X){if (verb) System.err.print(X);}
	static void info(Object o){	System.out.println(o);}
	static void output(Object o){outputWln(""+o+"\n");	}
	static void outputWln(Object o){try {out.write(""+ o);} catch (Exception e) {}}













	// Global vars
	static BufferedWriter out;
	static InputReader reader;




	static void test() {
		log("testing");

		log("done");

	}



	static void process() throws Exception {


		//String bob=")))aaa(R(RaR))R(R(a)))RRaLaa)LRaa(aR))(LaRR(a(a)LaR()R(RR)(RaRa(()aaLLLLL(a)(()R(()LRaaL(L()L))aLa)aaR()R)()L)(RLRa)L()R)RRL)LL)R)aaR()a)RR)aRL())R)R(aL)))R(a(RR)L(Raa)RL)aR(LLaRR(LaLR(L((a(aaRL))aa)RR()LRL)aaa))aaaLaRLLaaa)aa())R)aaL(()a)(aR(LRaR(a)a((aLL(L)RLL)a)(a)LL(LLR)(R((a(()a(LRL(()LRRaaRLLRaR()RR(a(R)a((((L(Raa)aa())a(a(R(aR)L))Ra()RLRL)(L)RaL)LaaaRaR))a)Ra)LL))((aR))LL)(L()R))L(aaR(LRRRaL)L(LaLR)L))RR((aaaL)((L()aL)La(a(R)(aR((RLaLaR)RaRL)))aRaL))RR)L)(()()LaLRaR)((aaaLa)R)aL(RR(Ra(RRaRR";
		//log(bob.length());

		//arrayTest();

		out = new BufferedWriter(new OutputStreamWriter(System.out));
		reader = new InputReader(System.in);


		int time=0;
		int[] visited=new int[200000];
		int[] stack=new int[200000];

		int T=reader.readInt();
		for (int t=0;t<T;t++) {
			time++;
			int n=reader.readInt();
			int m=reader.readInt();
			int a=reader.readInt()-1;

			int b=reader.readInt()-1;
			ArrayList<Integer>[] friends=new ArrayList[n];
			for (int u=0;u<n;u++)
				friends[u]=new ArrayList<Integer>();

			for (int i=0;i<m;i++) {
				int u=reader.readInt()-1;
				int v=reader.readInt()-1;
				friends[u].add(v);
				friends[v].add(u);
			}
			int A=1;
			int B=2;
			int AB=3;
			int[] num=new int[4];
			for (int u=0;u<n;u++) {
				if (u!=a && u!=b) {
					int cnt=1;
					int mask=0;
					if (visited[u]<time) {
						int st=0;
						stack[st++]=u;
						visited[u]=time;
						while (st>0) {
							int v=stack[--st];
							for (int w:friends[v]) {
								if (visited[w]<time) {
									if (w==a)
										mask|=A;
									else
										if (w==b)
											mask|=B;
										else {
											stack[st++]=w;
											visited[w]=time;
											cnt++;
										}
								}

							}
						}
						//log("found "+cnt+" with mask:"+Integer.toBinaryString(mask));
						num[mask]+=cnt;
					}
				}
			}
			long na=num[A];
			long nb=num[B];
			output(na*nb);

		}


		try {
			out.close();
		} catch (Exception e) {
		}

	}





	public static void main(String[] args) throws Exception {
		process();

	}

	static final class InputReader {
		private final InputStream stream;
		private final byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		private int read() throws IOException {
			if (curChar >= numChars) {
				curChar = 0;
				numChars = stream.read(buf);
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public final String readString() throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.append((char) c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public final String readString(int L) throws IOException {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder(L);
			do {
				res.append((char) c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public final int readInt() throws IOException {
			int c = read();
			boolean neg = false;
			while (isSpaceChar(c)) {
				c = read();
			}
			char d = (char) c;
			// log("d:"+d);
			if (d == '-') {
				neg = true;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			// log("res:"+res);
			if (neg)
				return -res;
			return res;

		}

		public final long readLong() throws IOException {
			int c = read();
			boolean neg = false;
			while (isSpaceChar(c)) {
				c = read();
			}
			char d = (char) c;
			// log("d:"+d);
			if (d == '-') {
				neg = true;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			// log("res:"+res);
			if (neg)
				return -res;
			return res;

		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}

}