import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.util.*;
import java.lang.*;
import java.util.HashMap;
import java.util.PriorityQueue;
public class Solution implements Runnable{
    static class pair implements Comparable
    {
        long f;
        int s;
        pair(long fi,int se)
        {
            f=fi;
            s=se;
        }
        public int compareTo(Object o)//ascending order
        {
            pair pr=(pair)o;
            if(s>pr.s)
                return 1;
            if(s==pr.s)
            {
                if(f>pr.f)
                    return 1;
                else
                    return -1;
            }
            else
                return -1;
        }
        public boolean equals(Object o)
        {
            pair ob=(pair)o;
            long ff;
            int ss;
            if(o!=null)
            {
                ff=ob.f;
                ss=ob.s;
                if((ff==this.f)&&(ss==this.s))
                    return true;
            }
            return false;
        }
        public int hashCode()
        {
            return (this.f+" "+this.s).hashCode();
        }
    }
    public class triplet implements Comparable
    {
        int f,t;
        int s;
        triplet(int f,int s,int t)
        {
            this.f=f;
            this.s=s;
            this.t=t;
        }
        public boolean equals(Object o)
        {
            triplet ob=(triplet)o;
            int ff;
            int ss;
            int tt;
            if(o!=null)
            {
                ff=ob.f;
                ss=ob.s;
                tt=ob.t;
                if((ff==this.f)&&(ss==this.s)&&(tt==this.t))
                    return true;
            }
            return false;
        }
        public int hashCode()
        {
            return (this.f+" "+this.s+" "+this.t).hashCode();
        }
        public int compareTo(Object o)//ascending order
        {
            triplet tr=(triplet)o;
            if(t>tr.t)
                return 1;
            else
                return -1;
        }
    }
    void merge1(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int [n1];
        int R[] = new int [n2];
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i]<=R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void sort1(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;
            sort1(arr, l, m);
            sort1(arr , m+1, r);
            merge1(arr, l, m, r);
        }
    }
    long a[];
    pair tree[];
    long lazy[];
    long inf=(long)100000000*100000000;
    void build(int node,int start,int end)
    {
        if(start==end)
        {
            tree[node].f=a[start];
            tree[node].s=start;
            return;
        }
        int mid=(start+end)/2;
        build(2*node,start,mid);
        build(2*node+1,mid+1,end);
        if(tree[2*node].f<tree[2*node+1].f)
            tree[node]=new pair(tree[2*node].f,tree[2*node].s);
        else if(tree[2*node+1].f<tree[2*node].f)
            tree[node]=new pair(tree[2*node+1].f,tree[2*node+1].s);
        else
            tree[node]=new pair(tree[2*node+1].f,tree[2*node+1].s);
    }
    pair query(int node,int start,int end)
    {
        if(lazy[node]!=0)
        {
            tree[node].f+=lazy[node];
            if(start!=end)
            {
                lazy[2*node]+=lazy[node];
                lazy[2*node+1]+=lazy[node];
            }
            lazy[node]=0;
        }
        return tree[node];
    }
    void update(int node,int start,int end,int l,int r,long val)
    {
        if(lazy[node]!=0)
        {
            tree[node].f+=lazy[node];
            if(start!=end)
            {
                lazy[2*node]+=lazy[node];
                lazy[2*node+1]+=lazy[node];
            }
            lazy[node]=0;
        }
        if(end<l || r<start)
            return;
        if(start>=l && end<=r)
        {
            tree[node].f+=val;
            if(start!=end)
            {
                lazy[2*node]+=val;
                lazy[2*node+1]+=val;
            }
            return;
        }
        int mid=(start+end)/2;
        update(2*node,start,mid,l,r,val);
        update(2*node+1,mid+1,end,l,r,val);
        if(tree[2*node].f<tree[2*node+1].f)
            tree[node]=new pair(tree[2*node].f,tree[2*node].s);
        else if(tree[2*node+1].f<tree[2*node].f)
            tree[node]=new pair(tree[2*node+1].f,tree[2*node+1].s);
        else
            tree[node]=new pair(tree[2*node+1].f,tree[2*node+1].s);
    }
    public static void main(String args[])throws Exception
    {
        new Thread(null,new Solution(),"Solution",1<<27).start();
    }
    public void run()
    {
        try
        {
            InputReader in = new InputReader(System.in);
            PrintWriter out = new PrintWriter(System.out);
            int n=in.ni();
            a=new long[n+1];
            tree=new pair[4*n+1];
            lazy=new long[4*n+1];
            for(int i=1;i<=4*n;i++)
                tree[i]=new pair(0,0);
            for(int i=1;i<=n;i++)
                a[i]=in.nl();
            build(1,1,n);
            /*for(int i=1;i<=5;i++)
                System.out.println(tree[i].f+" "+tree[i].s);
            System.out.println();*/
            int ans[]=new int[n+1];
            int k=1;
            while(k<=n)
            {
                pair p=query(1,1,n);
                //System.out.println(p.s);
                ans[p.s]=k;
                update(1,1,n,p.s,p.s,inf);
                update(1,1,n,p.s+1,n,-1*k);
                k++;
                /*for(int i=1;i<=5;i++)
                    System.out.println(tree[i].f+" "+tree[i].s);
                System.out.println();*/
            }
            for(int i=1;i<=n;i++)
                out.print(ans[i]+" ");
            out.close();
        }
        catch(Exception e){
            return;
        }
    }
    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int ni() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nl() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

    }
}