
import java.util.*;
import java.io.*;
public class Solution{

    static class Pair<A, B> {

        A parent;
        B rank;

        Pair(A parent, B rank) {
            this.rank = rank;
            this.parent = parent;
        }
    }
    static class Node {
        int index;
        int w;
        Node(int k,int l)
        {
            index=k;w=l;
        }
    }
    static class Gnode{
        int v;
        int no;
        Gnode(int g,int i)
        {
            v=g;
            no=i;
        }
    }
    static int m=1000000007;
    static int INF = 100000000;
    static long sum;
    static int count;
    public static void main(String[] args) throws IOException {
        FastReader s1 = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t=s1.I();
        while(t--!=0)
        {
            int n=s1.I();
            int ar[] = new int[n];
            for(int i=0;i<n;i++)
                ar[i]=s1.I();
            if(ar[0]+ar[1]>ar[n-1])
            {
                sb.append("-1\n");
            }
            else
                sb.append("1 2 "+(n)).append("\n");
        }
        System.out.println(sb);
    }
    
    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int I() {
            return Integer.parseInt(next());
        }

        long L() {
            return Long.parseLong(next());
        }

        double D() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    static float power(float x, int y) {
        float temp;
        if (y == 0) {
            return 1;
        }
        temp = power(x, y / 2);

        if (y % 2 == 0) {
            return temp * temp;
        } else {
            if (y > 0) {
                return x * temp * temp;
            } else {
                return (temp * temp) / x;
            }
        }
    }
    static long pow(long x, long y) {
        long res = 1;
        x = x % m;
        if (x < 0) {
            x += m;
        }
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * x) % m;
                if (res < 0) {
                    res += m;
                }
            }
            y = y >> 1;
            x = (x * x) % m;
            if (x < 0) {
                x = x + m;
            }
        }
        res = res % m;
        if (res < 0) {
            res += m;
        }
        return res;
    }

    static void sieveOfEratosthenes(int n) {
        ArrayList<Integer> prime = new ArrayList<Integer>();
        boolean Prime[] = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            Prime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (Prime[p] == true) {
                prime.add(p);
                for (int i = p * p; i <= n; i += p) {
                    Prime[i] = false;
                }
            }
        }
    }
}
