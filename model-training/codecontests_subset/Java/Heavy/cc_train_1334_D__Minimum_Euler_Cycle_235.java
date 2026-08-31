import java.io.*;
import java.math.*;
import java.util.*;

public class D_minimumEulerCycle {
    public static void main(String[] args) throws IOException {
        FastScanner sc = new FastScanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int queries = sc.nextInt();
        while (queries --> 0) {
        	int n = sc.nextInt();
        	long l = sc.nextLong();
        	long r = sc.nextLong();
        	long print = r-l+1;
//        	StringBuilder toPrint = new StringBuilder("");
        	int length = 0;
        	int chunk = 1;
        	//chunk[i] length = 2(n*(n-1)-i)
        	hi:
        	while (l > 0) {
        		l -= 2*(long)(n-chunk);
        		chunk++;
//        		pw.println("chunk = " + chunk);
//        		pw.println("l = " + l);
//        		if (chunk > 100500) {
//        			System.exit(0);
//        		}
        		if (l == 1) {
        			pw.println(1);
        			break hi;
        		}
        		else if (l > 0) {
        			continue;
        		}
        		else if (l == 0) {
        			chunk--;
//        			pw.println("WTMOO");
//        			toPrint.append(n);
        			pw.print(n + " ");
        			length++;
        			while (length < print) {
        			chunk++;
        			if (chunk == n) {
//    					toPrint.append(1);
    					pw.print(1 + " ");
    					length++;
    					break hi;
    				}
        			for (int i = chunk+1; i <= n; i++) {
//        				toPrint.append(chunk);
        				pw.print(chunk + " ");
        				length++;
        				if (length == print) {
        					break hi;
        				}
//        				toPrint.append(i);
        				pw.print(i + " ");
        				length++;
        				if (length == print) {
        					break hi;
        				}
        			}
        			}
        		}
        		else {
        			chunk--;
        			l += 2*(long)(n-chunk);
        			for (int i = chunk+1; i <= n; i++) {
        				if (l-1 > 0) {
        					l--;
        					if (l-1 > 0) {
        						l--;
        					}
        					else {
//        						toPrint.append(i);
        						pw.print(i + " ");
        						length++;
        						if (length == print) {
                					break hi;
                				}
        					}
        				}
        				else {
//        					toPrint.append(chunk);
        					pw.print(chunk + " ");
        					length++;
            				if (length == print) {
            					break hi;
            				}
//            				toPrint.append(i);
            				pw.print(i + " ");
            				length++;
            				if (length == print) {
            					break hi;
            				}
        				}
        			}
        			while (length < print) {
            			chunk++;
            			if (chunk == n) {
//        					toPrint.append(1);
            				pw.print(1 + " ");
            				length++;
        					break hi;
        				}
            			for (int i = chunk+1; i <= n; i++) {
//            				toPrint.append(chunk);
            				pw.print(chunk + " ");
            				length++;
            				if (length == print) {
            					break hi;
            				}
//            				toPrint.append(i);
            				pw.print(i + " ");
            				length++;
            				if (length == print) {
            					break hi;
            				}
            			}
            			}
        		}
        	}
//        	for (int i = 0; i < toPrint.length(); i++ ) {
//        		pw.print(toPrint.charAt(i) + " ");
//        	}
        	pw.println();
        }
        
        pw.close();
    }
    static class FastScanner {
    	private boolean finished = false;

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw   new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
        public int peek() {
            if (numChars == -1) {
                return -1;
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }
        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }
        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines) {
                return readLine();
            } else {
                return readLine0();
            }
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(nextString());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public char nextCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public boolean isExhausted() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1) {
                read();
            }
            return value == -1;
        }
    public String next() {
            return nextString();
        }

        public SpaceCharFilter getFilter() {
            return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
        public int[] nextIntArray(int n){
            int[] array=new int[n];
            for(int i=0;i<n;++i)array[i]=nextInt();
            return array;
        }
        public int[] nextSortedIntArray(int n){
            int array[]=nextIntArray(n);
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for(int i = 0; i < n; i++){
                pq.add(array[i]);
            }
            int[] out = new int[n];
            for(int i = 0; i < n; i++){
                out[i] = pq.poll();
            }
            return out;
        }
        public int[] nextSumIntArray(int n){
            int[] array=new int[n];
            array[0]=nextInt();
            for(int i=1;i<n;++i)array[i]=array[i-1]+nextInt();
            return array;
        }
        public ArrayList<Integer>[] nextGraph(int n, int m){
            ArrayList<Integer>[] adj = new ArrayList[n];
            for(int i = 0; i < n; i++){
                adj[i] = new ArrayList<Integer>();
            }
            for(int i = 0; i < m; i++){
                int u = nextInt(); int v = nextInt();
                u--; v--;
                adj[u].add(v); adj[v].add(u);
            }
            return adj;
        }
        public ArrayList<Integer>[] nextTree(int n){
            return nextGraph(n, n-1);
        }

        public long[] nextLongArray(int n){
            long[] array=new long[n];
            for(int i=0;i<n;++i)array[i]=nextLong();
            return array;
        }
        public long[] nextSumLongArray(int n){
            long[] array=new long[n];
            array[0]=nextInt();
            for(int i=1;i<n;++i)array[i]=array[i-1]+nextInt();
            return array;
        }
        public long[] nextSortedLongArray(int n){
            long array[]=nextLongArray(n);
            Arrays.sort(array);
            return array;
        }
    }
	static void shuffle(int[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
	static void shuffle(long[] a) {
		Random get = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = get.nextInt(a.length);
			long temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}
}