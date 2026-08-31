import java.io.*;
import java.util.*;
public class factoryrepairs{
    static long[] segtreea,segtreeb;
    static int a,b;
    public static void main(String[] args) throws Exception
    {
        InputReader in=new InputReader(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        int n=in.nextInt();
        int k=in.nextInt();
        a=in.nextInt();
         b=in.nextInt();
        int q=in.nextInt();
        segtreea=new long[4*n];
        segtreeb=new long[4*n];
        for(int i=0;i<q;i++)
        {
            int qt=in.nextInt();
            if(qt==1)
            {
                int day=in.nextInt();
                int add=in.nextInt();
                updatepos(0,0,n,day,add);
                updateneg(0,0,n,day,add);
                
            }
            else
            {
                int d=in.nextInt();
                long w=queryneg(0,0,n,0,d-1);
                long s=querypos(0,0,n,d+k,n);
                pw.println(w+s);
            }
        }
        
        
        pw.close();
    }
    
    public static void updatepos(int c,int start,int end,int idx,long val)
    {
        if(start==end)
        {
            segtreea[c]=segtreea[c]+val;
            if(segtreea[c]>a)
            {
                segtreea[c]=a;    
            }
            
        }
        else
        {
            int mid=(start+end)/2;
            if(idx<=mid)
            {
                updatepos(2*c+1,start,mid,idx,val);
            }
            else
            {
                updatepos(2*c+2,mid+1,end,idx,val);
            }
            segtreea[c]=segtreea[2*c+1]+segtreea[2*c+2];
            
        }
    }
    public static long querypos(int c,int start,int end,int ql,int qr)
    {
        if(start>qr || end<ql)
        {
            return 0;
        }
        if(start>=ql && end<=qr)
        {
            return segtreea[c];
        }
        int mid=(start+end)/2;
        return querypos(2*c+1,start,mid,ql,qr)+querypos(2*c+2,mid+1,end,ql,qr);
    }
    public static void updateneg(int c,int start,int end,int idx,long val)
    {
        if(start==end)
        {
            segtreeb[c]=segtreeb[c]+val;
            //segtreeb[c]=Math.max(segtreeb[c], b);
            if(segtreeb[c]>b)
            {
                segtreeb[c]=b;
            }
        }
        else
        {
            int mid=(start+end)/2;
            if(idx<=mid)
            {
                updateneg(2*c+1,start,mid,idx,val);
            }
            else
            {
                updateneg(2*c+2,mid+1,end,idx,val);
            }
            segtreeb[c]=segtreeb[2*c+1]+segtreeb[2*c+2];
            
        }
    }
    public static long queryneg(int c,int start,int end,int ql,int qr)
    {
        if(start>qr || end<ql)
        {
            return 0;
        }
        if(start>=ql && end<=qr)
        {
            return segtreeb[c];
        }
        int mid=(start+end)/2;
        return queryneg(2*c+1,start,mid,ql,qr)+queryneg(2*c+2,mid+1,end,ql,qr);
    }

    
    
    
    
    
    
    
    
     static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
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

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }

            int res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));

            return res * sgn;
        }
        
        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }

            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));

            return res * sgn;
        }
        
        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

}