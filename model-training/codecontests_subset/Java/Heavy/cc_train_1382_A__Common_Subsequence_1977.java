
import java.io.*;
import java.util.*;
import java.util.List;

public class AA implements Runnable {
    static int mod9=1000000007;
    public void run() {
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int i=0,j=0,k=0;
        int t=0;
        t=sc.nextInt();
        while (t-->0)
        {
            int an=sc.nextInt();
            int bn=sc.nextInt();
            HashSet<Integer> set=new HashSet<>();
            boolean flag=false;
            for (i=0;i<an;i++)
                set.add(sc.nextInt());
            for (i=0;i<bn;i++)
            {
                int temp=sc.nextInt();
                if (set.contains(temp)&&!flag)
                {
                    out.println("YES");
                    out.println("1 "+temp);
                    flag=true;
                }
            }
            if (!flag)
                out.println("NO");

        }













//=======================================================================================================================================

        out.flush();
        out.close();
    }

    private static void findsubsequences(String s, String ans,List<String> al) {
        if(s.length()==0)
        {
            al.add(ans);
            return;
        }
        findsubsequences(s.substring(1),ans+s.charAt(0),al) ;
        findsubsequences(s.substring(1),ans,al);
    }


//=======================================================================================================================================

    static boolean isValid(Pair x,int n,int m)
    {
        return x.a>=0 && x.a<n && x.b>=0 && x.b<m;
    }
    static int dx[]={0,0,1,-1};
    static int dy[]={1,-1,0,0};
    static class Pair
    {
        int a,b;
        Pair(int aa,int bb)
        {
            a=aa;
            b=bb;
        }
        public String toString()
        {
            return a+" "+b;
        }
    }
    int[] sa(int n,InputReader sc)
    {
        int arr[]=new int[n];
        for (int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        return arr;
    }

    static class PairSort implements Comparator<Pair>
    {
        public int compare(Pair a,Pair b)
        {
            return b.b-a.b;
        }
    }


    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();

            while(isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
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

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    public static void main(String args[]) throws Exception {
        new Thread(null, new AA(),"Main",1<<27).start();
    }
}