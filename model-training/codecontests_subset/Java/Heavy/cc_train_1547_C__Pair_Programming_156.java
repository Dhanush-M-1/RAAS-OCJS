import java.util.*;
import java.io.*;

public class Template {
	// remember long, to reformat ctrl + shift +f

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
        int t=sc.nextInt();
        for(int tests=0;tests<t;tests++) {
          int k=sc.nextInt();
          int n=sc.nextInt();
          int m=sc.nextInt();
          int []arr1=sc.nextIntArray(n);
          int arr2[]=sc.nextIntArray(m);
          int idxm=0;
          int idxn=0;
          boolean cant=false;
        		  
          ArrayList<Integer>arr=new ArrayList<>();
          while(idxn!=n || idxm!=m) {
        	  int tempm=idxm; int tempn=idxn;
        	  while( idxn<n && arr1[idxn]<=k) {
        		  arr.add(arr1[idxn]);
        		  if(arr1[idxn]==0)k++;
        		  idxn++;
        	  }
        	  while(idxm <m && arr2[idxm]<=k) {
        		  arr.add(arr2[idxm]);
        		  if(arr2[idxm]==0)k++;
        		  idxm++;
        	  }
        	  if(tempn==idxn && tempm==idxm) {
        		  pw.println(-1);
        		  cant=true;
        		  break;
        	  }
          }
          if(!cant) {
        	  for(int i=0;i<n+m;i++) {
        		  pw.print(arr.get(i)+" ");
        	  }
        	  pw.println();
          }
          
        		  
        	
        }
		pw.close();

	}

	// --------------------stuff ----------------------
	static class pair implements Comparable<pair> {
		int v;
		int w;

		public pair(int v, int w) {
			this.v = v;
			this.w = w;
		}

		public int compareTo(pair p) {
			return this.v - p.v;// increasing order!!
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
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
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public long[] nextlongArray(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public Long[] nextLongArray(int n) throws IOException {
			Long[] a = new Long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public Integer[] nextIntegerArray(int n) throws IOException {
			Integer[] a = new Integer[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}

}