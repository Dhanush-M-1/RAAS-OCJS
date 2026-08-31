import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


public class Xoniccai {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input =new Scanner(System.in);
		int t = input.nextInt();
		while(t-->0){
			long a = input.nextInt();
			long b = input.nextInt();
			int n = input.nextInt();
			
			if(n%3==2){
				System.out.println(a^b);
			}
			else if(n%3==1){
				System.out.println(b);
			}
			else
				System.out.println(a);
			
		}
		
	}

	static class Scanner {
		Scanner(InputStream in) { this.in = in; } InputStream in;
		int k, l; byte[] bb = new byte[1 << 15];
		byte getc() {
			if (k >= l) {
				k = 0;
				try { l = in.read(bb); } catch (IOException e) { l = 0; }
				if (l <= 0) return -1;
			}
			return bb[k++];
		}
		int nextInt() {
			byte c = 0; while (c <= 32) c = getc();
			int a = 0;
			while (c > 32) { a = a * 10 + c - '0'; c = getc(); }
			return a;
		}
		int m = 1 << 7; byte[] cc = new byte[m];
		int read() {
			byte c = 0; while (c <= 32) c = getc();
			int n = 0;
			while (c > 32) {
				if (n == m) cc = Arrays.copyOf(cc, m <<= 1);
				cc[n++] = c; c = getc();
			}
			return n;
		}
		byte[] nextBytes() { int n = read(); return Arrays.copyOf(cc, n); }
	}
}
