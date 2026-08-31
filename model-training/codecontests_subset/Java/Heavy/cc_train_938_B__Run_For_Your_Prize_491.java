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
public class r38b {
    public static void main(String args[])
    {
        fastio in=new fastio(System.in);
        PrintWriter pw=new PrintWriter(System.out);

        int n=in.nextInt();
        int st=1,en=1000000;
        
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int i=0;i<n;i++)
            hs.add(in.nextInt());
        
        int count=-1;
        while(!hs.isEmpty())
        {
            if(hs.contains(st))
                hs.remove(st);
            if(hs.contains(en))
                hs.remove(en);
            
            st++;
            en--;
            count++;
        }
        pw.println(count);
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
