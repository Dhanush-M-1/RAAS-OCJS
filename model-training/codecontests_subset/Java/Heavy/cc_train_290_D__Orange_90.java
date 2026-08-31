import java.io.*;
import java.util.*;

public class Solution {
    public static void main (String[] args) throws IOException {
        boolean online = "true".equals(System.getProperty("ONLINE_JUDGE"));
        if (online) {
            in = new InputReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        else {
            in = new InputReader(new FileReader("input.txt"));
            out = new PrintWriter(new File("output.txt"));
        }
        
        new Solution().run();
        
        out.close();
    }
    
    private void run () {
        char[] s = in.next().toLowerCase().toCharArray();
        int n = in.nextInt();
        for (int i = 0; i < s.length; ++i)
            if (s[i] - 'a' < n)
                s[i] = Character.toUpperCase(s[i]);
        out.println(new String(s));
    }
    
    private static InputReader in;
    private static PrintWriter out;
}

class InputReader {
    public InputReader (Reader r) {
        buff = new BufferedReader(r);
        try {
            str = new StringTokenizer(buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String next () {
        while (!str.hasMoreTokens())
            try {
                str = new StringTokenizer(buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return str.nextToken();
    }
    
    public int nextInt () {
        return Integer.parseInt(this.next());
    }
    
    public long nextLong () {
        return Long.parseLong(this.next());
    }
    
    private static BufferedReader buff;
    private static StringTokenizer str;
}