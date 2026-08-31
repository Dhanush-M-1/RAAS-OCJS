//package ap;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader scnr = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
//int n=scnr.nextInt();
char ar[]=new char[10000];

int i=0;
int p=1;
int s=0;
while(true){
	String st=scnr.readString();

	if(st.equals("=")){
		break;
	}
	if(st.equals("-")){
			s++;
	}
	if(st.equals("+")){
		p++;		
	}
	ar[i]=st.charAt(0);
	i++;
}

int n=scnr.nextInt();
//System.out.println(p+" "+s);
int max=n*p-1*s;
int min=1*p-n*s;
if(n>max){
	System.out.println("Impossible");
	return ;
}
if(n<min){
System.out.println("Impossible");	
return ;
}
double x=n/(p*1.0);
double val=x+(s*1)/(p*1.0);
int b=1;
int cl=0;
while(!(1<=val&&val<=n)){
	b++;
val=x+(s*b)/(p*1.0);
}
int tot=n+b*s;
int plus[]=new int[p];
int va=tot/p;
//System.out.println(tot);
for(int mo=0;mo<p;mo++){
	plus[mo]=va;
}
for(int mo=0;mo<tot%p;mo++){
	plus[mo]++;
}
out.println("Possible");
int pu=0;
out.print(plus[pu]+" ");
pu++;
for(int y=1;y<2*(p+s)-1;y++){
	if(ar[y]=='+'){
		out.print("+"+" "+plus[pu]+" ");
		pu++;
		y++;
	}
	else{
		out.print("-"+" "+b+" ");
		y++;
	}
}
out.print("="+" ");
out.print(n);
out.println();
	




	out.close();
	}


	static class pair implements Comparable<pair> {
		int val;
		int index;

		@Override
		public int compareTo(pair arg0) {
			// TODO Auto-generated method stub
			return -1 * (this.val - arg0.val);
		}
	}

	static class InputReader {

		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;

		public InputReader(InputStream st) {
			this.stream = st;
		}

		public int read() {
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
				res *= 10;
				res += c - '0';
				c = read();
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
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
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

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

	}

}

