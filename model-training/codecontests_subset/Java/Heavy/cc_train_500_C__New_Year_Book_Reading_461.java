import java.io.*;
import java.util.*;

/**
 * Created by aa on 1/06/2016.
 */
public class A {


    static long x1 , x2;
    public static void main(String [] args) throws  Exception
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt() , m = sc.nextInt();
        int w []  = new int[n];
        for(int i = 0 ; i < n ; ++i) w[i] = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int b [] = new int[m];
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0 ; i < m ; ++i){b[i] = sc.nextInt(); if(!hs.contains(b[i])) {queue.add(b[i]);hs.add(b[i]);}}
        long cnt = 0;
        for(int i = 0 ; i < m ; ++i)
        {
            Queue<Integer> tmp = new LinkedList<>();
            while(true)
            {
                int cur = queue.poll();
                if(cur == b[i]) break;
                else cnt +=w[cur-1];
                tmp.add(cur);
            }
            while (!queue.isEmpty())tmp.add(queue.poll());
            queue.add(b[i]);
            while (!tmp.isEmpty()) queue.add(tmp.poll());
        }
        out.printf("%d" , cnt);
        out.flush();
        out.close();
    }



    static class Line implements  Comparable<Line>{
        long y1 , y2 ;
        public Line(long slope , long yIntercept)
        {
            y1 = slope * x1 + yIntercept;
            y2 = slope * x2 + yIntercept;
        }

        @Override
        public int compareTo(Line o) {
            if(y1 == o.y1)
                return o.y2 - y2 > 0 ? 1 : -1 ;
            return (o.y1 - y1) >0 ? 1:-1;
        }
    }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

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
