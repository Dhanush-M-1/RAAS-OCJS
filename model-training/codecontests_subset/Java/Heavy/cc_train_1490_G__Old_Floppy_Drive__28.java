import java.io.*;
import java.util.*;

public class Main{
    static void main() throws Exception{
    	int n=sc.nextInt(),m=sc.nextInt();
    	long[]in=sc.longArr(n);
    	long[][]qs=new long[m][];
    	for(int i=0;i<m;i++)qs[i]=new long[] {sc.nextInt(),i};
    	Arrays.sort(qs,(x,y)->Long.compare(x[0], y[0]));
    	long[]ans=new long[m];
    	long sum=0;
    	long maxPref=0;
    	int idx=0;
    	for(int i=0;i<n;i++) {
    		sum+=in[i];
    		while(idx<m && qs[idx][0]<=sum) {
    			ans[(int)qs[idx++][1]]=i;
    		}
    		maxPref=Math.max(maxPref, sum);
    	}
//    	System.out.println(maxPref+" "+ans[1]);
    	if(sum>0) {
    		int tmp=idx;
	    	while(idx<m) {
	    		long wanted=qs[idx][0]-maxPref;
	    		if(wanted<=0) {
	    			throw new Exception("zzz");
	    		}
	    		qs[idx][0]-=((wanted+sum-1)/sum)*sum;
	    		ans[(int)qs[idx++][1]]=((wanted+sum-1)/sum)*n;
//	    		System.out.println(ans[(int)qs[idx-1][1]]+" "+qs[idx-1][0]+" "+wanted+" "+idx+" "+sum);
	    	}
	    	idx=tmp;
	    	for(int j=0;j<idx;j++) {
	    		qs[j][0]=-10000000;
	    	}
	    	Arrays.sort(qs,(x,y)->Long.compare(x[0], y[0]));
	    	sum=0;
	    	for(int i=0;i<n;i++) {
	    		sum+=in[i];
	    		while(idx<m && qs[idx][0]<=sum) {
	    			ans[(int)qs[idx++][1]]+=i;
	    		}
	    	}
	    	if(idx!=m)throw new Exception("ezay??");
    	}
    	else {
    		while(idx<m) {
    			ans[(int)qs[idx++][1]]=-1;
    		}
    	}
    	for(int i=0;i<m;i++) {
    		pw.print(ans[i]+" ");
    	}
    	pw.println();
    }
    public static void main(String[] args) throws Exception{
        sc=new MScanner(System.in);
        pw = new PrintWriter(System.out);
        int tc=1;
        tc=sc.nextInt();
        for(int i=1;i<=tc;i++) {
//            pw.printf("Case %d:\n", i);
            main();
        }
        pw.flush();
    }
    static PrintWriter pw;
    static MScanner sc;
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
        public int[] intArr(int n) throws IOException {
            int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
            return in;
        }
        public long[] longArr(int n) throws IOException {
            long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
            return in;
        }
        public int[] intSortedArr(int n) throws IOException {
            int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();
            shuffle(in);
            Arrays.sort(in);
            return in;
        }
        public long[] longSortedArr(int n) throws IOException {
            long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();
            shuffle(in);
            Arrays.sort(in);
            return in;
        }
        public Integer[] IntegerArr(int n) throws IOException {
            Integer[]in=new Integer[n];for(int i=0;i<n;i++)in[i]=nextInt();
            return in;
        }
        public Long[] LongArr(int n) throws IOException {
            Long[]in=new Long[n];for(int i=0;i<n;i++)in[i]=nextLong();
            return in;
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
     
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
     
        public boolean ready() throws IOException {
            return br.ready();
        }
     
        public void waitForInput() throws InterruptedException {
            Thread.sleep(3000);
        }
        
    }
    static void shuffle(int[]in) {
        for(int i=0;i<in.length;i++) {
            int idx=(int)(Math.random()*in.length);
            int tmp=in[i];
            in[i]=in[idx];
            in[idx]=tmp;
        }
    }
    static void shuffle(long[]in) {
        for(int i=0;i<in.length;i++) {
            int idx=(int)(Math.random()*in.length);
            long tmp=in[i];
            in[i]=in[idx];
            in[idx]=tmp;
        }
    }
}