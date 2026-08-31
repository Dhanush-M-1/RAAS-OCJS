import java.io.*;
     
     
     
     
    import java.math.*;
    import java.util.*;
import java.util.concurrent.DelayQueue;    
          public class Main1
           {
            private InputStream is;
            private PrintWriter out;
            static int MOD = (int)(1e9+7);
            ArrayList<Integer>[] amp;
            public static void main(String[] args) throws Exception
            {
                new Thread(null, new Runnable()
                {
                public void run()
                {
                    try {
         } catch (Exception e)
                    {
                        System.out.println(e);
                    }
                }
            }, "1", 1 << 26).start();
                new Main1().soln();
            }
            char ch[][];
            static ArrayList<Integer>[] g;
            static ArrayList<Integer> ar[];
            static long ok[];    
            static int phi[]=new int[500005];
            void solve()
            {
            	 
            	int n = ni();
            	int a[]=na(n);
            	int fr[]=new int[1000001];
            	for(int i=0;i<n;i++)
            		fr[a[i]]++;
            	int count1=1;
            	int count2=1000000;
            	int tot=0;
            	int ans=Integer.MAX_VALUE;
            	int cc=0;
            	TreeSet<Integer> set=new TreeSet();
            	for(int i=1;i<=1000000;i++)
            		if(fr[i]==1)
            			set.add(i);
            	int high[]=new int[1000001];
            	int curr=-1;
            	for(int i=1000000;i>=1;i--)
            	{
            		high[i]=curr;
            		if(fr[i]>0)
            			curr=i;
            	}
            	for(int i=2;i<1000000;i++)
            	{
            		if(high[i]==-1)
            			ans=Math.min(ans, i-1);
            		else
            		{
            			int tmp=high[i];
            			int diff=1000000-tmp;
            			if(diff<=(i-1))
            			{
            				ans=Math.min(ans, i-1);
            			}
            			else
            			{
            				ans=Math.min(ans,i-1+(diff-i+1));
            			}
            		}
            	}
            	out.println(ans);
            }
            
            
            public static void AntiClock(int a[][],int n)
            
            {
            	for(int i=0;i<n;i++)
            	{
            		for(int j=i;j<n;j++)
            		{
            			int tmp=a[i][j];
            			a[i][j]=a[j][i];
            			a[j][i]=tmp;
            		}
            	}
            	for(int i=0;i<n/2;i++)
            	{
            		for(int j=0;j<n;j++)
            		{
            			int tmp=a[i][j];
            			a[i][j]=a[n-1-i][j];
            			a[n-1-i][j]=tmp;
            		}
            	}
            	
            }
            
           
            
            
            
            
            public static long pr(long x,long y,long m)
            {
            	if(y==0)
            		return 1;
            	long p = pr(x,y/2,m);
            	p=(p*p)%m;
            	return(y%2==0)?(p):(x*p%m);
            }
            public static long GCD(long x,long y)
            {
            	if(y==0)
            		return x;
            	else
            		return GCD(y,x%y);
            }
            
            public static void print(ArrayList<Integer> ar)
            {
            	Collections.sort(ar,Collections.reverseOrder());
            	System.out.println("Yes");
            	for(int x:ar)
            	{
            		System.out.print(x+" ");
            	}
            	return;
            }
            public static void LOL()
            {
            	/*int a[]=new int[5];
            	a[0]=2;a[1]=1;a[2]=4;a[3]=3;a[4]=5;
            	 System.out.println(LIS(a,5));
            	 int n=5;
            	 int dp[]=new int[n];
            	 for(int i=0;i<n;i++)
            		 dp[i]=1;
            	 
            	 int backtrack[]=new int[n];
            	 Arrays.fill(backtrack,-1);
            	 for(int i=1;i<n;i++)
            	 {
            		 for(int j=0;j<i;j++)
            		 {
            			 if(dp[j]+1>dp[i]&&a[j]<a[i])
            			 {
            				 dp[i]=dp[j]+1;
            				 backtrack[i]=j;
            			 }
            		 }
            	 }
            	 int index=-1;
            	 int max=0;
            	 for(int i=0;i<n;i++)
            	 {
            		 if(max<dp[i])
            		 {
            			 index=i;
            			 max=dp[i];
            		 }
            	 }
            	 
            	 int tmp=index;
            	 Stack<Integer> st=new Stack();
            	 while(tmp>=0)
            	 {
            		 st.push(a[tmp]);
            		 tmp=backtrack[tmp];
            	 }
            	 while(!st.isEmpty())
            	 {
            		 out.print(st.pop()+" ");
            	 }
            /*	int n=150;
            	int ugly[]=new int[n+1];
            	ugly[0]=1;
            	int next_multiple_of_2=2;
            	int next_multiple_of_3=3;
            	int next_multiple_of_5=5;
            	int i2=0;int i3=0;int i5=0;
            	for(int i=1;i<n;i++)
            	{
            		int min=Math.min(next_multiple_of_5, Math.min(next_multiple_of_3, next_multiple_of_2));
            		ugly[i]=min;
            		if(min==next_multiple_of_2)
            		{
            			i2++;
            			next_multiple_of_2=ugly[i2]*2;
            		}
            		if(min==next_multiple_of_3)
            		{
            			i3++;
            			next_multiple_of_3=ugly[i3]*3;
            		}
            		if(min==next_multiple_of_5)
            		{
            			i5++;
            			next_multiple_of_5=ugly[i5]*5;
            		}
            	}
            	System.out.println(ugly[n-1]);
            	
            	int t=ni();
            	while(t-->0)
            	{
            		long n=nl();
            		int a[]=new int[4];
            		a[0]=2;
            		a[1]=3;
            		a[2]=5;
            		a[3]=7;
            		long sucks=0;
            		for(int i=0;i<(1<<4);i++)
            		{
            			int count=0;
            			long curr=1;
            			for(int j=0;j<4;j++)
            			{
            				int x=i;
            				x&=(1<<j);
            				if(x>0)
            				{
            					curr*=(long)a[j];
            					count++;
            				}
            			}
            			if(count==0)
            				continue;
            			if(count%2==1)
            			{
            				sucks+=(n/curr);
            			}
            			else
            			{
            				sucks-=(n/curr);
            			}
            		}
            		out.println(n-sucks);
            	}
            	String s1=ns();
            	String s2=ns();
            	int m=s1.length();int n=s2.length();
            	int dp[][]=new int[m+1][n+1];
            	for(int i=0;i<=m;i++)
            	{
            		for(int j=0;j<=n;j++)
            		{
            			if(i==0)
            				dp[i][j]=j;
            			else if(j==0)
            				dp[i][j]=i;
            			else if(s1.charAt(i-1)==s2.charAt(j-1))
            				dp[i][j]=dp[i-1][j-1];
            			else
            				dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
            		}
            	}*/
            }
            public static int edit(String s1,String s2,int m,int n)
            {
            	if(m==0)
            		return n;
            	if(n==0)
            		return m;
            	if(s1.charAt(m-1)==s2.charAt(n-1))
            		return edit(s1,s2,m-1,n-1);
            	return 1+Math.min(edit(s1,s2,m,n-1),Math.min(edit(s1,s2,m-1,n),edit(s1,s2,m-1,n-1)));
            }
            static int max=1;
            public static int LIS(int a[],int n  )
            {
            	if(n==1)
            		return 1;
            	int res=1;
            	int max_ending_here=1;
            	for(int i=1;i<n;i++)
            	{
            		res=LIS(a,i);
            		if(a[i-1]<a[n-1]&&res+1>max_ending_here)
            			max_ending_here=res+1;
            	}
            	max=Math.max(max,max_ending_here);
            	return max_ending_here;
            }
            static boolean visi1[];
            static int cont=0;
            static int para[];
            public static void dfs(int curr,int pr)
            {
            	visi1[curr]=true;
            	
            	int trees=0;
            	for(int x:g[curr])
            	{
            		if(!visi1[x]&&x!=pr)
            		{
            			trees++;
            			dfs(x,pr);
            		}
            	}
            	if(trees==0)cont++;
            }
            
            static boolean visited[][];
			static int a[][];
            public static long query(int v,int start,int end,int l,int r,int x)
            {
            	if(r < start || end < l)
                {
                    return 0;
                }
                if(l <= start && end <= r)
                {
                    return (tre[v]);
                }
                int mid = (start + end) / 2;
                long p1 = query(2*v, start, mid, l, r,x);
                long p2 = query(2*v+1, mid+1, end, l, r,x);
                return p1+p2;	
            }
            public static void update(int v,int tl,int tr,int index,long harami2)
            {
            	if(tl==tr)
                {
                    tre[v]=harami2;
                }
                else
                {
                    int mid=(tl+tr)/2;
                    if(tl <= index &&index <= mid)
                    {
                        update(2*v,tl, mid, index, harami2);
                    }
                    else
                    {
                        update(2*v+1,mid+1,tr, index, harami2);
                    }
                    tre[v]=tre[2*v]+tre[2*v+1];
                }
            }
            static long tre[]=new long[8000005];
          /* public static int find(int v,int start,int end,int l,int r)
            {
                if(r < start || end < l)
                {
                    return Integer.MIN_VALUE;
                }
                if(l <= start && end <= r)
                {
                    return (tre[v]);
                }
                int mid = (start + end) / 2;
                int p1 = find(2*v, start, mid, l, r);
                int p2 = find(2*v+1, mid+1, end, l, r);
                return Math.max(p1, p2);          
            }
            static int tre[]=new int[4000005];
            public static void Update(int v,int tl,int tr,int index,int val)
            {
                if(tl==tr)
                {
                    tre[v]=val;
                }
                else
                {
                    int mid=(tl+tr)/2;
                    if(tl <= index &&index <= mid)
                    {
                        Update(2*v,tl, mid, index, val);
                    }
                    else
                    {
                        Update(2*v+1,mid+1,tr, index, val);
                    }
                    tre[v]=(Math.max(tre[2*v],tre[2*v+1]));
                }
            }
            */
            
            static int d,x,y;
            static void exE(int a,int b)
            {
            	if(b==0)
            	{
            		d=a;
            		x=1;
            		y=0;
            	}
            	else
            	{
            		exE(b,a%b);
            		int tmp=x;
            		x=y;
            		y=tmp - (a/b)*y;
            	}
            }
            boolean isPrime(int x)
                {
                if(x==0||x==1)
                    return false;
                for(int i = 2;i*1L*i<=x;i++) if(x%i==0) return false;
                return true;
            }
            int  p ;
            long modInverse(long a, long mOD2){
                return  power(a, mOD2-2, mOD2);
            }
            long power(long x, long y, long m)
            {
            if (y == 0)
            return 1;
            long p = power(x, y/2, m) % m;
            p = (p * p) % m;
        
            return (y%2 == 0)? p : (x * p) % m;
            }
            public static long gcd(long a, long b){
                if(b==0) return a;
                return gcd(b,a%b);
            }
            class Pair1 implements Comparable<Pair1>{
                long a;
               
                double c;
                long b;
                Pair1(long x,double z,long y){
                this.a=x;
                              this.c=z;
                              this.b=y;
                }
                public int hashCode() {
                    return Objects.hash();
                }
                
                @Override
                public int compareTo(Pair1 arg0) {
                    if(c!=arg0.c)
                	return (int)(c-arg0.c);
                    else
                    	return (int)(arg0.b-b);
                }    
            }
            long power(long x, long y, int mod){
                long ans = 1;
                while(y>0){
                    if(y%2==0){
                        x = (x*x)%mod;
                        y/=2;
                    }
                    else{
                        ans = (x*ans)%mod;
                        y--;
                    }
                }
                return ans;
            }
            void soln() {
                is = System.in;
                out = new PrintWriter(System.out);
                long s = System.currentTimeMillis();
                solve();
                out.flush();
            }
             private byte[] inbuf = new byte[1024];
            public int lenbuf = 0, ptrbuf = 0;
            private int readByte() {
                if (lenbuf == -1)
                    throw new InputMismatchException();
                if (ptrbuf >= lenbuf) {
                    ptrbuf = 0;
                    try {
                        lenbuf = is.read(inbuf);
                    } catch (IOException e) {
                        throw new InputMismatchException();
                    }
                    if (lenbuf <= 0)
                        return -1;
                }
                return inbuf[ptrbuf++];
            }
            private boolean isSpaceChar(int c) {
                return !(c >= 33 && c <= 126);
            }
            private int skip() {
                int b;
                while ((b = readByte()) != -1 && isSpaceChar(b))
                    ;
                return b;
            }
            private double nd() {
                return Double.parseDouble(ns());
            }
            private char nc() {
                return (char) skip();
            }
            private String ns() {
                int b = skip();
                StringBuilder sb = new StringBuilder();
                while (!(isSpaceChar(b))) {
                    sb.appendCodePoint(b);
                    b = readByte();
                }
                return sb.toString();
            }
            private char[] ns(int n) {
                char[] buf = new char[n];
                int b = skip(), p = 0;
                while (p < n && !(isSpaceChar(b))) {
                    buf[p++] = (char) b;
                    b = readByte();
                }
                return n == p ? buf : Arrays.copyOf(buf, p);
            }
            private int[][] nm(int n, int m) {
                int[][] map = new int[n][m];
                for (int i = 0; i < n; i++)
                {
                    for(int j=0;j<m;j++)
                        map[i][j]=ni();
                }
                return map;
            }
            private int[] na(int n) {
                int[] a = new int[n];
                for (int i = 0; i < n; i++)
                    a[i] = ni();
                return a;
            }
            private int ni() {
                int num = 0, b;
                boolean minus = false;
                while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                    ;
                if (b == '-') {
                    minus = true;
                    b = readByte();
                }
                while (true) {
                    if (b >= '0' && b <= '9') {
                        num = num * 10 + (b - '0');
                    } else {
                        return minus ? -num : num;
                    }
                    b = readByte();
                }
            }
            private long nl() {
                long num = 0;
                int b;
                boolean minus = false;
                while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                    ;
                if (b == '-') {
                    minus = true;
                    b = readByte();
                }
                while (true) {
                    if (b >= '0' && b <= '9') {
                        num = num * 10 + (b - '0');
                    } else {
                        return minus ? -num : num;
                    }
                    b = readByte();
                }
            }
            private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
            private void tr(Object... o) {
                if (!oj)
                    System.out.println(Arrays.deepToString(o));
            }
        }  
