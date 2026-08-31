
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class COVID {




	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw =new PrintWriter(System.out);
		int t= sc.nextInt();
		a:	while(t-->0) {
			int n= sc.nextInt();
			long l=sc.nextLong();
			long r= sc.nextLong();
			long c=0;
			int nc=1;
			StringBuilder sb= new StringBuilder();
			int i;
			for( i=1;i<n;i++) {
				if(2*(n-i)>=l)break;
				l-=2*(n-i);
				r-=2*(n-i);
			
			}
		all:for(;i<n;i++) {
			for(int j=i+1;j<=n;j++) {
				c++;
				if(c>=l&&c<=r) {
				sb.append(i+" ");
				}
				c++;
				if(c>=l&&c<=r)
				sb.append(j+" ");
				if(c>r)break all;
			}
		}
			c++;
			if(c>=l&&c<=r)
			sb.append("1 ");
			
			l--;
		pw.println(sb.toString());

		

	}	
	pw.flush();

}
	static long maximumSum(long[] a, long m) {
		long sum=0;
		long acc[] =new long[a.length];
		
		for(int i=0;i<a.length;i++) 
		acc[i]=(int)((a[i]%m + ((i!=0)?acc[i-1]:0))%m);
		
		TreeSet<Long> set= new TreeSet();
		long min=m;
		for(int i=0;i<acc.length;i++) {
			set.add(acc[i]);
			Long upper=set.ceiling(acc[i]+1);
			if(upper==null) continue;
			min=Math.min(min, upper-acc[i]);
			
		}
		return((m-min));
		

    }

static class Pair implements Comparable<Pair>{
	long  x;int y,z;
	public Pair(long a,int b, int c) {
		this.x=a;y=b;this.z=c;
	}


	public int compareTo(Pair o) {
		//return (this.x==o.x)?(this.y==o.y)?z-o.z:this.y-o.y:this.x-o.x;
		return this.x>o.x?1:(this.x<o.x)?-1:0;
	}

}




static class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s) {
		br = new BufferedReader(new InputStreamReader(s));
	}
	public Scanner(String s) throws FileNotFoundException{	br = new BufferedReader(new FileReader(s));}


	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine()," ,");
		return st.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	public String nextLine() throws IOException {
		return br.readLine();
	}


	public double nextDouble() throws IOException {
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if (x.charAt(0) == '-') {
			neg = true;
			start++;
		}
		for (int i = start; i < x.length(); i++) {
			if (x.charAt(i) == '.') {
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			} else {
				sb.append(x.charAt(i));
				if (dec)
					f *= 10;
			}
			if (sb.length() == 18) {
				res += Long.parseLong(sb.toString()) / f;
				sb = new StringBuilder("0");
			}
		}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg ? -1 : 1);
	}

	public boolean ready() throws IOException {
		return br.ready();
	}

}

public static void shuffle(int[] a) {
	int n = a.length;
	for (int i = 0; i < n; i++) {
		int r = i + (int) (Math.random() * (n - i));
		int tmp = a[i];
		a[i] = a[r];
		a[r] = tmp;
	}
}
}
