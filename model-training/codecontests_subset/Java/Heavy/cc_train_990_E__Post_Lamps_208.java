import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class E {

	static int N,M,K;
	static boolean blocked[];
	static long cost[];
	static int go[];
	public static void main(String[] args) {
		JS in = new JS();
		N = in.nextInt();
		M = in.nextInt();
		K = in.nextInt();
		blocked = new boolean[N];
		cost = new long[K+1];
		for(int i = 0; i < M; i++) {
			blocked[in.nextInt()]=true;
		}
		
		for(int i = 0; i < K; i++) {
			cost[i+1] = in.nextLong();
		}
		
		int maxRun = 0;
		int curRun = 0;
		for(int i = 0; i < N; i++) {
			if(blocked[i])curRun++;
			else {
				maxRun = Math.max(maxRun, curRun);
				curRun = 0;
			}
		}
		maxRun = Math.max(maxRun, curRun);
		
		if(maxRun >= K || blocked[0]) {
			System.out.println(-1);
		}
		else {
			int prev = -1;
			go = new int[N];
			for(int i = 0; i < N; i++) {
				if(!blocked[i]) prev = i;
				go[i] = prev;
			}
			
			
			long bestCost = Long.MAX_VALUE;
			//Calc the cost in log(N) time somehow
			for(int pow = maxRun+1; pow <= K; pow++) {
				long curCost = 0;
				int curPos = 0;
				while(true) {
					//System.out.println(curPos+ " "+pow);
					if(curPos + pow >= N) {
						curCost += cost[pow];
						break;
					}
					else {
						curCost += cost[pow];
						curPos = go[curPos + pow];
					}
				}
				bestCost = Math.min(bestCost, curCost);
			}
			System.out.println(bestCost);
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
			double cur = nextLong();
			return c!='.' ? cur:cur+nextLong()/num;
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
