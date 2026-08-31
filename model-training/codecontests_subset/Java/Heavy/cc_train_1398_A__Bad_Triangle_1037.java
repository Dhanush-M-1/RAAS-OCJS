import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class A {

	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
	    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	    
	    int t = sc.nextInt();
	    while(t-- > 0) {
	    	int n = sc.nextInt();
	    	
	    	int[][] a = new int[n][2];
	    	for(int i = 0; i < n; i++) {
	    		a[i][0] = sc.nextInt();
	    		a[i][1] = i + 1;
	    	}
	    	
	    	Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));
	    	
	    	if(a[0][0] + a[1][0] > a[a.length - 1][0])
	    		out.println(-1);
	    	else {
	    		int[] res = {a[0][1], a[1][1], a[a.length - 1][1]};
	    		Arrays.sort(res);
	    		out.println(res[0] + " " + res[1] + " " + res[2]);
	    	}
	    }
	    
	    out.close();
	}
	
	private static class FastScanner {
        private int BS = 1<<16;
        private char NC = (char)0;
        private byte[] buf = new byte[BS];
        private int bId = 0, size = 0;
        private char c = NC;
        private double cnt = 1;
        private BufferedInputStream in;
 
        public FastScanner() {
            in = new BufferedInputStream(System.in, BS);
        }
 
        public FastScanner(String s) {
            try {
                in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
            }
            catch (Exception e) {
                in = new BufferedInputStream(System.in, BS);
            }
        }
 
        private char getChar(){
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
 
        public int[] nextInts(int N) {
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = (int) nextLong();
            }
            return res;
        }
 
        public long[] nextLongs(int N) {
            long[] res = new long[N];
            for (int i = 0; i < N; i++) {
                res[i] = nextLong();
            }
            return res;
        }
 
        public long nextLong() {
            cnt=1;
            boolean neg = false;
            if(c==NC)c=getChar();
            for(;(c<'0' || c>'9'); c = getChar()) {
                if(c=='-')neg=true;
            }
            long res = 0;
            for(; c>='0' && c <='9'; c=getChar()) {
                res = (res<<3)+(res<<1)+c-'0';
                cnt*=10;
            }
            return neg?-res:res;
        }
 
        public double nextDouble() {
            double cur = nextLong();
            return c!='.' ? cur:cur+nextLong()/cnt;
        }
 
        public String next() {
            StringBuilder res = new StringBuilder();
            while(c<=32)c=getChar();
            while(c>32) {
                res.append(c);
                c=getChar();
            }
            return res.toString();
        }
 
        public String nextLine() {
            StringBuilder res = new StringBuilder();
            while(c<=32)c=getChar();
            while(c!='\n' && c!='\r') {
                res.append(c);
                c=getChar();
            }
            return res.toString();
        }
 
        public boolean hasNext() {
            if(c>32)return true;
            while(true) {
                c=getChar();
                if(c==NC)return false;
                else if(c>32)return true;
            }
        }
    }
}
