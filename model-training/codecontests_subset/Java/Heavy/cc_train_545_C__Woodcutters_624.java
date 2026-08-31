import java.util.*;
import java.io.*;  
 
public class Solution{
    // public static class pair{
    //     int x;
    //     int y;
    // }
    public static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
        public String next() {
			while (st == null || !st.hasMoreElements())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) {
				a[i]=nextInt();
			}
			return a;
		}public double nextDouble() {
			return Double.parseDouble(next());
		}
    }
    public static class pair{
        int x;
        int y;
        public pair(int a,int b,int c){
            x=a;
            y=b;
        }
    }
    static long[] fac=fact();
    static long[] fact(){
        long[] fac = new long[200001];
        fac[0] = (long)1;
        for (int i = 1; i < (int)fac.length; i++){
            fac[i] = (fac[i - 1] * i) % 1000000007;
        }
        return fac;
    }
    public static void main(String[] args) throws IOException{
        FastScanner fs=new FastScanner();
		int t=1;//fs.nextInt();
		PrintWriter out=new PrintWriter(System.out);
		while(t-->0){
		    int n=fs.nextInt();
		    int[] x=new int[n];
		    int[] h=new int[n];
		    for(int i=0;i<n;i++){
		        x[i]=fs.nextInt();
		        h[i]=fs.nextInt();
		    }
		    if(n==1 || n==2){
		        System.out.println(n);
		        continue;
		    }
		    int trees=2;
		    int l=x[0];
		    for(int i=1;i<n-1;i++){
		        if(x[i]-l>h[i]){
		            trees++;
		            l=x[i];
		        }else if(x[i+1]-x[i]>h[i]){
		            trees++;
		            l=x[i]+h[i];
		        }else{
		            l=x[i];
		        }
		    }
		    System.out.println(trees);
		}
        out.close();
    }
    public static long gcdFind(long[] arr){
        long result = (long)0; 
        for (long element: arr){ 
            result = gcd(result, element);
  
            if(result == (long)1) 
            { 
               return 1; 
            } 
        } 
        return result;
    }
    public static int dfs(int in,ArrayList<Integer>[] adj,HashSet<Integer> set,HashMap<Integer,Integer> vis){
        if(vis.containsKey(in)){
            return 1;
        }
        if(set.contains(in)){
            return 0;
        }
        vis.put(in,1);
        ArrayList<Integer> l=adj[in-1];
        if(l.size()==0){
            return 2;
        }
        return dfs(l.get(0),adj,set,vis);
    }
    public static boolean check(long n){
        String s=n+"";
        HashMap<Integer,Integer> set=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'){
                set.put(s.charAt(i)-'0',1);
            }
        }
        for(int key:set.keySet()){
            if(n%key!=0){
                return false;
            }
        }
        return true;
    }
    public static void sort(long[] array){
		ArrayList<Long> copy = new ArrayList<Long>();
		for (long i : array)
			copy.add(i);
		Collections.sort(copy);
		for(int i = 0;i<array.length;i++)
			array[i] = copy.get(i);
	}
    static long power(long x, long y, long p){
        long res = 1;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }
    public static long modInverse(long n, long p){
        return power(n, p - 2, p);
    }
    public static long nCr(long n, long r,long p){
        if (n<r) 
              return (long)0;
        if (r == 0)
            return (long)1;
        return (fac[(int)n] * modInverse(fac[(int)r], p)% p * modInverse(fac[(int)(n - r)], p)% p)% p;
    }public static int upp(int[] arr,int v){
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int m=(low+high)/2;
            if(arr[m]<v){
                ans=m;
                low=m+1;
            }else{
                high=m-1;
            }
        }
        return ans+1;
    }
    public static int low(int[] arr,int v){
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int m=(low+high)/2;
            if(arr[m]>v){
                ans=m;
                high=m-1;
            }else{
                low=m+1;
            }
        }
        if(ans==-1){
            return 0;
        }
        return arr.length-ans;
    }
    public static class Comp implements Comparator<pair>{
        public int compare(pair a,pair b){
            if(a.x!=b.x){
                return a.x-b.x;
            }else{
                return a.y-b.y;
            }
        }
    }
    public static long gcd(long a,long b){
        if (b == 0) 
        return a; 
        return gcd(b, a % b);
    }
    public static int lcm(int a,int b){
        int x=Math.max(a,b);
        int y=Math.min(a,b);
        long ans=x;
        while(ans%y!=0){
            ans+=x;
        }
        if(ans>Integer.MAX_VALUE){
            return -1;
        }
        return (int)ans;
    }
    public static long fact(int n){
        long ans=1;
        for(int i=1;i<=n;i++){
            ans*=i;
        }
        return ans;
    }
}