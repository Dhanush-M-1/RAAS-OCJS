import java.io.*;
import java.util.*;

public class Solution
{

    public static void main(String[] args)
    {
        Reader in = new Reader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        Point pnts[] = new Point[3];
        boolean ans = false;

        for(int i = 0;i < 3;i++)
        {
            long x = in.nextLong() ,
                    y = in.nextInt();
            pnts[i] = new Point(x , y);
        }

        ans = !isLinear(pnts) && (squaredDis(pnts[0] , pnts[1]) ==
                                 squaredDis(pnts[1] , pnts[2]));

        out.println(ans ? "YES" : "NO");
        out.close();
    }

    public static long squaredDis(Point a , Point b)
    {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public static boolean isLinear(Point[] pnts)
    {
        return (pnts[0].y - pnts[1].y) * (pnts[0].x - pnts[2].x) ==
               (pnts[0].y - pnts[2].y) * (pnts[0].x - pnts[1].x);
    }

    static class Point
    {
        long x;
        long y;

        public Point(long x , long y)
        {
            this.x = x;
            this.y = y;
        }
    }
	
    static class Reader
    {

        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public Reader(InputStream in)
        {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }

        public String next()
        {
            while(tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try
                {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt()
        {
            return Integer.parseInt(next());
        }

        public long nextLong()
        {
            return Long.parseLong(next());
        }

    }

}