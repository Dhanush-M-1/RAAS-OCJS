import java.io.*;
import java.util.*;

public class  zz{
	static int mod=(int)1e9+7;
	static long in1[];
	static long in2[];
	static long [][]memo;
	static long dp(int i,int prev) {
		if(i==in1.length)return 0;
		if(memo[i][prev]!=-1)return memo[i][prev];
		if(prev==0) {
			return memo[i][prev]=Math.max(in1[i]+dp(i+1,1),Math.max(in2[i]+dp(i+1,2),dp(i+1,0)));
		}
		if(prev==1) {
			return memo[i][prev]=Math.max(in2[i]+dp(i+1,2),dp(i+1,0));
		}
		return memo[i][prev]=Math.max(in1[i]+dp(i+1,1),dp(i+1,0));
	}
    public static void main(String[] args) throws Exception{
        //MScanner sc = new MScanner("chess.in");
        MScanner sc = new MScanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        int n=sc.nextInt();
        int[]numd=new int[11];
        in1=new long[n];for(int i=0;i<n;i++) {
        	in1[i]=sc.nextInt();
        	long x=in1[i];
            int dig=0;
            while(x>0) {
            	x/=10;dig++;
            }
            numd[dig]++;
        }
        
        long ans=0;
        long mo=998244353;
        for(int i=0;i<n;i++) {
        	long x=in1[i];
            int dig=0;
            while(x>0) {
            	x/=10;dig++;
            }
            long greater=numd[dig];
            for(int j=dig+1;j<11;j++) {
            	greater+=numd[j];
            }
            for(int j=1;dig-j>=0;j++) {
            	if(numd[dig-j]>0) {
	            	long o=in1[i];
	            	long base=1;
	            	for(int oo=0;oo<dig-j;oo++) {
	            		long z=o%10;
	            		long zzz=(z*base+z*base*10)%mo;
	            		long inc=(numd[dig-j]*zzz)%mo;
	            		ans=(ans+inc)%mo;
	            		base=(base*100)%mo;
	            		o/=10;
	            	}
	            	while(o>0) {
	            		//System.out.println(base);
	            		long z=o%10;
	            		long zz=(2*z*base)%mo;
	            		long inc=(zz*numd[dig-j])%mo;
	            		ans=(ans+inc)%mo;
	            		base=(base*10)%mo;
	            		o/=10;
	            	}
            	}
            }
        	long o=in1[i];
        	long base=1;
        	while(o>0) {
        		long z=o%10;
        		long zzz=(z*base+z*base*10)%mo;
        		long inc=(greater*zzz)%mo;
        		ans=(ans+inc)%mo;
        		base=(base*100)%mo;
        		o/=10;
        	}
        }
        pw.println(ans);
        pw.flush();
    }
    static class pair implements Comparable<pair>{
    	String t;int d;int idx;
    	pair(String x,int y,int i){
    		t=x;d=y;idx=i;
    	}
    	@Override
    	public int compareTo(pair o) {
    		if(t.compareTo(o.t)!=0) {
    			return t.compareTo(o.t);
    		}
    		return o.d-d;
    	}
    	 
    	public boolean equals(pair o) {
    		if(this.compareTo(o)==0)return true;
    		return false;
    	}
    	public String toString() {
    		return "("+t+" "+d+")";
    	}
    }
    static class MScanner {
		StringTokenizer st;
		BufferedReader br;
 
		public MScanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}
 
		public MScanner(String file) throws Exception {
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