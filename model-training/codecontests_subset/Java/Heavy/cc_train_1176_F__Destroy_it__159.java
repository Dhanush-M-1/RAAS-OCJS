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
        if (id==n)return 0;
        if (memo[taken][id]!=-1)return memo[taken][id];
        long sum=0;
        int max=0;
        int tt=0;
        if (!in[3][id].isEmpty()){
            tt=(1+taken)%10;
            if (taken>tt){
                sum=Math.max(sum,2l*in[3][id].peek()+dp(tt,id+1));
            }
            else {
                sum=Math.max(sum,in[3][id].peek()+dp(tt,id+1));
            }
        }
        if (!in[2][id].isEmpty()){
            tt=(1+taken)%10;
            if (taken>tt){
                sum=Math.max(sum,2l*in[2][id].peek()+dp(tt,id+1));
            }
            else {
                sum=Math.max(sum,in[2][id].peek()+dp(tt,id+1));
            }
            if (!in[1][id].isEmpty()){
                tt=(2+taken)%10;
                if (taken>tt){
                    sum=Math.max(sum,1l*Math.max(in[1][id].peek(),in[2][id].peek())+in[1][id].peek()+in[2][id].peek()+dp(tt,id+1));
                }
                else {
                    sum=Math.max(sum,in[1][id].peek()+in[2][id].peek()+dp(tt,id+1));
                }
            }
        }
        if (!in[1][id].isEmpty()){
            tt=(1+taken)%10;
            if (taken>tt){
                sum=Math.max(sum,2l*in[1][id].peek()+dp(tt,id+1));
            }
            else {
                sum=Math.max(sum,in[1][id].peek()+dp(tt,id+1));
            }
            int x1=in[1][id].poll();
            int x2=0;
            int x3=0;
            if (!in[1][id].isEmpty()){
                x2=in[1][id].poll();
            }
            if (!in[1][id].isEmpty()){
                x3=in[1][id].poll();
            }
            if (x3!=0){
                tt=(taken+3)%10;
                if (taken>tt){
                    sum=Math.max(sum,x1+dp(tt,id+1)+x1+x2+x3);
                }
                else {
                    sum=Math.max(sum,dp(tt,id+1)+x1+x2+x3);
                }
                in[1][id].add(x3);
            }
            if (x2!=0){
                tt=(taken+2)%10;
                if (taken>tt){
                    sum=Math.max(sum,x1+dp(tt,id+1)+x1+x2);
                }
                else {
                    sum=Math.max(sum,dp(tt,id+1)+x1+x2);
                }
                in[1][id].add(x2);
            }
            in[1][id].add(x1);
        }
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