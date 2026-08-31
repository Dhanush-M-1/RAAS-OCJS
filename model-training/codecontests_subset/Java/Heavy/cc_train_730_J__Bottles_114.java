import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class F_special4
{
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer = null;
    private static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    private static String next() throws IOException
    {
        while ((stringTokenizer == null) || (!stringTokenizer.hasMoreTokens()))
        {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }
        return stringTokenizer.nextToken();
    }

    public static int nextInt() throws IOException
    {
        return Integer.parseInt(next());
    }

    public static double nextDouble() throws IOException
    {
        return Double.parseDouble(next());
    }

    public static long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    public static String nextLine() throws IOException
    {
        return bufferedReader.readLine();
    }

    public static void close()
    {
        out.close();
    }

    public static final long[] POWER2 = generatePOWER2();

    public static long[] generatePOWER2()
    {
        long[] result = new long[63];
        for (int x = 0; x < result.length; x++)
        {
            result[x] = 1L << x;
        }
        return result;
    }

    public static class Tuple2<T0, T1>
    {
        public final T0 v0;
        public final T1 v1;

        public Tuple2(T0 v0, T1 v1)
        {
            this.v0 = v0;
            this.v1 = v1;
        }
    }

    public static class Tuple2Comparable<T0 extends Comparable<? super T0>, T1 extends Comparable<? super T1>> extends Tuple2<T0, T1> implements Comparable<Tuple2Comparable<T0, T1>>
    {
        public Tuple2Comparable(T0 v0, T1 v1)
        {
            super(v0, v1);
        }

        @Override
        public int compareTo(Tuple2Comparable<T0, T1> that)
        {
            int result = this.v0.compareTo(that.v0);
            if (result == 0)
            {
                result = this.v1.compareTo(that.v1);
            }
            return result;
        }
    }

    public static long faculty(int n)
    {
        long result = 1;
        for (int index = 2; index <= n; index++)
        {
            result *= index;
        }
        return result;
    }

    public static <T> List<T> permutation(long p, List<T> x)
    {
        List<T> copy = new ArrayList<>();
        for (int index = 0; index < x.size(); index++)
        {
            copy.add(x.get(index));
        }
        List<T> result = new ArrayList<>();
        for (int indexTo = 0; indexTo < x.size(); indexTo++)
        {
            int indexFrom = (int) p % copy.size();
            p = p / copy.size();
            result.add(copy.remove(indexFrom));
        }
        return result;
    }

    public static void main(String[] args)
    {
        try
        {
            solve();
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
        close();
    }

    static class Bottle
    {
        public final int amount;
        public final int volume;

        public Bottle(int amount, int volume)
        {
            this.amount = amount;
            this.volume = volume;
        }
    }

    public static Integer add(Integer x0, int x1)
    {
        return x0 == null ? null : x0 + x1;
    }

    public static Integer min(Integer x0, Integer x1)
    {
        Integer result;
        if (x0 == null)
        {
            result = x1;
        }
        else
        {
            if (x1 == null)
            {
                result = x0;
            }
            else
            {
                result = Math.min(x0, x1);
            }
        }
        return result;
    }

    public static void solve() throws IOException
    {
        int n = nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        Bottle[] bottles = new Bottle[n];
        int amountTotal = 0;
        for (int index = 0; index < n; index++)
        {
            a[index] = nextInt();
        }
        for (int index = 0; index < n; index++)
        {
            b[index] = nextInt();
        }
        for (int index = 0; index < n; index++)
        {
            Bottle bottle = new Bottle(a[index], b[index]);
            bottles[index] = bottle;
            amountTotal += bottle.amount;
        }
        Arrays.sort(bottles, (x0, x1) -> Integer.compare(x1.volume, x0.volume));
        int bottlesTotal = 0;
        int volumeTotal = 0;
        while (volumeTotal < amountTotal)
        {
            volumeTotal += bottles[bottlesTotal].volume;
            bottlesTotal += 1;
        }
        Integer[][] bottleCountVolume2AmountPouredMinimum = new Integer[bottlesTotal + 1][10001];
        bottleCountVolume2AmountPouredMinimum[0][0] = 0;
        for (Bottle bottle : bottles)
        {
            for (int bottleCount = bottlesTotal; bottleCount >= 0; bottleCount--)
            {
                for (int volume = 0; volume <= 10000; volume++)
                {
                    if (bottleCount == 0 || volume < bottle.volume)
                    {
                        bottleCountVolume2AmountPouredMinimum[bottleCount][volume] = add(bottleCountVolume2AmountPouredMinimum[bottleCount][volume], bottle.amount);
                    }
                    else
                    {
                        bottleCountVolume2AmountPouredMinimum[bottleCount][volume] =
                                min(
                                        add(bottleCountVolume2AmountPouredMinimum[bottleCount][volume], bottle.amount),
                                        bottleCountVolume2AmountPouredMinimum[bottleCount - 1][volume - bottle.volume]
                                );
                    }
                }
            }
        }
        Integer result = Stream
                .of(bottleCountVolume2AmountPouredMinimum[bottlesTotal])
                .skip(amountTotal)
                .reduce(null, (x, y) -> min(x, y));
        out.println(bottlesTotal + " " + result);
    }
}
