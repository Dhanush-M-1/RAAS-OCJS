//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {

    static class Pair<A, B> {

        A parent;
        B rank;

        Pair(A parent, B rank) {
            this.rank = rank;
            this.parent = parent;
        }
    }
    static class Node {
        int ind;
        int value;
        long ans;
        Node(int i) {
            ind=i;
            value=0;
            ans=0;
        }
    }
    static int m=1000000007;
    static ArrayList<Integer> graph[];
    public static void main(String[] args) throws IOException {
        FastReader s1 = new FastReader();
        StringBuilder sb = new StringBuilder();
            int n=s1.I();
            int k=s1.I();
            ArrayList<Integer> com=new ArrayList<>();
            ArrayList<Integer> fir=new ArrayList<>();
            ArrayList<Integer> sec=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                int a=s1.I();
                int b=s1.I();
                int c=s1.I();
                if(b==1 && c==1)
                    com.add(a);
                else if(b==1)
                {
                    fir.add(a);
                }
                else if(c==1)
                    sec.add(a);
            }
            if(com.size()+fir.size()<k || com.size()+sec.size()<k)
            {
                System.out.println("-1");
                System.exit(0);
            }
            Collections.sort(com);
            Collections.sort(fir);
            Collections.sort(sec);
            int x1=0;
            int x2=0;
            int x3=0;
            int count1=0;
            int count2=0;
            long time=0;
            if(fir.size()<k || sec.size()<k)
            {
                int max=Math.max(k-fir.size(), k-sec.size());
                for(int i=0;i<max;i++)
                {
                    time+=com.get(i);
                    x1++;
                    count1++;
                    count2++;
                }
            }
            while(x1<com.size() && x2<fir.size() && x3<sec.size() && (count1<k && count2<k))
            {
                if(com.get(x1)<=fir.get(x2)+sec.get(x3))
                {
                    time+=com.get(x1);
                    x1++;
                }
                else
                {
                    time+=fir.get(x2);
                    time+=sec.get(x3);
                    x2++;
                    x3++;
                }
                    count1++;
                    count2++;
            }
            if(count1<k && count2<k)
            {
                if(x1>=com.size())
                {
                     while(count1<k)
                     {
                         time+=fir.get(x2);
                         x2++;
                         count1++;
                     }
                     while(count2<k)
                     {
                         time+=sec.get(x3);
                         x3++;
                         count2++;
                     }
                }
                else
                {
                    while(count1<k && count2<k)
                    {
                        time+=com.get(x1);
                        x1++;
                        count1++;
                        count2++;
                    }
                }
            }
            if(count1<k)
            {
                while(count1<k)
                {
                    int tim=Integer.MAX_VALUE;
                    if(x1<com.size())
                    {
                        tim=com.get(x1);
                    }
                    if(x2<fir.size() && tim<fir.get(x2))
                    {
                        tim=fir.get(x2++);
                    }
                    else
                        x1++;
                    time+=tim;
                    count1++;
                }
                
            }
            if(count2<k)
            {
                while(count2<k)
                {
                    int tim=Integer.MAX_VALUE;
                    if(x1<com.size())
                    {
                        tim=com.get(x1);
                    }
                    if(x3<sec.size() && tim<sec.get(x3))
                    {
                        tim=sec.get(x3++);
                    }
                    else
                        x1++;
                    time+=tim;
                    count2++;
                }
                
            }
        System.out.println(time);
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