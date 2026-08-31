import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.StringTokenizer;



public final class CF_338_Bulbs {

	void log(int[] X){
		int L=X.length;
		for (int i=0;i<L;i++){
			logWln(X[i]+" ");
		}
		log("");
	}


	void log(long[] X){
		int L=X.length;
		for (int i=0;i<L;i++){
			logWln(X[i]+" ");
		}
		log("");
	}
	void log(Object[] X){
		int L=X.length;
		for (int i=0;i<L;i++){
			logWln(X[i]+" ");
		}
		log("");
	}


	void log(Object o){
		logWln(o+"\n");
	}

	void logWln(Object o){
		System.out.print(o);
		//outputWln(o);

	}
	void info(Object o){
		System.out.println(o);
		//output(o);
	}

	void output(Object o){

		outputWln(""+o+"\n");

	}

	void outputWln(Object o){
		// System.out.print(o);

		try {
			out.write(""+ o);
		} catch (Exception e) {

		}
	}

	void solve(){
		
	}

	BufferedWriter out;
	int N,M;

	
	void process() throws Exception {

		out = new BufferedWriter(new OutputStreamWriter(System.out));
		InputReader reader=new InputReader(System.in);
		N=reader.readInt();
		M=reader.readInt();
		boolean[] ok=new boolean[M];
		int cnt=M;
		for (int i=0;i<N;i++){
			int x=reader.readInt();
			for (int j=0;j<x;j++) {
				int y=reader.readInt()-1;
				if (!ok[y]){
					cnt--;
					ok[y]=true;
				}
			}
		}
		if (cnt==0){
			output("YES");
		} else
			output("NO");
	
		try {
			out.close();
		}
		catch (Exception e){}


	}



	public static void main(String[] args) throws Exception {
		CF_338_Bulbs J=new CF_338_Bulbs();

		J.process();


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
			StringBuilder res=new StringBuilder();
			do {
				res.append((char)c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public final int readInt() throws IOException {
			int c = read();
			boolean neg=false;
			while (isSpaceChar(c)) {
				c = read();
			}
			char d=(char)c;
			//log("d:"+d);
			if (d=='-') {
				neg=true;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			//log("res:"+res);
			if (neg)
				return -res;
			return res;

		}

		public final long readLong() throws IOException {
			int c = read();
			boolean neg=false;
			while (isSpaceChar(c)) {
				c = read();
			}
			char d=(char)c;
			//log("d:"+d);
			if (d=='-') {
				neg=true;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			//log("res:"+res);
			if (neg)
				return -res;
			return res;

		}




		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}

} 