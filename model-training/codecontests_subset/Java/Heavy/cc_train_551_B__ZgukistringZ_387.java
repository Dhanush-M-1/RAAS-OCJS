import java.io.*;
import java.util.*;
public class B551 {
public static void main(String[] args) throws IOException {
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    String a = input.next(), b = input.next(), c = input.next();
    int[] fa = f(a), fb = f(b), fc = f(c);
    int maxb = 0, maxc = 0;
    int curb = -1;
    while(true)
    {
        curb++;
        boolean good = true;
        for(int i = 0; i<26; i++)
        {
            good &= curb * fb[i] <= fa[i];
        }
        if(!good) break;
        int curc = 100000000;
        for(int i = 0; i<26; i++)
        {
            if(fc[i] == 0) continue;
            int left = fa[i] - fb[i] * curb;
            curc = Math.min(curc, left / fc[i]);
        }
        if(curb + curc > maxb + maxc)
        {
            maxb = curb;
            maxc = curc;
        }
    }
    for(int i = 0; i<maxb; i++) out.print(b);
    for(int i = 0; i<maxc; i++) out.print(c);
    for(int i = 0; i<26; i++)
    {
        int left = fa[i] - maxb * fb[i] - maxc * fc[i];
        for(int j = 0; j<left; j++) out.print((char)('a'+i));
    }
    out.close();
}
static int[] f(String s)
{
    int[] res = new int[26];
    for(int i = 0; i<s.length(); i++) res[s.charAt(i) - 'a']++;
    return res;
}
public static class input {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
    reader = new BufferedReader(new InputStreamReader(input));
    tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
    while (!tokenizer.hasMoreTokens())
        tokenizer = new StringTokenizer(reader.readLine());
    return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
    return Integer.parseInt(next());
    }

    static double nextDouble() throws IOException {
    return Double.parseDouble(next());
    }

    static long nextLong() throws IOException {
    return Long.parseLong(next());
    }
}
}
