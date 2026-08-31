import java.io.*;
import java.util.*;

public class D2
{
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    long MOD = 998244353;

    public void go() throws IOException
    {
        long[] POW = new long[19];
        POW[0] = 1;
        for (int i = 1; i < 19; i++)
        {
            POW[i] = POW[i-1] * 10;
        }
        StringTokenizer tok = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tok.nextToken());
        long[] nums = new long[n];
        int[] len = new int[n];
        tok = new StringTokenizer(in.readLine());
        int[] freq = new int[11];
        for (int i = 0; i < n; i++)
        {
            String s = tok.nextToken();
            freq[s.length()]++;
            nums[i] = Long.parseLong(s);
            len[i] = s.length();
        }
        long total = 0;
        for (int i = 0; i < n; i++)
        {
            for (int f = 10; f >= 1; f--)
            {
                if (len[i] > f)
                {
                    long l = Long.remainderUnsigned(lower(nums[i] % POW[f]), MOD);
                    long u = Long.remainderUnsigned(upper(nums[i] % POW[f]), MOD);
                    total = (total + l*freq[f] % MOD + u*freq[f] % MOD) % MOD;
                    total = (total + nums[i]/POW[f]*POW[f*2]%MOD*2*freq[f]%MOD) % MOD;
                    if (freq[f] > 0)
                    {
                        // out.printf("(%d,%d) %d %d x%d %dx%d%n", nums[i], f, u, l, freq[f], nums[i]/POW[f]*POW[f*2], freq[f]*2);
                    }
                }
                else
                {
                    long l = Long.remainderUnsigned(lower(nums[i]), MOD);
                    long u = Long.remainderUnsigned(upper(nums[i]), MOD);
                    total = (total + u*freq[f]%MOD + l*freq[f]%MOD) % MOD;
                    if (freq[f] > 0)
                    {
                        // out.printf("(%d,%d) %d %d x%d%n", nums[i], f, u, l, freq[f]);
                    }
                }
            }
        }
        out.println(total);

        out.flush();
        in.close();
    }

    public long upper(long n)
    {
        long x = 0;
        long k = 0;
        while (n > 0)
        {
            x *= 10;
            x += n % 10;
            n /= 10;
            k++;
        }
        while (k > 0)
        {
            n *= 10;
            n += x % 10;
            n *= 10;
            x /= 10;
            k--;
        }
        return n;
    }

    public long lower(long n)
    {
        long x = 0;
        long k = 0;
        while (n > 0)
        {
            x *= 10;
            x += n % 10;
            n /= 10;
            k++;
        }
        while (k > 0)
        {
            n *= 10;
            n *= 10;
            n += x % 10;
            x /= 10;
            k--;
        }
        return n;
    }

    public static void main(String[] args) throws IOException
    {
        new D2().go();
    }
}
