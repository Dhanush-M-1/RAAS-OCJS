import java.io.*;
import java.util.*;

public class l{
    static class pair implements Comparable<pair>{
        int num,val;
        pair(int a ,int b){
            num=a;
            val=b;
        }

        @Override
        public int compareTo(pair pair) {
            return pair.val-val;
        }
        public String toString(){
            return num+" "+val;
        }
    }
    static long[][]memo;
    static PriorityQueue<Integer>[][]in;
    static int n;
    static long dp(int taken,int id){
        if (id==n)return 0l;
        if (memo[taken][id]!=-1)return memo[taken][id];
        long sum=0;
        int tt=0;
        int x1=Math.max(in[1][id].peek(),Math.max(in[2][id].peek(),in[3][id].peek()));
        if (x1!=0) {
            tt = (1 + taken) % 10;
            if (taken > tt) {
                sum = Math.max(sum, 2l * x1 + dp(tt, id + 1));
            } else {
                sum = Math.max(sum, x1 + dp(tt, id + 1));
            }
        }
        x1=in[1][id].poll();
        if (x1!=0) {
            int x2 = in[1][id].poll();
            int m = 0;
            int g = x1;
            if (x2 != 0) {
                m = x1 + x2;
                g = Math.max(x1, x2);
            }
            in[1][id].add(x2);
            x2 = in[2][id].poll();
            if (x2 != 0) {
                m = Math.max(x1 + x2, m);
                g = Math.max(x1, x2);
            }
            in[2][id].add(x2);
            if (m != 0) {
                tt = (2 + taken) % 10;
                if (taken > tt) {
                    sum = Math.max(sum, 1l * g + dp(tt, id + 1) + m);
                } else {
                    sum = Math.max(sum, m + dp(tt, id + 1));
                }
            }
        }
        int x2=in[1][id].poll();
        int x3=in[1][id].poll();
        if (x1!=0&&x2!=0&&x3!=0){
            tt = (3 + taken) % 10;
            if (taken > tt) {
                sum = Math.max(sum, 2l * x1+ x2+x3+ dp(tt, id + 1));
            } else {
                sum = Math.max(sum, 1l*x1+x2+x3+dp(tt, id + 1));
            }
        }
        in[1][id].add(x1);
        in[1][id].add(x2);
        in[1][id].add(x3);
        sum=Math.max(sum,dp(taken,id+1));
        return memo[taken][id]=sum;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        n = sc.nextInt();
        in = new PriorityQueue[4][n];
        for (PriorityQueue[]a:in){
            for (int i =0;i<a.length;i++){
                a[i]= new PriorityQueue(Collections.reverseOrder());
                a[i].add(0);
                a[i].add(0);
                a[i].add(0);
            }
        }
        for (int i =0;i<n;i++){
            int k = sc.nextInt();
            while (k-->0){
                in[sc.nextInt()][i].add(sc.nextInt());
            }
        }
        memo= new long[11][n+10];
        for (long[]x:memo){
            Arrays.fill(x,-1);
        }
        pw.println(dp(0,0));
      //  pw.println(Arrays.deepToString(memo));
        pw.flush();
    }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;
        public Scanner(FileReader r){
            br= new BufferedReader(r);
        }
        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException
        {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if(x.charAt(0) == '-')
            {
                neg = true;
                start++;
            }
            for(int i = start; i < x.length(); i++)
                if(x.charAt(i) == '.')
                {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                }
                else
                {
                    sb.append(x.charAt(i));
                    if(dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg?-1:1);
        }

        public boolean ready() throws IOException {return br.ready();}


    }
}