import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
public class hacker49 {
	public static int r1=0;
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	static HashMap<Long,Integer> e=new HashMap<>();
	public static void main(String[] args) {
		OutputStream outputStream =System.out;
	    PrintWriter out =new PrintWriter(outputStream);
		FastReader s=new FastReader();
   int n=s.nextInt();
   long[] x=new long[n+1];
   long[] h=new long[n+1];
   for(int i=1;i<=n;i++) {
	   x[i]=s.nextLong();
	   h[i]=s.nextLong();
   }
	long[][] dp=new long[n+1][3];
	dp[1][0]=0;
	dp[1][1]=1;
	if(n>1) {
	if(x[1]+h[1]<x[2]) {
		dp[1][2]=1;
	}else {
		dp[1][2]=0;
	}
}
	for(int i=2;i<=n;i++) {
		dp[i][0]=Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
		if(x[i]-h[i]<=x[i-1]) {
			dp[i][1]=Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
		}else {
			dp[i][1]=Math.max(dp[i-1][0]+1, dp[i-1][1]+1);
			if(x[i-1]+h[i-1]<x[i]-h[i]) {
				dp[i][1]=Math.max(dp[i][1], dp[i-1][2]+1);
			}
			
		}
		if(i!=n) {
			if(x[i]+h[i]<x[i+1]) {
				dp[i][2]=Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][1]))+1;
			}else {
				dp[i][2]=Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][1]));
			}
		}else {
			dp[i][2]=Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][1]))+1;
			
		}
		
	}
	out.println(Math.max(dp[n][1], Math.max(dp[n][0],dp[n][2])));
	
	
	
		out.close();       
	}
	
	
	static int nextPowerOf2(int n) 
	{ 
	    n--; 
	    n |= n >> 1; 
	    n |= n >> 2; 
	    n |= n >> 4; 
	    n |= n >> 8; 
	    n |= n >> 16; 
	    n++; 
	      
	    return n; 
	} 
//	static class node{
//		private int a;
//		private int b;
//		private int c;
//		private int d;
//		
//	}
	
	
	public static class node{
		private int a;
		private int b;
		node(int a,int b){
			this.a=a;
			this.b=b;
		}
	}

	public static long GCD(long a,long b) {
		if(b==(long)0) {
			return a;
		}
		return GCD(b , a%b);
	}
	public static void Create(node[] arr,node[] segtree,int low,int high,int pos) {
		if(low==high) {
			segtree[pos]=arr[low];
			return;
		}
		int mid=(low+high)/2;
		Create(arr,segtree,low,mid,2*pos+1);
		Create(arr,segtree,mid+1,high,2*pos+2);
		if(segtree[2*pos+1].a+segtree[2*pos+2].a>=10) {
			int a=segtree[2*pos+1].a;
			int b=segtree[2*pos+2].a;
			int c=segtree[2*pos+1].b;
			int d=segtree[2*pos+2].b;
			segtree[pos]=new node((a+b)%10,1+c+d);
		}else {
			int a=segtree[2*pos+1].a;
			int b=segtree[2*pos+2].a;
			int c=segtree[2*pos+1].b;
			int d=segtree[2*pos+2].b;
			segtree[pos]=new node(a+b,c+d);
			
		}
	}
	public static node Query(node[] segtree,int qlow,int qhigh,int low,int high,int pos) {
		if(low>=qlow && high<=qhigh) {
			return segtree[pos];
		}
		if(qhigh<low || qlow>high) {
			return new node(0,0);
		}
		int mid=(low+high)/2;
	 node a=Query(segtree,qlow,qhigh,low,mid,2*pos+1);
	node b=Query(segtree,qlow,qhigh,mid+1,high,2*pos+2);
	int c=a.a;
	int d=b.a;
	if(c+d>=10) {
	node e=new node((c+d)%10,1+a.b+b.b);
	return e;
	}else {
		node e=new node(c+d,a.b+b.b);
		return e;
	}
	}
	
	static class pair1 implements Comparable<pair1>{
		private int a;
		private int b;
		private int c;
		private int d;
		pair1(int a,int b,int c,int d){
			this.a=a;
			this.b=b;
			this.c=c;
			this.d=d;
		}
		public int compareTo(pair1 o) {
			if(this.a<o.a) {
				return 1;
			}else if(this.a==o.a) {
				if(this.b<o.b) {
					return 1;
				}else {
					return -1;
				}
			}else {
				return -1;
			}
				
		}
	}
//	public static class pair5{
//		private int a;
//		private int b;
//		pair5(int a,int b){
//			this.a=a;
//			this.b=b;
//		}
//		public int compareTo(pair5 o) {
//			return Integer.compare(o.b, this.b);
//		}
//	}
//	public static pair5[] merge_sort(pair5[] A, int start, int end) {
//		if (end > start) {
//			int mid = (end + start) / 2;
//			pair5[] v = merge_sort(A, start, mid);
//			pair5[] o = merge_sort(A, mid + 1, end);
//			return (merge(v, o));
//		} else {
//			pair5[] y = new pair5[1];
//			y[0] = A[start];
//			return y;
//		}
//	}
//	public static pair5[] merge(pair5 a[], pair5 b[]) {
////		int count=0;
//		pair5[] temp = new pair5[a.length + b.length];
//		int m = a.length;
//		int n = b.length;
//		int i = 0;
//		int j = 0;
//		int c = 0;
//		while (i < m && j < n) {
//			if (a[i].a < b[j].a) {
//				temp[c++] = a[i++];
//			} else {
//				temp[c++] = b[j++];
//			}
//		}
//		while (i < m) {
//			temp[c++] = a[i++];
//		}
//		while (j < n) {
//			temp[c++] = b[j++];
//		}
//		return temp;
//	}
////	
	public static int upper_bound(int[] a ,int n,int x) {
		int l=-1;
		int r=n;
		while(r>l+1) {
			int mid=(l+r)/2;
			if(a[mid]<x) {
				l=mid;
			}else {
				r=mid;
			}
		}
		return r;
				
	}

//	
//	
	public static int lower_bound(int[] a ,int n,int x) {
		int l=-1;
		int r=n;
		while(r>l+1) {
			int mid=(l+r)/2;
			if(a[mid]<=x) {
				l=mid;
			}else {
				r=mid;
			}
		}
		return l;
				
	}
	public static int ty(int[] a, int x, int y)
    {
        Arrays.sort(a);
        int count=0;
        int n=a.length;
        for(int i=0;i<n;i++) {
        	int g=0;
        	if(x%a[i]==0) {
        		g=x/a[i];
        	}else {
        		g=x/a[i]+1;
        	}
        	int k1=upper_bound(a,n,g);
        	if(k1==n) {
        		count+=0;
        	}else {
        		int g1=0;
            	if(y%a[i]==0) {
            		g1=y/a[i];
            	}else {
            		g1=y/a[i]+1;
            	}
            	int k2=lower_bound(a,n,g1);
            	if(k2>=k1) {
            		count+=(k2-k1+1);
            	}
        	}
//        System.out.println(count);
        }
        return count;
        
    }
	static boolean isValid(int x,int y,int n,int m) {
		if(x>=1 && x<=n && y>=1 && y<=m) {
			return true;
		}else {
			return false;
		}
	}
	
	static long[] fac=new long[1000001];
	static void fac() {
		fac[0]=1;
		for(int i=1;i<=1000000;i++) {
//			fac[i]=((fac[i-1]%mod)*(i%mod))%mod;
		}
	}
	static ArrayList<Integer>[] f=new ArrayList[2001];
	public static void init(int n) {
		
		for(int j=1;j<=n;j++) {
		for (int l=1; l<=Math.sqrt(j); l++)
        {
            if (j%l==0)
            {
                // If divisors are equal, print only one
                if (j/l == l) {
                    f[j].add(l);}
      
                else { // Otherwise print both
//                    System.out.print(i+" " + n/i + " " );
            f[j].add(l);
            f[j].add(j/l);
                }
                
            }
        }
		
		}
		
	}
	
	public static long[] merge_sort(long[] A, int start, int end) {
		if (end > start) {
			int mid = (end + start) / 2;
			long[] v = merge_sort(A, start, mid);
			long[] o = merge_sort(A, mid + 1, end);
			return (merge(v, o));
		} else {
			long[] y = new long[1];
			y[0] = A[start];
			return y;
		}
	}
	public static long[] merge(long a[], long b[]) {
//		int count=0;
		long[] temp = new long[a.length + b.length];
		int m = a.length;
		int n = b.length;
		int i = 0;
		int j = 0;
		int c = 0;
		while (i < m && j < n) {
			if (a[i] < b[j]) {
				temp[c++] = a[i++];
			
			} else {
				temp[c++] = b[j++];
			}
		}
		while (i < m) {
			temp[c++] = a[i++];
		}
		while (j < n) {
			temp[c++] = b[j++];
		}
		return temp;
	}
	
	public static long[] merge_sort1(long[] A, int start, int end) {
		if (end > start) {
			int mid = (end + start) / 2;
			long[] v = merge_sort1(A, start, mid);
			long[] o = merge_sort1(A, mid + 1, end);
			return (merge1(v, o));
		} else {
			long[] y = new long[1];
			y[0] = A[start];
			return y;
		}
	}
	public static long[] merge1(long a[], long b[]) {
//		int count=0;
		long[] temp = new long[a.length + b.length];
		int m = a.length;
		int n = b.length;
		int i = 0;
		int j = 0;
		int c = 0;
		while (i < m && j < n) {
			if (a[i] < b[j]) {
				temp[c++] = a[i++];
			
			} else {
				temp[c++] = b[j++];
			}
		}
		while (i < m) {
			temp[c++] = a[i++];
		}
		while (j < n) {
			temp[c++] = b[j++];
		}
		return temp;
	}
	
	static long MOD=1000000007;
	static class pair2{
		private long a;
		private int b;
		pair2(long a,int b){
			this.a=a;
			this.b=b;
		}
	}
	




//	for(int i=2;i<=100000;i++) {
		
	
}