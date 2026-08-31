import java.io.*;
import java.util.*;

public class newyearbookreading {
    public static void main(String[] args) throws Exception
    {
        InputReader in=new InputReader(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        int n=in.nextInt();
        int m=in.nextInt();
        int[] weight=new int[n];
        for(int i=0;i<n;i++)
        {
            weight[i]=in.nextInt();
        }
        int[] st=new int[m];
        ArrayList<Integer> ar=new ArrayList<Integer>();
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int i=0;i<m;i++)
        {
            int temp=in.nextInt();
            st[i]=temp;
            if(!hs.contains(temp))
            {
                ar.add(temp);
                hs.add(temp);
            }
        }
        Stack<Integer> s=new Stack<Integer>();
        int size=ar.size();
        for(int i=size-1;i>=0;i--)
        {
            s.push(ar.get(i));
        }
        //System.out.println(s.toString());
        int ans=0;
        for(int i=0;i<m;i++)
        {
            ArrayList<Integer> tt=new ArrayList<Integer>();
        //  boolean rem=false;
            while(s.peek()!=st[i])
            {
                //rem=true;
                ans+=weight[s.peek()-1];
                tt.add(s.pop());
            }
            /*if(rem)
            {
            ans+=weight[s.peek()-1];
            }*/
            int ttt=s.pop();
            for(int k=tt.size()-1;k>=0;k--)
            {
                s.push(tt.get(k));
            }
                s.push(ttt);
            //tt.add(s.pop());
            //System.out.println(tt.toString());
            /*for(int k=0;k<tt.size();k++)
            {
                s.push(tt.get(k));
            }*/
            //System.out.println(s.toString());
        }
        pw.println(ans);
        pw.close();
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
