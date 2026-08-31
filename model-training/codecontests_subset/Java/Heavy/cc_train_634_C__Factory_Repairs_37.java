import javafx.scene.layout.Priority;
import java.io.*;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;
import java.lang.*;
import java.util.HashMap;
import java.util.PriorityQueue;
public class templ implements Runnable {
    static class pair implements Comparable
    {
        int f;
        int s;
        pair(int fi,int se)
        {
            f=fi;
            s=se;
        }
        public int compareTo(Object o)
        {
            pair pr=(pair)o;
            if(s>pr.s)
                return 1;
            if(s==pr.s)
            {
                if(f<pr.f)
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
            int ff;
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
        public int compareTo(Object o)
        {
            triplet tr=(triplet)o;
            if(t>tr.t)
                return 1;
            else
                return -1;
        }
    }
    long tree1[],tree2[];
    int a,b;
    long qtree1(int node,int start,int end,int l,int r)
    {
        if(r<l)
            return 0;
        if(end<l||r<start)
            return 0;
        if(start>=l&&end<=r)
            return tree1[node];
        int mid=(start+end)/2;
        long x=qtree1(2*node,start,mid,l,r);
        long y=qtree1(2*node+1,mid+1,end,l,r);
        return x+y;
    }
    void utree1(int node,int start,int end,int idx,int val)
    {
        if(idx<start||idx>end)
            return;
        if(start==end)
        {
            tree1[node]=Math.min(tree1[node]+val,b);
            return;
        }
        int mid=(start+end)/2;
        utree1(2*node,start,mid,idx,val);
        utree1(2*node+1,mid+1,end,idx,val);
        tree1[node]=tree1[2*node]+tree1[2*node+1];
    }
    long qtree2(int node,int start,int end,int l,int r)
    {
        if(r<l)
            return 0;
        if(end<l||r<start)
            return 0;
        if(start>=l&&end<=r)
            return tree2[node];
        int mid=(start+end)/2;
        long x=qtree2(2*node,start,mid,l,r);
        long y=qtree2(2*node+1,mid+1,end,l,r);
        return x+y;
    }
    void utree2(int node,int start,int end,int idx,int val)
    {
        if(idx<start||idx>end)
            return;
        if(start==end)
        {
            tree2[node]=Math.min(tree2[node]+val,a);
            return;
        }
        int mid=(start+end)/2;
        utree2(2*node,start,mid,idx,val);
        utree2(2*node+1,mid+1,end,idx,val);
        tree2[node]=tree2[2*node]+tree2[2*node+1];
    }
    public static void main(String args[])throws Exception
    {
        new Thread(null,new templ(),"templ",1<<27).start();
    }
    public void run()
    {
        try
        {
            InputReader in = new InputReader(System.in);
            PrintWriter out = new PrintWriter(System.out);
            int n=in.ni();
            int k=in.ni();
            a=in.ni();
            b=in.ni();
            int q=in.ni();
            tree1=new long[4*n+1];
            tree2=new long[4*n+1];
            while(q--!=0)
            {
                int type=in.ni();
                if(type==1)
                {
                    int day=in.ni();
                    int x=in.ni();
                    utree1(1,1,n,day,x);
                    utree2(1,1,n,day,x);
                }
                if(type==2)
                {
                    int day=in.ni();
                    long x=qtree1(1,1,n,1,day-1);
                    long y=qtree2(1,1,n,day+k,n);
                    out.println(x+y);
                }
            }
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