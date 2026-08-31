import java.io.*;
import java.util.*;
import java.math.*; // for bigInteger

public class practice {   

    private final static int M = (int)1e9+7;
	
    private static final InputReader scan = new InputReader(System.in);
    private static final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final StringBuilder sb = new StringBuilder();
       
  	final public static void main(String args[]) throws Exception {
        //scanner scan = new scanner(system.in);
        //scan.usedelimiter("");  // for reading character by character

        int n = scan.nextInt();
        int[][] trees = new int[n+1][2];
        for(int i=0;i<n;++i) {
            trees[i][0]=scan.nextInt();
            trees[i][1]=scan.nextInt();
        }
        trees[n][0]=Integer.MAX_VALUE;
        int count = 1; 
        for(int i=1;i<n;++i) {
            int x = trees[i][0];
            int h = trees[i][1];
            int xl = trees[i-1][0];
            int xr = trees[i+1][0];
            if(x-h>xl) {
                ++count;
            } else if(x+h<xr) {
                ++count;
                trees[i][0]=x+h;
            }
        }
        out.println(count);

        scan.close();
        out.close();
    }

	private final static int m =(int)1e9+7;
	private static class Pair<T,V> {
		T first;
		V second;
		Pair(final T first, final V second) {
			this.first = first;
			this.second = second;
		}
		public boolean equals(Object o) {
			Pair given = (Pair)o;
			if(given.first == first && given.second == second)  return true;
			return false;
		}
		public int hashCode() {
			long temp = (long)(first.hashCode())*31;
			temp = (temp+(long)second.hashCode())%m;
			return (int)temp;
		}
	}

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int snumChars;
        private SpaceCharFilter filter;

        public InputReader(final InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }

            int res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }

            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));

            return res * sgn;
        }

        public String next() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
        
        public void close() throws IOException {
            if(stream==null) {
                return;
            }
            stream.close();
        }
    }

    public static void debug(final int[] ...var) {
        for(final int[] row : var) {
            debug(row);
        }
    }

    public static void debug(final long[] ...var) {
        for(final long[] row : var) {
            debug(row);
        }
    }

    public static void debug(final String[] ...var) {
        for(final String[] row : var) {
            debug(row);
        }
    }

    public static void debug(final double[] ...var) {
        for(final double[] row : var) {
            debug(row);
        }
    }

    public static void debug(final char[] ...var) {
        for(final char[] row : var) {
            debug(row);
        }
    }

    public static void debug(final int ...var) {
        for(final int i:var)  System.err.print(i+" ");
        System.err.println();
    }
    public static void debug(final String ...var) {
        for(final String i:var)  System.err.print(i+" ");
        System.err.println();
    }
    public static void debug(final double ...var) {
        for(final double i:var)  System.err.print(i+" ");
        System.err.println();
    }
    
    public static void debug(final long ...var) {
        for(final long i:var)  System.err.print(i+" ");
        System.err.println();
    }
    
    public static void debug(final char ...var) {
        for(final char c:var)  System.err.print(c+" ");
        System.err.println();
    }

    /*
    public static <T> void debug(T ...varargs) {
        // Warning
        // Heap Pollution might occur
        // this overrides even 1d and 2d array methods as it is an object... 
        // + i am not using object based array like Integer[]
        // I am using int[] so that is a problem as i need Wrapper class as an argument
        for(T val:varargs)  System.err.printf("%s ",val);
        System.err.println();
    }
    */
}
