import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;
import static java.lang.Math.*;
public class Solution{ 
    static InputReader sc;
    static PrintWriter wc;
    static long[] tree,lazy,arr;
    static void build(int l,int r,int i){
        if(l==r){
            tree[i]=arr[l];
            return;
        }
        int m=(l+r)>>1;
        build(l,m,2*i+1);
        build(m+1,r,2*i+2);
        tree[i]=Math.min(tree[2*i+1],tree[2*i+2]);
    }
    static void update(int i,long val){
        tree[i]+=val;
        lazy[i]+=val;
    }
    static void lazy_update(int ql,int qr,int l,int r,int i,long val){
        if(l>qr||r<ql){
            return;
        }
        else{
            if(l>=ql&&r<=qr){
                tree[i]+=val;
                lazy[i]+=val;
            }
            else{
                int m=(l+r)>>1;
                lazy_update(ql,qr,l,m,2*i+1,val);
                lazy_update(ql,qr,m+1,r,2*i+2,val);
                tree[i]=Math.min(tree[2*i+1],tree[2*i+2]);
            }
        }
    }
    static int getMin(int l,int r,int i){
        if(l==r){
            return l;
        }
        else{
            if(lazy[i]!=0){
                update(2*i+1,lazy[i]);
                update(2*i+2,lazy[i]);
                lazy[i]=0;
            }
            int m=(l+r)>>1,res;
            if(tree[2*i+2]==0){
                res = getMin(m+1,r,2*i+2);
            }
            else
                res = getMin(l,m,2*i+1);
            tree[i]=Math.min(tree[2*i+1],tree[2*i+2]);
            return res;
        }
    }
    static void print(int a[]){
        for(int i=0;i<a.length;i++){
            wc.print(a[i]+" ");
        }
        wc.println();
        //wc.println(a[0]);
    }
    public static void main(String[] args) {
        sc = new InputReader(System.in);
        wc = new PrintWriter(System.out);
        int n=sc.nextInt();
        int i,tlen,r[]=new int[n],j;
        long inf=(long) 2e11;
        tlen=(int)Math.ceil(Math.log(n)/Math.log(2))+1;
        tlen=(1<<tlen)-1;
        arr=new long[n];
        tree=new long[tlen];
        lazy = new long[tlen];
        for(i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        build(0,n-1,0);
        for(i=1;i<=n;i++){
            j=getMin(0,n-1,0);
            r[j]=i;
            lazy_update(j,j,0,n-1,0,inf);
            lazy_update(j+1,n-1,0,n-1,0,-i);
        }
        print(r);
        //wc.println(r[0]);
        wc.close();
    }
    static class InputReader {
        
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }
        
        public int read()
        {
            if (numChars==-1) 
                throw new InputMismatchException();
            if (curChar >= numChars)
            {
                curChar = 0;
                try 
                {
                    numChars = stream.read(buf);
                }
                catch (IOException e)
                {
                    throw new InputMismatchException();
                }
                
                if(numChars <= 0)               
                    return -1;
            }
            return buf[curChar++];
        }
     
        public String nextLine()
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
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
        public int nextInt()
        {
            int c = read();
            
            while(isSpaceChar(c)) 
                c = read();
            
            int sgn = 1;
            
            if (c == '-') 
            {
                sgn = -1;
                c = read();
            }
            
            int res = 0;
            do 
            {
                if(c<'0'||c>'9') 
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c)); 
            
            return res * sgn;
        }
        
        public long nextLong() 
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') 
            {
                sgn = -1;
                c = read();
            }
            long res = 0;
            
            do 
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
                return res * sgn;
        }
        
        public double nextDouble() 
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') 
            {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') 
            {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') 
            {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) 
                {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
        
        public String readString() 
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do 
            {
                res.appendCodePoint(c);
                c = read();
            } 
            while (!isSpaceChar(c));
            
            return res.toString();
        }
     
        public boolean isSpaceChar(int c) 
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
     
        public String next() 
        {
            return readString();
        }
        
        public interface SpaceCharFilter 
        {
            public boolean isSpaceChar(int ch);
        }
    }   
}