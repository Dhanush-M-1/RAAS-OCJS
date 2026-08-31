import java.io.*;
import java.util.*;
public class temp
{
    public static void main(String [] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String a = in.readLine();
        String b = in.readLine();
        String c = in.readLine();
        int[] aa = new int[26];
        int[] bb = new int[26];
        int[] cc = new int[26];
        for (int i = 0; i < a.length(); i++)
            aa[a.charAt(i)-'a']++;
        for (int i = 0; i < b.length(); i++)
            bb[b.charAt(i)-'a']++;
        for (int i = 0; i < c.length(); i++)
            cc[c.charAt(i)-'a']++;
        int bbb = Integer.MAX_VALUE;
        int ccc = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++)
            {
                if (bb[i] > 0)
                    bbb = Math.min(bbb, aa[i]/bb[i]);
                if (cc[i] > 0)
                    ccc = Math.min(ccc, aa[i]/cc[i]);
            }
        while (bbb > 0 || ccc > 0)
        {
            if (bbb > ccc)
            {
                System.out.print(b);
                aa = subtract(aa,bb);
            }
            else
            {
                System.out.print(c);
                aa = subtract(aa,cc);
            }
            for (int i = 0; i < 26; i++)
            {
                if (bb[i] > 0)
                    bbb = Math.min(bbb, aa[i]/bb[i]);
                if (cc[i] > 0)
                    ccc = Math.min(ccc, aa[i]/cc[i]);
            }
        }
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < aa[i]; j++)
                System.out.print((char)('a'+i));
    }
    public static int[] subtract(int[] a, int[] b)
    {
        int[] ret = new int[26];
        for (int i = 0; i < 26; i++)
            ret[i] = a[i] - b[i];
        return ret;
    }
}