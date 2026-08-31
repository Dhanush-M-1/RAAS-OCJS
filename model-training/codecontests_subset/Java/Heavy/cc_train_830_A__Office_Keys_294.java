/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dipankar12
 */
import java.io.*;
import java.util.*;
public class r424d {
    public static void main(String args[])
    {
        fastio in=new fastio(System.in);
        PrintWriter pw=new PrintWriter(System.out);

        int n=in.nextInt();
        int k=in.nextInt();
        int p=in.nextInt();
        
        int ar[]=new int[n];
        for(int i=0;i<n;i++)
            ar[i]=in.nextInt();
        
        Arrays.sort(ar);
        
        int ar1[]=new int[k];
        for(int i=0;i<k;i++)
            ar1[i]=in.nextInt();
        
        Arrays.sort(ar1);
        
        long max=Integer.MAX_VALUE;
        for(int i=0;i<k;i++)
        {
            int x=i,flag=0;
            long sum=Math.abs(ar1[x]-ar[0])+Math.abs(ar1[x++]-p);
            for(int j=1;j<n;j++)
            {
                if(x>=k)
                {
                    flag=-1;
                    break;
                }
                sum=Math.max(Math.abs(ar[j]-ar1[x])+Math.abs(ar1[x++]-p),sum);
            }
            if(flag!=-1)
                max=Math.min(sum, max);
        }
        pw.println(max);
        pw.close();
    }

    static class fastio {
     
            private final InputStream stream;
            private final byte[] buf = new byte[8192];
            private int cchar, snchar;
            private SpaceCharFilter filter;
     
            public fastio(InputStream stream) {
                this.stream = stream;
            }
     
            public int nxt() {
                if (snchar == -1)
                    throw new InputMismatchException();
                if (cchar >= snchar) {
                    cchar = 0;
                    try {
                        snchar = stream.read(buf);
                    } catch (IOException e) {
                        throw new InputMismatchException();
                    }
                    if (snchar <= 0)
                        return -1;
                }
                return buf[cchar++];
            }
     
            public int nextInt() {
                int c = nxt();
                while (isSpaceChar(c)) {
                    c = nxt();
                }
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = nxt();
                }
                int res = 0;
                do {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = nxt();
                } while (!isSpaceChar(c));
                return res * sgn;
            }
     
            public long nextLong() {
                int c = nxt();
                while (isSpaceChar(c)) {
                    c = nxt();
                }
                int sgn = 1;
                if (c == '-') {
                    sgn = -1;
                    c = nxt();
                }
                long res = 0;
                do {
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    res *= 10;
                    res += c - '0';
                    c = nxt();
                } while (!isSpaceChar(c));
                return res * sgn;
            }
     
            public int[] nextIntArray(int n) {
                int a[] = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = nextInt();
                }
                return a;
            }
     
            public String readString() {
                int c = nxt();
                while (isSpaceChar(c)) {
                    c = nxt();
                }
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = nxt();
                } while (!isSpaceChar(c));
                return res.toString();
            }
     
            public String nextLine() {
                int c = nxt();
                while (isSpaceChar(c))
                    c = nxt();
                StringBuilder res = new StringBuilder();
                do {
                    res.appendCodePoint(c);
                    c = nxt();
                } while (!isEndOfLine(c));
                return res.toString();
            }
     
            public boolean isSpaceChar(int c) {
                if (filter != null)
                    return filter.isSpaceChar(c);
                return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
            }
     
            private boolean isEndOfLine(int c) {
                return c == '\n' || c == '\r' || c == -1;
            }
     
            public interface SpaceCharFilter {
                public boolean isSpaceChar(int ch);
            }
        }
    

}
