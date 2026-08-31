import java.io.*; 
import java.util.*; 
import java.math.*; 

public class Main {
	static int bs(long[] l,int start,int end,long k) {
		if(end<start) {
			return 1000000000;
		}
		int mid=(start+end)/2;
		if(l[mid]>=k) {
			return Math.min(mid, bs(l,start,mid-1,k));
		}
		else{
			return bs(l,mid+1,end,k);
		}
	}
	
	public static void main(String[] args) throws IOException 
	{ 
		FastScanner f = new FastScanner(); 
		int t=1;
		t=f.nextInt();
		PrintWriter out=new PrintWriter(System.out);
		
		while(t>0) {
			t--;
			int n=f.nextInt();
			int m=f.nextInt();
			long[] l=f.readLongArray(n);
			long[] q=f.readLongArray(m);
			HashMap<Long,Integer> h=new HashMap<>();
//			h.put(0L,0);
			long sum=0;
			long mx=0;
			for(int i=0;i<n;i++) {
				sum+=l[i];
				if(sum>0 && !h.containsKey(sum) && sum>mx) {
					h.put(sum, i);
				}
				mx=Math.max(sum, mx);
			}
			long[] su=new long[h.size()];
			int ind=0;
//			System.out.println(h);
			for(long i:h.keySet()) {
				su[ind]=i;
				ind++;
			}
			sort(su);
//			System.out.println(h);
			long[] ans=new long[m];
			for(int  i=0;i<m;i++) {
				if(sum<=0) {
					int place=bs(su,0,su.length-1,q[i]);
//					System.out.println(place+" "+su[place]);
					if(place<su.length) {
						ans[i]=h.get(su[place]);
					}
					else {
						ans[i]=-1;
					}
				}
				else {
					long rest=q[i]-mx;
					long curr=Math.max(0,((rest+sum-1)/sum)*sum);
					long find=Math.max(0,q[i]-curr);
//					System.out.println(i+" "+find+" "+ ((rest+sum-1)/sum));
					int place=bs(su,0,su.length-1,find);
//					System.out.println(place+" "+su[place]);
					ans[i]=Math.max(0,((rest+sum-1)/sum)*n)+h.get(su[place]);
				}
			}
			for(int i=0;i<m;i++) {
				out.print(ans[i]+" ");
			}
			out.println();
			
		}
		out.close();
	} 
	static void sort(long [] a) {
        ArrayList<Long> q = new ArrayList<>();
        for (long i: a) q.add(i);
        Collections.sort(q);
        for (int i = 0; i < a.length; i++) a[i] = q.get(i);
    }
    
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		long[] readLongArray(int n) {
			long[] a=new long[n];
			for (int i=0; i<n; i++) a[i]=nextLong();
			return a;
		}
	}
} 	