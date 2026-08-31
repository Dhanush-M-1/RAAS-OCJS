import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class B {

	public static void main(String[] args) {
		JS in = new JS();
		int N = in.nextInt();
		int med = in.nextInt();
		int ar[] = new int[N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			list.add(in.nextInt());
		}
		Collections.sort(list);
		for(int i = 0; i < N; i++) {
			ar[i] = list.get(i);
		}
		
		int mid = N/2;
		long res = 0;
		res += Math.abs(ar[mid]-med);
		for(int i = mid+1; i < N; i++) {
			if(ar[i] < med) res += (long)(med-ar[i]);
		}
		for(int i = mid-1; i >= 0; i--) {
			if(ar[i] > med) res += (long)(ar[i]-med);
		}
		System.out.println(res);
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
