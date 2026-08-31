import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class B {

	static int R,C;
	static int Q;
	static HashSet<Integer>[] haveR;
	static HashSet<Integer>[] haveC;
	static HashSet<Integer> totalRows;
	static HashSet<Integer> totalCols;
	public static void main(String[] args) {
		JS in = new JS();
		R = in.nextInt();
		C = in.nextInt();
		Q = in.nextInt();

		haveR = new HashSet[R];
		haveC = new HashSet[C];
		totalRows = new HashSet<Integer>();
		totalCols = new HashSet<Integer>();
		for(int i = 0; i < R; i++) {
			haveR[i] = new HashSet<Integer>();
		}
		for(int i = 0; i < C; i++) {
			haveC[i] = new HashSet<Integer>();
		}
		for(int i = 0; i < Q; i++) {
			//int r = i%R;
			//int c = i%C;
			int r = in.nextInt()-1;
			int c = in.nextInt()-1;
			haveR[r].add(c);
			haveC[c].add(r);
			totalRows.add(r);
			totalCols.add(c);
		}
		//Find row with most X's
		int bestR = 0;
		int bestC = 0;
		for(int i = 0; i < R; i++) {
			if(haveR[i].size() > haveR[bestR].size()) bestR = i;
		}
		for(int i = 0; i < C; i++) {
			if(haveC[i].size() > haveC[bestC].size()) bestC = i;
		}
		
		//Find how long it takes to fill bestRow
		//System.out.println("r="+bestR+" c="+bestC);
		DisjointSet dsuR = new DisjointSet(C);
		long fillR = 0;
		totalRows.add(bestR);
		for(int r = 0; r < R; r++) {
			if(r==bestR || haveR[r].size() < 2)continue;
			int st = -1;
			for(Integer c : haveR[r]) {
				if(st == -1) st = c;
				else {
					dsuR.union(st, c);
				}
			}
		}
		int cc[] = new int[C];
		for(int c = 0; c < C; c++) {
			if(haveR[bestR].contains(c)) cc[dsuR.find(c)]=1;
		}
		for(int c = 0; c < C; c++) {
			if(cc[dsuR.find(c)] == 0) {
				cc[dsuR.find(c)] = 1;
				fillR++;
			}
		}
		long resR = fillR + (R-totalRows.size());
		
//		DisjointSet dsuC = new DisjointSet(R);
//		//dsuC.union(0, 1);
//		long fillC = 0;
//		totalCols.add(bestC);
//		for(int c = 0; c < C; c++) {
//			if(c==bestC || haveC[c].size() < 2) continue;
//			int st = -1;
//			for(Integer r : haveC[c]) {
//				if(st==-1)st = r;
//				else {
//					dsuC.union(st, r);
//				}
//			}
//		}
//		int rr[] = new int[R];
//		for(int r = 0; r < R; r++) {
//			if(haveC[bestC].contains(r)) rr[dsuC.find(r)]=1;
//		}
//		for(int r = 0; r < R; r++) {
//			if(rr[dsuC.find(r)] == 0) {
//				rr[dsuC.find(r)] = 1;
//				fillC++;
//			}
//		}
//		long resC = fillC + (C-totalCols.size());
//		//System.out.println(resR+" "+resC);
		
		System.out.println((resR));
	}

	static class DisjointSet {
		int[] s;
		
		public DisjointSet(int n) {
			Arrays.fill(s = new int[n], -1);
		}
		
		public int find(int i) {
			return s[i] < 0 ? i : (s[i] = find(s[i]));
		}
		
		public boolean union(int a, int b) {
			if ((a = find(a)) == (b = find(b))) return false;
			if(s[a] == s[b]) s[a]--;
			if(s[a] <= s[b]) s[b] = a; else s[a] = b;
			return true;
		}
	}
	
	static class JS{
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;
		
		public JS() {
			in = new BufferedInputStream(System.in, BS);
		}
		
		public JS(String s) throws FileNotFoundException {
			in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
		}
		
		public char nextChar(){
			while(bId==size) {
				try {
					size = in.read(buf);
				}catch(Exception e) {
					return NC;
				}				
				if(size==-1)return NC;
				bId=0;
			}
			return (char)buf[bId++];
		}
		
		public int nextInt() {
			return (int)nextLong();
		}
		
		public long nextLong() {
			num=1;
			boolean neg = false;
			if(c==NC)c=nextChar();
			for(;(c<'0' || c>'9'); c = nextChar()) {
				if(c=='-')neg=true;
			}
			long res = 0;
			for(; c>='0' && c <='9'; c=nextChar()) {
				res = (res<<3)+(res<<1)+c-'0';
				num*=10;
			}
			return neg?-res:res;
		}
		
		public double nextDouble() {
		    while(c!='.'&&c!='-'&&(c <'0' || c>'9')) c = nextChar();
		    boolean neg = c=='-';
		    if(neg)c=nextChar();
		    boolean fl = c=='.';
		    double cur = nextLong();
		    if(fl) return neg ? -cur/num : cur/num;
		    if(c == '.') {
			double next = nextLong();
			return neg ? -cur-next/num : cur+next/num;
		    }
		    else return neg ? -cur : cur;
		}
		
		public String next() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c>32) {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}
		
		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c!='\n') {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public boolean hasNext() {
			if(c>32)return true;
			while(true) {
				c=nextChar();
				if(c==NC)return false;
				else if(c>32)return true;
			}
		}
	}
	
}