import java.io.*;
import java.util.*;

public class tr2 {
	static PrintWriter out;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		int n=sc.nextInt();
		double []a=new double [n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextDouble();
		double lo=-40000;
		double hi=40000;
		double eps = 1e-11;
		double ans=0;
		while(hi-lo>eps) {
			double x1=lo+(hi-lo)/3;
			double x2=hi-(hi-lo)/3;
			double []b1=a.clone();
			double []b2=a.clone();
			for(int i=0;i<n;i++)
				b1[i]-=x1;
			for(int i=0;i<n;i++)
				b2[i]-=x2;
			double a1=trr(b1);
			double a2=trr(b2);
			if(a1<a2) {
				hi=x2;
			}
			else if(a2<=a1) {
				lo=x1;
			}
			ans=a1;
		//	System.out.println(lo+" "+hi);
		}
		out.print(ans);
		out.flush();
	}

	 static double trr(double []a) {
		  double res = 0;
		    double min = 0, max = 0, sum = 0;
		    for(int i =0 ; i<a.length; i++)
		    {
		        sum += a[i];
		        res = Math.max(res, Math.max(max-sum, sum-min));
		        min = Math.min(min, sum);
		        max = Math.max(max, sum);
		    }
		    return res;
	 }
    static double maxSum(double []a) {
    	double ans=0;
    	for(int i=0;i<a.length;i++) {
    		double sum=0;
    		if(a[i]>=0) {
    			while(i<a.length && a[i] >=0) {
    				sum+=a[i];
    				i++;
    			}
    			i--;
    		}
    		else {
    			while(i<a.length && a[i] <0) {
    				sum+=a[i];
    				i++;
    			}
    			sum*=-1;
    			i--;
    		}
    		ans=Math.max(sum, ans);
    	}
    	return ans;
    }
    static double maxSum1(double []a) {
    	double ans=0;
    	for(int i=0;i<a.length;i++) {
    		double sum=0;
    		if(a[i]>0) {
    			while(i<a.length && a[i] >0) {
    				sum+=a[i];
    				i++;
    			}
    			i--;
    		}
    		else {
    			while(i<a.length && a[i] <=0) {
    				sum+=a[i];
    				i++;
    			}
    			sum*=-1;
    			i--;
    		}
    		ans=Math.max(sum, ans);
    	}
    	return ans;
    }
	static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	static class unionfind {
		int[] p;
		int[] size;

		unionfind(int n) {
			p = new int[n];
			size = new int[n];

			for (int i = 0; i < n; i++) {
				p[i] = i;
			}
			Arrays.fill(size, 1);
		}

		int findSet(int v) {
			if (v == p[v])
				return v;
			return p[v] = findSet(p[v]);
		}

		boolean sameSet(int a, int b) {
			a = findSet(a);
			b = findSet(b);
			if (a == b)
				return true;
			return false;
		}

		int max() {
			int max = 0;
			for (int i = 0; i < size.length; i++)
				if (size[i] > max)
					max = size[i];
			return max;
		}

		void combine(int a, int b) {
			a = findSet(a);
			b = findSet(b);
			if (a == b)
				return;
			if (size[a] > size[b]) {
				p[b] = a;
				size[a] += size[b];

			} else {
				p[a] = b;
				size[b] += size[a];
			}
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}