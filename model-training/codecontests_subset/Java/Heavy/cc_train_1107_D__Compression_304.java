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
        int f,s;
        pair(int fi,int se)
        {
            f=fi;
            s=se;
        }
        public int compareTo(Object o)
        {
            pair pr=(pair)o;
            if(f>pr.f)
                return 1;
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
        int f,s;
        int t;
        triplet(int f,int s,int t)
        {
            this.f=f;
            this.s=s;
            this.t=t;
        }
        public boolean equals(Object o)
        {
            triplet ob=(triplet)o;
            int ff,ss;
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
            if(f>tr.f)
                return 1;
            else if(f==tr.f)
            {
                if(s>tr.s)
                    return -1;
                else
                    return 1;
            }
            else
                return -1;
        }
    }
    String get(char n)
    {
        if(n=='0')
            return "0000";
        if(n=='1')
            return "0001";
        if(n=='2')
            return "0010";
        if(n=='3')
            return "0011";
        if(n=='4')
            return "0100";
        if(n=='5')
            return "0101";
        if(n=='6')
            return "0110";
        if(n=='7')
            return "0111";
        if(n=='8')
            return "1000";
        if(n=='9')
            return "1001";
        if(n=='A')
            return "1010";
        if(n=='B')
            return "1011";
        if(n=='C')
            return "1100";
        if(n=='D')
            return "1101";
        if(n=='E')
            return "1110";
        if(n=='F')
            return "1111";
        return "";
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
            int m[][]=new int[n+1][n+1];
            int a[][]=new int[n+1][n+1];
            for(int i=1;i<=n;i++)
            {
                StringBuilder ss=new StringBuilder();
                String s=in.nextLine();
                int l=s.length();
                for(int j=0;j<l;j++)
                {
                    char c=s.charAt(j);
                    ss.append(get(c));
                }
                l=ss.length();
                for(int j=0;j<l;j++)
                {
                    char c=ss.charAt(j);
                    int d=(int)c-(int)'0';
                    m[i][j+1]=d;
                }
            }
            a[1][1]=m[1][1];
            for(int i=2;i<=n;i++)
            {
                a[1][i]=m[1][i]+a[1][i-1];
            }
            for(int j=2;j<=n;j++)
            {
                a[j][1]=m[j][1]+a[j-1][1];
            }
            for(int i=2;i<=n;i++)
            {
                for(int j=2;j<=n;j++)
                {
                    a[i][j]=m[i][j]+a[i][j-1]+a[i-1][j]-a[i-1][j-1];
                }
            }
            int ans=-1;
            for(int ii=n;ii>=1;ii--)
            {
                if(n%ii!=0)
                    continue;
                int k=0;
                for(int i=ii;i<=n;i+=ii)
                {
                    for(int j=ii;j<=n;j+=ii)
                    {
                        int sum=a[i][j]-a[i-ii][j]-a[i][j-ii]+a[i-ii][j-ii];
                        if(sum==0||sum==ii*ii)
                            continue;
                        k=1;
                        break;
                    }
                }
                if(k==0)
                {
                    ans=ii;
                    break;
                }
            }
            out.println(ans);
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