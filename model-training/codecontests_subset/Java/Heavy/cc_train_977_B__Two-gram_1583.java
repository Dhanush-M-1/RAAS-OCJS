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
public class r479b {
    public static void main(String args[])
    {
        fastio in=new fastio(System.in);
        PrintWriter pw=new PrintWriter(System.out);

        int n=in.nextInt();
        String str=in.readString();
        HashMap<String,Integer> hm=new HashMap<String,Integer>();
        for(int i=0;i<n-1;i++)
        {
            char ch=str.charAt(i);
            char ch1=str.charAt(i+1);
            String str1=ch+""+ch1+"";
            if(hm.containsKey(str1))
                hm.put(str1, hm.get(str1)+1);
            else
                hm.put(str1, 1);
        }
        
        //pw.println(hm);
        Set set=hm.entrySet();
        Iterator it=set.iterator();
        int max=0;
        String ans="";
        while(it.hasNext())
        {
            Map.Entry me=(Map.Entry)it.next();
            String key=me.getKey().toString();
            int val=(Integer)me.getValue();
            if(val>max)
            {
                max=val;
                ans=key;
            }
        }
        pw.println(ans);
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
