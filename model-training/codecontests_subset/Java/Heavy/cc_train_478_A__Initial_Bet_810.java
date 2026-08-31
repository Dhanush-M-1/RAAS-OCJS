import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class A {
	static InputReader in;
	static PrintWriter out;
	public static void main(String[] args) throws Exception {
		in = new InputReader(System.in);
		out = new PrintWriter(System.out);
		
		int output =-1;
		int[] arr= new int[5];
		for(int input =0;input<arr.length;input++)
		{
			arr[input] = in.nextInt();
		}	
		for(int m = 0 ;m<arr.length;){
			int max =arr[m];
			int min =arr[m];
			int maxIndex =0;
			int minIndex = 0;
			int value = arr[m];
			boolean isSame = true;

			for(int i =0;i<arr.length;i++){
				if(arr[i]>max){
					max =arr[i]; 
					maxIndex = i;
				}
				if(arr[i]<min){
					min =arr[i]; 
					minIndex =i; 
				}
				if(value != arr[i]){
					isSame = false;
				}


			}
			if(isSame){
				output =(arr[0]==0)?-1:arr[0];
			}
			if((arr[maxIndex] - arr[minIndex])> 1){
				arr[maxIndex] = arr[maxIndex] -1;
				arr[minIndex] = arr[minIndex] +1;
			}else{
				break;
			}

		}
		out.println(output);
		
		out.close();
	}
	
	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}
		
		
		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
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
		

		public String nextToken() {
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

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return isWhitespace(c);
		}

		public static boolean isWhitespace(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}