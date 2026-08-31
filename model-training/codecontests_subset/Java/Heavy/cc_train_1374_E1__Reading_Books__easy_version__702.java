/* package codechef; // don't place package name! */


import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.io.*;
/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
    // Complete the maximumSum function below.
    public static class InputReader {
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

    static boolean prime(long a){
        if(a==2||a==3)
            return true;
        if((a-1)%6==0)
            return true;
        if((a+1)%6==0)
            return true;
        return false;
    }
    public static  long gcd(long a,long b){
        if(b==0)
            return a;
        long r=a%b;
        return gcd(b,r);
    }

    static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }




    // private static final FastReader scanner = new FastReader();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int n = Integer.parseInt(line1[0]);
        int k = Integer.parseInt(line1[1]);

        ArrayList<Integer> alice = new ArrayList<Integer>();
        ArrayList<Integer> bob = new ArrayList<Integer>();
        ArrayList<Integer> common = new ArrayList<Integer>();

        while(n-->0)
        {
            String[] line2 = br.readLine().split(" ");
            if(Integer.parseInt(line2[1])==1 && Integer.parseInt(line2[2])==1)
            {
                common.add(Integer.parseInt(line2[0]));
            }
            else if(Integer.parseInt(line2[1])==1)
            {
                alice.add(Integer.parseInt(line2[0]));
            }
            else if(Integer.parseInt(line2[2])==1)
            {
                bob.add(Integer.parseInt(line2[0]));
            }

        }

        Collections.sort(common);
        Collections.sort(alice);
        Collections.sort(bob);

        int commonSize = common.size();

        int sum = 0;
        int ab=0;
        int i=0;

        while(k-->0)
        {
            if(i<commonSize && ab<alice.size() && ab<bob.size())
            {
                if(common.get(i) <= alice.get(ab) + bob.get(ab))
                {
                    sum+=common.get(i);
                    i++;
                }
                else if(common.get(i) > alice.get(ab) + bob.get(ab))
                {
                    sum+= alice.get(ab) + bob.get(ab);
                    ab++;
                }
            }
            else if(i<commonSize)
            {
                sum+=common.get(i);
                i++;
            }
            else if(ab<alice.size() && ab<bob.size())
            {
                sum+= alice.get(ab) + bob.get(ab);
                ab++;
            }
            else
            {
                //System.out.println("Breaking at i= "+i+" and ab = "+ab+"and k is "+k);
                break;
            }


        }

        if(k<0)
            System.out.println(sum);
        else
            System.out.println(-1);
    }
}