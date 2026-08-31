import java.awt.Point;
import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class PracticeProblem
{
    /*
     * This FastReader code is taken from GeeksForGeeks.com
     * https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
     *
     * The article was written by Rishabh Mahrsee
     */
    public static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static FastReader in = new FastReader();
    public static PrintWriter out = new PrintWriter(System.out);
    public static final int MOD = (int)1e9 + 7;
    public static int[] rDir = {-1, -1, -1, 0, 0, +1, +1, +1};
    public static int[] cDir = {-1, 0, +1, -1, +1, -1, 0, +1};
    public static int MAX = (int)1e9;

    public static void main(String[] args)
    {
        solve();

        out.close();
    }

    public static void solve()
    {
        int startR = in.nextInt(), startC = in.nextInt(), endR = in.nextInt(), endC = in.nextInt();

        Map<Integer, Set<Integer>> map = new HashMap<>();

        int n = in.nextInt();

        for (int i = 0; i < n; i++)
        {
            int r = in.nextInt(), a = in.nextInt(), b = in.nextInt();

            if (!map.containsKey(r))
                map.put(r, new HashSet<>());

            for (int j = a; j <= b ; j++)
            {
                map.get(r).add(j);
            }
        }

        // Do a BFS to find the shortest path from start to end using only the allowed spaces
        Queue<Integer> qR = new LinkedList<>();
        Queue<Integer> qC = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        int distance = -1;

        qR.add(startR);
        qC.add(startC);

        while (!qR.isEmpty())
        {
            distance++;
            int size = qR.size();
            for (int i = 0; i < size; i++)
            {
                int r = qR.poll();
                int c = qC.poll();

                if (r == endR && c == endC)
                {
                    out.println(distance);
                    return;
                }

                if (visited.contains(new Point(r, c)))
                    continue;

                visited.add(new Point(r, c));

                for (int dir = 0; dir < rDir.length; dir++)  // Foreach neighbor of this point
                {
                    int newR = r + rDir[dir];
                    int newC = c + cDir[dir];

                    if (newR <= MAX && newR >= 1 && newC <= MAX && newC >= 1 && !visited.contains(new Point(newR, newC))) // If this point is in bounds of the field and it has not already been visited
                    {
                        if (map.containsKey(newR) && map.get(newR).contains(newC)) // And If this neighbor is a valid point
                        {
                            // Add it to the queue
                            qR.add(newR);
                            qC.add(newC);
                        }
                    }
                }
            }
        }

        out.println(-1);
    }

}
