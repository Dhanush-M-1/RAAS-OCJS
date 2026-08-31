import java.io.*;
import java.util.*;
public class A615 {
public static void main(String[] args) throws IOException {
    input.init(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = input.nextInt(), m = input.nextInt();
    HashSet<Integer> set = new HashSet<Integer>();
    for(int i = 0; i<n; i++)
    {
        int k = input.nextInt();
        for(int j = 0; j<k; j++) set.add(input.nextInt());
    }
    if(set.size() == m) out.println("YES");
    else out.println("NO");
    out.close();
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
