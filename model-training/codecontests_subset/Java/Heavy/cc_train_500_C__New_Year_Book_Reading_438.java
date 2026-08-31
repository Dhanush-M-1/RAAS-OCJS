import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.xml.sax.HandlerBase;

import java.util.*;

public class Main {
	
	static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        FasterScanner s = new FasterScanner();
        PrintWriter out=new PrintWriter(System.out);
        int n=s.nextInt(),m=s.nextInt();
        int [] w = s.nextIntArray(n);
        int [] a  = new int[n];
        int[] b=s.nextIntArray(m);
        for(int i=0;i<m;i++) b[i]--;
        long ans=0;
        int [] p =new int[n];
        int count=0;
        
        for(int i=0;i<m;i++){
        	int j=0;
        	for(j=0;j<count;j++)
        		if(p[j]==b[i])
        			break;
        	if(j==count)
        	{
        		p[j]=b[i];
        		count++;
        	}
        	while(j>0){
        		ans+=w[p[j-1]];
        		int x=p[j];
        		p[j] = p[j-1];
        		p[j-1]=x;
        		j--;
        	}
        }
        System.out.println(ans);
        out.close();
    }
    static class Matrix {
    	public static int[][] matrixAdd(int[][] a, int[][] b) {
    		int n = a.length;
    		int m = a[0].length;
    		int[][] res = new int[n][m];
    		for (int i = 0; i < n; i++) {
    			for (int j = 0; j < m; j++) {
    				res[i][j] = a[i][j] | b[i][j];
    			}
    		}
    		return res;
    	}

    	public static int[][] matrixMul(int[][] a, int[][] b) {
    		int n = a.length;
    		int m = a[0].length;
    		int k = b[0].length;
    		int[][] res = new int[n][k];
    		for (int i = 0; i < n; i++) {
    			for (int j = 0; j < k; j++) {
    				for (int p = 0; p < m; p++) {
    					res[i][j] = res[i][j] | (a[i][p] & b[p][j]);
    				}
    			}
    		}
    		return res;
    	}

    	public static int[][] matrixPow(int[][] a, int p) {
    		if (p == 0) {
    			return matrixUnit(a.length);
    		} else if (p % 2 == 0) {
    			return matrixPow(matrixMul(a, a), p / 2);
    		} else {
    			return matrixMul(a, matrixPow(a, p - 1));
    		}
    	}

    	public static int[][] matrixPowSum(int[][] a, int p) {
    		int n = a.length;
    		if (p == 0) {
    			return new int[n][n];
    		}
    		if (p % 2 == 0) {
    			return matrixMul(matrixPowSum(a, p / 2), matrixAdd(matrixUnit(n), matrixPow(a, p / 2)));
    		} else {
    			return matrixAdd(a, matrixMul(matrixPowSum(a, p - 1), a));
    		}
    	}

    	public static int[][] matrixUnit(int n) {
    		int[][] res = new int[n][n];
    		for (int i = 0; i < n; ++i) {
    			res[i][i] = 1;
    		}
    		return res;
    	}

    	// Usage example
    	public static void main(String[] args) {
    		int[][] a = { { 1, 2 }, { 3, 4 } };
    		int[][] b = matrixUnit(2);
    		int[][] c = matrixMul(a, b);
    	}
    }

    
    
    
    
    
    
    
    static class Node
    {
    	int id=0;
    	char ch;
    	boolean done=false;
    	Node l,r;
    	int parent=0;
    	Node(char ch){ this.ch=ch;}
		
    }
    static int gcd (long m, long n){
        long x;
        long y;
        while(m%n != 0){
            x = n;
            y = m%n;
            m = x;
            n = y;
        }
        return (int) n;
    }

    
    
    
    public static class st {
    	
	    int n;
	    int[] t;
	   
	    void build(int n2) {  // build the tree
	       t=new int[2*n2];
	       n=n2;
	    }
	    void modify(int p, int value) {
	      for (t[p += n] += value; p > 1; p >>= 1) t[p>>1] = t[p] + t[p^1];
	    }
	    int query(int l, int r) {  // sum on interval [l, r)
	      int res=0;
	      for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
	            if ((l&1)!=0) res+=t[l++];
	            if ((r&1)!=0) res+=t[--r];
	          }
	      return res;
	    }
	}
    
  
   
   
   
   
   
   
   
   
   
   
    public static class FasterScanner {
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = System.in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
          
        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
      
        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}