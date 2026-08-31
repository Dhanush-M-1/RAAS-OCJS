import java.util.*;
import java.io.*;
import java.math.*;

public class test {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        int tc = Integer.parseInt(in.readLine());
        while (tc != 0) {
            String tmp[] = in.readLine().split(" ");
            int n = Integer.parseInt(tmp[0]);
            int m = Integer.parseInt(tmp[1]);
            String s = in.readLine();
            char []ss = s.toCharArray();
            int []grid = new int[n];
            int []freq = new int[26];
            String tmp2[] = in.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                grid[Integer.parseInt(tmp2[i]) - 1]++;
            }
            for (int i = n - 1; i >= 0; i--) {
                grid[i] += (i + 1 == n ? 0 : grid[i + 1]);
                freq[ss[i] - 'a'] += 1 + grid[i];
            }
            for (int i = 0; i < 26; i++)
                out.printf("%d ", freq[i]);
            out.printf("%n");
            tc--;
        }
        out.flush();
    }
}