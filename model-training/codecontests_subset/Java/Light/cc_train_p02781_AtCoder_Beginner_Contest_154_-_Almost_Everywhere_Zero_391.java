import java.io.*;
import java.util.*;
import java.math.*;

 
 public class Main	{
   static class Pair implements Comparable<Pair>{
   int a;
   int b;
   public Pair(int x,int y){a=x;b=y;}
   public Pair(){}
   public int compareTo(Pair p){
	 return p.a - a;
   }



 }
static class TrieNode{
  TrieNode[]child;
  int w;
  boolean term;
  TrieNode(){
    child = new TrieNode[26];  
  }
}
  public static int gcd(int a,int b)
  {
    if(a<b)

      return gcd(b,a);
    if(b==0)
      return a;
    return gcd(b,a%b);
    
  }
  //static long ans = 0;
  static long mod = 998244353;/// (long)(1e9+7); 
   
    public static void main(String[] args) throws Exception {
       new Thread(null, null, "Anshum Gupta", 99999999) {
            public void run() {
                try {
                    solve();
                } catch(Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

static long pow(long x,long y){
    if(y == 0)return 1;
    if(y==1)return x;
    long a = pow(x,y/2);
    a = (a*a)%mod;
    if(y%2==0){
        return a;
    }
    return (a*x)%mod;
}

static long mxx;
static int mxN = (int)(1e6+5);
static long[]fact,inv_fact;
static long my_inv(long a) {
	return pow(a,mod-2);
}
static long bin(int a,int b) {
	if(b>a)return 0;
    return ((fact[a]*inv_fact[a-b])%mod * inv_fact[b])%mod;
}
static String str;
static int n,k;
static long[][][]dp;
static long rec(int i,boolean term,int cnt) {
	if(cnt > k)return 0;
	if(i == n) {
		if(cnt == k)return 1;
		return 0;
	}
	if(dp[i][term ? 1:0][cnt] != -1)return dp[i][term ? 1:0][cnt];
	long ans = 0;
	if(term) {
	    	if(str.charAt(i) == '0') ans += rec(i+1,true,cnt);
	    	else {
	    		ans += rec(i+1,false,cnt);
	    		for(int j=1;j<str.charAt(i) - '0';j++)ans += rec(i+1,false,cnt+1);
	    		ans += rec(i+1,true,cnt+1);
	    	}
	}
	else {
		ans += rec(i+1,false,cnt);
		for(int j=1;j<=9;j++)ans +=rec(i+1,false,cnt+1);
	}
	return dp[i][term ? 1:0][cnt] = ans;
}
 public static void solve() throws Exception {
   // solve the problem here
   MyScanner s = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int tc = 1;//s.nextInt();
        mxx = (long)(1e18+5);
 
        while(tc-->0){
        	str = s.next();
        	n = str.length();
        	k = s.nextInt();
        	dp = new long[n][2][k+1];
        	for(int i=0;i<n;i++)
        		for(int j=0;j<2;j++)
        			Arrays.fill(dp[i][j], -1);
        	long val = rec(0,true,0);
        	out.println(val);
        }
        
           
        out.flush();
}
 
     
 
 
 
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
 
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
         
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    //--------------------------------------------------------
}
