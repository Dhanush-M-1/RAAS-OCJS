import java.util.*;
import java.io.*;
 
public class Main2 {
	static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
        public FastReader(){br = new BufferedReader(new InputStreamReader(System.in));}
        String next(){while (st == null || !st.hasMoreElements()){try{st = new StringTokenizer(br.readLine());} 
        catch (IOException  e){e.printStackTrace();}}return st.nextToken();}
        int nextInt(){ return Integer.parseInt(next());}long nextLong(){return Long.parseLong(next());}double nextDouble(){return Double.parseDouble(next());}
        String nextLine(){String str = ""; try{str = br.readLine(); } catch (IOException e) {e.printStackTrace();} return str; } 
    }
	static long mod = (long)(1e9+7);
//	static long mod = 998244353;
//	static Scanner sc = new Scanner(System.in);
	static FastReader sc = new FastReader();
	static PrintWriter out = new PrintWriter(System.out);
	static pair a[];
	static pair dp[][];
	public static void main (String[] args) {
		int t = 1;
//    	t = sc.nextInt();
	    z : for(int tc=1;tc<=t;tc++) {
	    	int n = sc.nextInt();
	    	a = new pair[n];
	    	int sum = 0;
	    	for(int i=0;i<n;i++) {
	    		a[i] = new pair(0,0);
	    		a[i].a = sc.nextInt();
	    		sum += a[i].a;
	    	}
	    	for(int i=0;i<n;i++) {
	    		a[i].b = sc.nextInt();
	    	}
	    	Arrays.sort(a,new Comparator<pair>() {

				@Override
				public int compare(pair o1, pair o2) {
					return o2.a - o1.a;
				}
	    		
	    	});
	    	dp = new pair[n][sum+1];
	    	pair ans = find(0,sum);
	    	out.write(ans.a+" "+ans.b);
	    }
		out.close();
	}
	private static pair find(int i, int sum) {
		if(i == a.length) {
			if(sum == 0) return new pair(0,0);
			return new pair((int)(1e6),(int)(1e6));
		}
		
		if(dp[i][sum] != null) return dp[i][sum];
		
		int tsum = sum;
		if(tsum>=a[i].a) tsum -= a[i].a;
		else tsum = 0;
		int eadd = Math.min(tsum, a[i].b-a[i].a);
		tsum -= eadd;
		pair resss1 = find(i+1,tsum);
		pair res1 = new pair(resss1.a + 1, resss1.b + eadd);
		
		pair res2 = find(i+1,sum);
		pair res3 = find(i+1,Math.max(0, sum-a[i].a));
		res3 = new pair(res3.a+1,res3.b);
		
		pair ret;
		if(res1.isGreater(res2) && res1.isGreater(res3)) ret = res1;
		else if(res2.isGreater(res1) && res2.isGreater(res3)) ret = res2;
		else ret = res3;
//		System.out.println("i "+i+" sum "+sum+" ret.a "+ret.a+" ret.b "+ret.b);
		return dp[i][sum] = ret;
	}
	private static void sort(int[] a) {List<Integer> k = new ArrayList<>();for(int val : a) k.add(val);Collections.sort(k);for(int i=0;i<a.length;i++) a[i] = k.get(i);}
	private static void ini(List<Integer>[] tre2){for(int i=0;i<tre2.length;i++){tre2[i] = new ArrayList<>();}}
	private static void init(List<int[]>[] tre2){for(int i=0;i<tre2.length;i++){tre2[i] = new ArrayList<>();}}
	private static void sort(long[] a) {List<Long> k = new ArrayList<>();for(long val : a) k.add(val);Collections.sort(k);for(int i=0;i<a.length;i++) a[i] = k.get(i);}
}
class pair{
	int a;
	int b;
	pair(int val,int came){
		this.a = val;
		this.b = came;
	}
	boolean isGreater(pair p) {
		if(this.a!=p.a) return this.a<p.a;
		return this.b<=p.b;
	}
}