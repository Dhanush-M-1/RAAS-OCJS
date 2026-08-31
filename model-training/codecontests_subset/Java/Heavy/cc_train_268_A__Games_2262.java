import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> home = new HashMap<>();
        Map<Integer, Integer> away = new HashMap<>();
        int ans = 0;

        while (n-- > 0) {
            st = new StringTokenizer(f.readLine());
            int h = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            if (home.containsKey(a)) {
                ans += home.get(a);
            }
            if (away.containsKey(h)) {
                ans += away.get(h);
            }
            home.put(h, home.getOrDefault(h, 0) + 1);
            away.put(a, away.getOrDefault(a, 0) + 1);
        }
        out.println(ans);
        out.close();
    }
}
