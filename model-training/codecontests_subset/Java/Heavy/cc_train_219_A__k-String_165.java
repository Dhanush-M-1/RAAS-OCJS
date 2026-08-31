
import java.util.*;
import java.io.*;
/**
 *
 * @author umang
 */

public class A219 {

    public static void main(String[] args) {
 
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        
        int k = in.nextInt();
        String str = in.readString();
        
        if(str.length()%k==0){
			int[] arr = new int[26];
			boolean temp = true;
			for(int i=0;i<=25;i++){
				char ch =(char)('a'+i);
				arr[i]=0;
				for(int j=0;j<str.length();j++){
					if(ch==str.charAt(j))
						arr[i]++;					
				}
				if(arr[i]%k!=0){
					temp = false;
					break;
				}				
			}
			if(temp){
				String ans = "";
				for(int j=0;j<26;j++){
					int t = arr[j]/k;
					while(t!=0){
						ans+=(char)('a'+j);
						t--;
					}
				}
/*				while(ans.length()!=str.length()/k){
					for(int j=0;j<26;j++){
						if(arr[j]!=0){
							ans+=(char)('a'+j);
							arr[j]--;
						}
						if(ans.length()==str.length()/k)
							break;
					}
				}*/
				for(int i=0;i<k;i++){
					w.print(ans);
				}
			}
			else{
				w.println("-1");
			}
		}
		else{
			w.println("-1");
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

		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public String readString() {
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
	}
}    

