import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.TreeSet;

public final class Main {
	
	static int arr[],tmp[];
	static int inf = (int)4e9;
 	public static void main(String[]args) throws IOException {
		
		InputReader ir = new InputReader(System.in);
		PrintWriter w = new PrintWriter(System.out);
		int t,n,m,i,j,k,x,y;
		String pas = ir.nextLine();
		n = ir.nextInt();
		String arr[] = new String[n+1];
		
		for(i=1 ; i<=n ; i++){
			arr[i] = ir.nextLine();
		}
		
		boolean flag = false;
		for(i=1 ; i<=n ; i++){
			
			if(pas.equals(arr[i]) || pas.equals(""+arr[i].charAt(1)+arr[i].charAt(0)) ){
				flag = true;
				break;
			}
			if(pas.charAt(0) == arr[i].charAt(1)){
				for(j=i+1 ; j<=n ; j++){
					if(pas.charAt(1) == arr[j].charAt(0)){
						flag =true;
						break;
					}
				}
			}
			
			if(pas.charAt(1) == arr[i].charAt(0)){
				for(j=i+1 ; j<=n ; j++){
					if(pas.charAt(0) == arr[j].charAt(1)){
						flag =true;
						break;
					}
				}
			}
			
			if(flag)
				break;
		}
		
		if(flag){
			w.println("YES");
		}else{
			w.println("NO");
		}
		w.close();
	}
	
 	
 	
	static class InputReader {
		 
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
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
            while (isSpaceChar(c)) {
                c = snext();
            }
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
            while (isSpaceChar(c)) {
                c = snext();
            }
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
 
        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }
 
        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
