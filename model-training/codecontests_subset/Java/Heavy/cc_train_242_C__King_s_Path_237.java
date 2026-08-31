import java.awt.print.Book;
import java.util.*;
import java.io.*;
import java.math.*;

public class Main
{

    final static int mod = 1000000007;
    static FastReader sc;
    static PrintWriter out;
    static boolean test_case_input = false;

    static long size = 1000000000;

    public static long value(long a, long b)
    {
        return (a - 1) * size + b;
    }

    public static long up(long pos)
    {
        long ans = pos - size;
        if (ans < 1 || ans > (long) Math.pow(size, 2)) return -1;
        else return ans;
    }

    public static long down(long pos)
    {
        long ans = pos + size;
        if (ans < 1 || ans > (long) Math.pow(size, 2)) return -1;
        else return ans;
    }

    public static long left(long pos)
    {
        long ans = pos - 1;
        if (ans < 1 || ans > (long) Math.pow(size, 2)) return -1;
        else return ans;
    }

    public static long right(long pos)
    {
        long ans = pos + 1;
        if (ans < 1 || ans > (long) Math.pow(size, 2)) return -1;
        else return ans;
    }

    public static long topleft(long pos)
    {
        long ans = pos - size - 1;
        if (ans < 1 || ans > (long) Math.pow(size, 2)) return -1;
        else return ans;
    }

    public static long topright(long pos)
    {
        long ans = pos - size + 1;
        if (ans < 1 || ans > (long) Math.pow(size, 2)) return -1;
        else return ans;
    }

    public static long bottomleft(long pos)
    {
        long ans = pos + size - 1;
        if (ans < 1 || ans > (long) Math.pow(size, 2)) return -1;
        else return ans;
    }

    public static long bottomright(long pos)
    {
        long ans = pos + size + 1;
        if (ans < 1 || ans > (long) Math.pow(size, 2)) return -1;
        else return ans;
    }

    public static void solution() throws IOException
    {
        // code
        Map<Long, Boolean> map = new HashMap<>();
        long x0 = sc.nextLong();
        long y0 = sc.nextLong();
        long x1 = sc.nextLong();
        long y1 = sc.nextLong();
        long n = sc.nextLong();
        for (long i = 0; i < n; i++)
        {
            long r = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();

            for (long c = a; c <= b; c++)
            {
                long pos = value(r, c);
                if (!map.containsKey(pos)) map.put(pos, true);
            }
        }
        long start = value(x0, y0);
        long end = value(x1, y1);
        out.println(bfs(map, start, end));
    }

    private static long bfs(Map<Long, Boolean> map, long start, long end)
    {
        long count = 0;
        Queue<Long> q = new LinkedList<>();
        Queue<Long> level = new LinkedList<>();
        q.add(start);
        Map<Long, Boolean> visited = new HashMap<>();
        visited.put(start, true);
        boolean found = false;
        while (!q.isEmpty())
        {
            long temp = q.poll();
            if (temp == end) {
                found = true;
                break;
            }
            long up = up(temp), down = down(temp), right = right(temp), left = left(temp),
            topleft = topleft(temp), topright = topright(temp), bottomleft = bottomleft(temp), bottomright = bottomright(temp);
            if (up != -1 && !visited.containsKey(up) && map.containsKey(up))
            {
                visited.put(up, true);
                level.add(up);
            }
            if (left != -1 && !visited.containsKey(left) && map.containsKey(left))
            {
                visited.put(left, true);
                level.add(left);
            }
            if (right != -1 && !visited.containsKey(right) && map.containsKey(right))
            {
                visited.put(right, true);
                level.add(right);
            }
            if (down != -1 && !visited.containsKey(down) && map.containsKey(down))
            {
                visited.put(down, true);
                level.add(down);
            }
            if (topleft != -1 && !visited.containsKey(topleft) && map.containsKey(topleft))
            {
                visited.put(topleft, true);
                level.add(topleft);
            }
            if (topright != -1 && !visited.containsKey(topright) && map.containsKey(topright))
            {
                visited.put(topright, true);
                level.add(topright);
            }
            if (bottomleft != -1 && !visited.containsKey(bottomleft) && map.containsKey(bottomleft))
            {
                visited.put(bottomleft, true);
                level.add(bottomleft);
            }
            if (bottomright != -1 && !visited.containsKey(bottomright) && map.containsKey(bottomright))
            {
                visited.put(bottomright, true);
                level.add(bottomright);
            }

            if (q.isEmpty())
            {
                count++;
                q = level;
                debug("Level", level);
                level = new LinkedList<>();
            }
        }
        return (!found) ? -1 : count;
    }

    // log A base B
    public static int logint(int x, int base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }

    public static int logint(long x, long base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }

    public static int logint(double x, double base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }

    public static double logdouble(int x, int base)
    {
        return (Math.log(x) / Math.log(base));
    }

    public static double logdouble(long x, long base)
    {
        return (Math.log(x) / Math.log(base));
    }

    public static double logdouble(double x, double base)
    {
        return (Math.log(x) / Math.log(base));
    }

    public static long loglong(int x, int base)
    {
        return (long) (Math.log(x) / Math.log(base));
    }

    public static long loglong(long x, long base)
    {
        return (long) (Math.log(x) / Math.log(base));
    }

    public static long loglong(double x, double base)
    {
        return (long) (Math.log(x) / Math.log(base));
    }

    // Debug
    public static void debug(String msg, Object value)
    {
        File output = new File("output.txt");
        if (!output.exists()) return;
        String type = value.getClass().getSimpleName();
        if (type.equals("int[]")) out.println(msg + " => " + Arrays.toString((int[]) value));
        else if (type.equals("double[]")) out.println(msg + " => " + Arrays.toString((double[]) value));
        else if (type.equals("float[]")) out.println(msg + " => " + Arrays.toString((float[]) value));
        else if (type.equals("long[]")) out.println(msg + " => " + Arrays.toString((long[]) value));
        else if (type.equals("char[]")) out.println(msg + " => " + Arrays.toString((char[]) value));
        else if (type.equals("String[]")) out.println(msg + " => " + Arrays.toString((String[]) value));
        else if (type.equals("int[][]")) out.println(msg + " => " + Arrays.deepToString((int[][]) value));
        else if (type.equals("double[][]")) out.println(msg + " => " + Arrays.deepToString((double[][]) value));
        else if (type.equals("float[][]")) out.println(msg + " => " + Arrays.deepToString((float[][]) value));
        else if (type.equals("long[][]")) out.println(msg + " => " + Arrays.deepToString((long[][]) value));
        else if (type.equals("char[][]")) out.println(msg + " => " + Arrays.deepToString((char[][]) value));
        else if (type.equals("String[][]")) out.println(msg + " => " + Arrays.deepToString((String[][]) value));
        else out.println(msg + " => " + value);
    }

    public static void debug(Object value)
    {
        File output = new File("output.txt");
        if (!output.exists()) return;
        String type = value.getClass().getSimpleName();
        if (type.equals("int[]")) out.println(" => " + Arrays.toString((int[]) value));
        else if (type.equals("double[]")) out.println(" => " + Arrays.toString((double[]) value));
        else if (type.equals("float[]")) out.println(" => " + Arrays.toString((float[]) value));
        else if (type.equals("long[]")) out.println(" => " + Arrays.toString((long[]) value));
        else if (type.equals("char[]")) out.println(" => " + Arrays.toString((char[]) value));
        else if (type.equals("String[]")) out.println(" => " + Arrays.toString((String[]) value));
        else if (type.equals("int[][]")) out.println(" => " + Arrays.deepToString((int[][]) value));
        else if (type.equals("double[][]")) out.println(" => " + Arrays.deepToString((double[][]) value));
        else if (type.equals("float[][]")) out.println(" => " + Arrays.deepToString((float[][]) value));
        else if (type.equals("long[][]")) out.println(" => " + Arrays.deepToString((long[][]) value));
        else if (type.equals("char[][]")) out.println(" => " + Arrays.deepToString((char[][]) value));
        else if (type.equals("String[][]")) out.println(" => " + Arrays.deepToString((String[][]) value));
        else out.println(" => " + value);
    }

    // Graph Functions
    public static void addUndirectedEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void addDirectedEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
    }

    public static void addUndirectedEdge(ArrayList<ArrayList<Point>> adj, int u, int v, int weight)
    {
        adj.get(u).add(new Point(v, weight));
        adj.get(v).add(new Point(u, weight));
    }

    public static void addDirectedEdge(ArrayList<ArrayList<Point>> adj, int u, int v, int weight)
    {
        adj.get(u).add(new Point(v, weight));
    }

    public static <T> void displayGraph(String msg, ArrayList<ArrayList<T>> adj)
    {
        out.println(msg + ":");
        int count = 0;
        for (ArrayList<T> i : adj)
        {
            out.print("\t" + count++ + ": ");
            for (T j : i)
            {
                out.print(j + " ");
            }
            out.println();
        }
    }

    // GCD
    public static int __gcd(int a, int b)
    {
        BigInteger n1 = BigInteger.valueOf(a);
        BigInteger n2 = BigInteger.valueOf(b);
        BigInteger gcd = n1.gcd(n2);
        return gcd.intValue();
    }

    public static long __gcd(long a, long b)
    {
        BigInteger n1 = BigInteger.valueOf(a);
        BigInteger n2 = BigInteger.valueOf(b);
        BigInteger gcd = n1.gcd(n2);
        return gcd.longValue();
    }

    public static void main(String args[]) throws IOException
    {
        long start = 0, end = 0;
        try
        {
            File output = new File("output.txt");
            sc = new FastReader();
            if (output.exists())
            {
                out = new PrintWriter(new FileOutputStream("output.txt"));
                start = System.nanoTime();
            } else
            {
                out = new PrintWriter(System.out);
            }

            int test_cases = 1;
            if (test_case_input) test_cases = sc.nextInt();
            while (test_cases-- > 0)
            {
                solution();
            }
            if (output.exists())
            {
                end = System.nanoTime();
                out.println("Execution time: " + (end - start) / 1000000 + " ms");
            }
            out.flush();
            out.close();
        } catch (Exception e)
        {
            out.println("Exception: " + e);
            out.println("At Line no. : " + e.getStackTrace()[0].getLineNumber());
            out.flush();
            out.close();
            return;
        }
    }

    // Point Class
    static class Point
    {
        Object x;
        Object y;

        public Point(Object a, Object b)
        {
            x = a;
            y = b;
        }

        public String toString()
        {
            String ans = "(" + x + ", " + y + ")";
            return ans;
        }

        @Override
        public int hashCode()
        {
            int hash = 7;
            hash = 71 * hash + (int) this.x;
            hash = 71 * hash + (int) this.y;
            return hash;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (obj == null) return false;
            Point point = (Point) obj;
            if (point.x == this.x && point.y == this.y) return true;
            else return false;
        }
    }

    // Fast IO
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException
        {
            File in = new File("input.txt");
            if (in.exists())
            {
                br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            } else
            {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e)
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

        float nextFloat()
        {
            return Float.parseFloat(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        int[] intarr(int n)
        {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Integer.parseInt(next());
            }
            return a;
        }

        long[] longarr(int n)
        {
            long a[] = new long[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Long.parseLong(next());
            }
            return a;
        }

        float[] floatarr(int n)
        {
            float a[] = new float[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Float.parseFloat(next());
            }
            return a;
        }

        double[] doublearr(int n)
        {
            double a[] = new double[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Double.parseDouble(next());
            }
            return a;
        }


        int[][] intmatrix(int row, int col)
        {
            int a[][] = new int[row][col];
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    a[i][j] = Integer.parseInt(next());
                }
            }
            return a;
        }

        long[][] longmatrix(int row, int col)
        {
            long a[][] = new long[row][col];
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    a[i][j] = Long.parseLong(next());
                }
            }
            return a;
        }

        float[][] floatmatrix(int row, int col)
        {
            float a[][] = new float[row][col];
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    a[i][j] = Float.parseFloat(next());
                }
            }
            return a;
        }

        double[][] doublematrix(int row, int col)
        {
            double a[][] = new double[row][col];
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < col; j++)
                {
                    a[i][j] = Double.parseDouble(next());
                }
            }
            return a;
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}