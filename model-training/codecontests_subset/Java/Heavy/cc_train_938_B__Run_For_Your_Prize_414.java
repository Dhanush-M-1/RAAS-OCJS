import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main
{
    
	static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            try {
                br = new BufferedReader(new InputStreamReader(System.in));
                st = new StringTokenizer("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String next() {
            if (st.hasMoreTokens())
                return st.nextToken();
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String line = "";
            try {
                line = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return line;
        }

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        public char[] nextCharArray() {
            return nextLine().toCharArray();
        }
    }

    static private class gift
    {
	private int position = 0;

	public void setPos(int pos)
	{
		position = pos;
	}

	public int time()
	{
		int[] time = new int[2];
		time[0] = position - 1;
		time[1] = 1000000 - position;
		if(time[0] < time[1])
			return time[0];
		else
			return time[1];
	}
    }
    
    public static gift g()
    {
        return new gift();
    }

    public static void main(String[] args)
    {
	FastScanner fs = new FastScanner();
	int n = fs.nextInt();
	gift[] aG = new gift[n];
	int i = 0;
	while(i < n)
	{
		aG[i] = g();
		aG[i].setPos(fs.nextInt());
		i++;
	}
	i = 0;
	int ans = 0;
	while(i < n)
	{
		int t = aG[i].time();
		if(t > ans)
			ans = t;
		i++;
	}
	System.out.println(ans);
    }
}