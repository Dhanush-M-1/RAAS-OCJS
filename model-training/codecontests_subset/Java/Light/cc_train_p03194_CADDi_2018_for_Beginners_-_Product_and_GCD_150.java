import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.StringTokenizer;

class Main{
	public static void main(String[] args) {
		SC sc=new SC(System.in);
		long N=sc.nextLong();
		long P=sc.nextLong();
		long max=0;
		if(N==1) {
			System.out.println(P);
			System.exit(0);
		}
		else {
			for(long i=1; i<=1000000; i++) {
				long a=np_solve(i,N);
				if(a>=1) {
					if(P%a==0) {
						max=i;
					}
				}
				else if(a<=0) {
					break;
				}
			}
		}
		System.out.println(max);
	}
	static class SC {
		private BufferedReader reader = null;
		private StringTokenizer tokenizer = null;
		public SC(InputStream in) {
			reader = new BufferedReader(new InputStreamReader(in));
		}
		public String next() {
			if (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new UncheckedIOException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
	}
	public static long np_solve(long n,long p) {		//n^p mod m
		long[] amari=new long[50];
		amari[0]=n;
		for(int i=0; i<48; i++) {
			amari[i+1]=amari[i]*amari[i];
		}
		long tmp=p;
		int counter=0;
		long ans=1;
		while(tmp>0) {
			if(tmp%2==1) {
				ans=ans*amari[counter];
				tmp/=2;
				counter++;
			}
			else {
				tmp/=2;
				counter++;
			}
		}
		 return ans;
	}
}