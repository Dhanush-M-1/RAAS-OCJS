import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.math.*;
 
public class Myclass{
	static ArrayList[] a=new ArrayList[200001];
	

    public void solve () {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out); 
        int  n =in.nextInt();
        long a[]=new long [n];
        for(int i=0;i<n;i++)
        	a[i]=in.nextLong();
        Segment s=new Segment(n+1);
        long ans[]=new long [n];
        s.build(0, 0, n);
        boolean taken []=new boolean [n+1];
        for(int i=n-1;i>=0;i--) {
        	long start=1;
        	long end=n;
        	long fi=-1;
        	while(start<=end) {
        		long mid=(start+end)/2L;
        		long val=(mid*(mid-1))/2L-s.query(0, 0, n, 0, (int)mid-1);
        		if(val<=a[i]) {
        			fi=mid;
        			start=mid+1;
        		}
        		else {
        			end=mid-1;
        		}
        	}
        	s.update(0, 0, n, (int)fi, fi);
        	ans[i]=fi;
        	taken [(int) fi]=true;
        }
        for(int i=0;i<n;i++) {
        	pw.print(ans[i]+" ");
        }
        pw.flush();
        pw.close();
    }
    public static void main(String[] args) throws Exception {
        
        
        new Thread(null,new Runnable() {
            public void run() {
                new Myclass().solve();
            }
        },"1",1<<26).start();
    }
   
    static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
        }
        
        static class InputReader 
        {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream) 
        {
            this.stream = stream;
        }
        public int snext() 
        {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) 
            {
                curChar = 0;
                try 
                {
                    snumChars = stream.read(buf);
                } 
                catch (IOException e) 
                {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int nextInt() 
        {
            int c = snext();
            while (isSpaceChar(c)) 
            {
                c = snext();
            }
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do 
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public long nextLong()
        {
            int c = snext();
            while (isSpaceChar(c)) 
            {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') 
            {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do 
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int[] nextIntArray(int n) 
        {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
            {
                a[i] = nextInt();
            }
            return a;
        }
 
        public String readString()
        {
            int c = snext();
            while (isSpaceChar(c)) 
            {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do 
            {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public String nextLine() 
        {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do 
            {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) 
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private boolean isEndOfLine(int c) 
        {
            return c == '\n' || c == '\r' || c == -1;
        }
 
        public interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }
    }
        public static long mod = 1000000007;
        public static int d;
        public static int p;
        public static int q;
        public void extended(int a,int b) {
            if(b==0) {
                d=a;
                p=1;
                q=0;
            }
            else
            {
                extended(b,a%b);
                int temp=p;
                p=q;
                q=temp-(a/b)*q;
            }
        }
        public static int binaryExponentiation(int x,int n)
        {
            int result=1;
            while(n>0)
            {
                if(n % 2 ==1)
                    result=result * x;
                x=x*x;
                n=n/2;
            }
            return result;
        }
        
        public static long binaryExponentiation(long x,long n)
        {
            long result=1;
            while(n>0)
            {
                if(n % 2 ==1)
                    result=result * x;
                x=x*x;
                n=n/2;
            }
            return result;
        }
        
        public static long[] shuffle(long[] a,Random gen)
        {
            int n = a.length;
            for(int i=0;i<n;i++)
            {
                int ind = gen.nextInt(n-i)+i;
                long temp = a[ind];
                a[ind] = a[i];
                a[i] = temp;
            }
            return a;
        }
        
        public static void swap(int a, int b){
            int temp = a;
            a = b;
            b = temp;
        }
        
        public static HashSet<Integer> primeFactorization(int n)
        {
            HashSet<Integer> a =new HashSet<Integer>();
            for(int i=2;i*i<=n;i++)
            {
                while(n%i==0)
                {
                    a.add(i);
                    n/=i;
                }
            }
            if(n!=1)
                a.add(n);
            return a;
        }
        
        public static void sieve(boolean[] isPrime,int n)
        {
            for(int i=1;i<n;i++)
                isPrime[i] = true;
            
            isPrime[0] = false;
            isPrime[1] = false;
            
            for(int i=2;i*i<n;i++)
            {
                if(isPrime[i] == true)
                {
                    for(int j=(2*i);j<n;j+=i)
                        isPrime[j] = false;
                }
            }
        }
        
        public static long GCD(long n,long m)
        {
            if(m==0)
                return n;
            else
                return GCD(m,n%m);
        }
        
        static class pair implements Comparable<pair>
        {
           Long x,y;
            
            pair(long l,long m)
            {
                this.x=l;
                this.y=m;
            }
 
            public int compareTo(pair o) {
                int result = x.compareTo(o.x);
                if(result==0)
                    result = y.compareTo(o.y);
                
                return result;
            }  
            
            public String toString()
            {
                return x+" "+y;
            }
            
            public boolean equals(Object o)
            {
                if (o instanceof pair)
                {
                    pair p = (pair)o;
                    return p.x.equals(x) && p.y.equals(y) ;
                }
                return false;
            }
            
            public int hashCode()
            {
                return new Long(x).hashCode()*31 + new Long(y).hashCode();
            }
        }
        
    
}
 
/*class dsu{
    int parent[];
    dsu(int n){
        parent=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            parent[i]=i;
        }
    }
    int root(int n) {
        while(parent[n]!=n)
        { 
            parent[n]=parent[parent[n]];
            n=parent[n];
        }
        return n;
    }
    void union(int _a,int _b) {
        int p_a=root(_a);
        int p_b=root(_b);
        
            parent[p_a]=p_b;
        
            
    }
    boolean find(int a,int b) {
        if(root(a)==root(b))
            return true;
        else
            return  false;
    }
    
    
}*/
class Segment{ 
    long seg[];
    long[] a;

    int lazy[];
    Segment (int n){
        seg=new long[4*n];
        lazy=new int[4*n];
    }
    public void build(int node,int start,int end) {
        if(start==end) {
            seg[node]=0;
            return ;
        }
        int mid=(start+end)/2;
        build(2*node+1,start,mid);
        build(2*node+2,mid+1,end);
        seg[node]=(seg[2*node+1]+seg[2*node+2]);
    }
    
   
    public void update(int node,int start,int end,int fi,long fi2) {
        if(start==end) {
            seg[node]=fi2;
            return;
        }
        int mid=(start+end)/2;
        if(fi>=start && fi<=mid) {
            update(2*node+1,start,mid,fi,fi2);
        }
        else
            update(2*node+2,mid+1,end,fi,fi2);
        seg[node]=seg[2*node+1]+seg[2*node+2];
    }
    public long query(int node,int start,int end,int l,int r) {
        if(l>end || r<start)
            return 0;
        if(start>=l && end<=r)
            return seg[node];
        
        int  mid=(start+end)/2;
        return (query(2*node+1,start,mid,l,r)+query(2*node+2,mid+1,end,l,r));
    }
    /*public void updateRange(int node,int start,int end,int l,int r,int val) {
        if(lazy[node]!=0) {
            if(start!=end) {
                lazy[2*node+1]+=lazy[node];
                lazy[2*node+2]+=lazy[node];
            }
            lazy[node]=0;
        }
        if(l>end || r<start)
            return ;
        if(start>=l && end<=r) {
            seg[node]=(end-start+1)*val;
            if(start!=end) {
                lazy[2*node+1]+=val;
                lazy[2*node+2]+=val;
            }
            lazy[node]=0;
            return ;
        }
        int mid=(start+end)/2;
        updateRange(2*node+1,start,mid,l,r,val);
        updateRange(2*node+2,mid+1,end,l,r,val);
        seg[node]=seg[2*node+1]+seg[2*node+2];
    }
    public int queryRange(int node,int start,int end,int l,int r) {
        if(l>end || r<start)
            return 0;
        if(lazy[node]!=0) {
            seg[node]=(end-start+1)*lazy[node];
            if(start!=end) {
                lazy[2*node+1]+=lazy[node];
                lazy[2*node+2]+=lazy[node];
            }
            lazy[node]=0;
        }
        if(start>=l && end<=r)
            return seg[node];
        
        int  mid=(start+end)/2;
        return (query(2*node+1,start,mid,l,r)+query(2*node+2,mid+1,end,l,r));
    }*/
    
}
