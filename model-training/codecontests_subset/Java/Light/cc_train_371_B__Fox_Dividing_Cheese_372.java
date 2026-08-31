import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CF_218_2_B {
    static HashMap<Integer, Integer> weights = new HashMap<>();
    static int ans = 1 << 30;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split("\\s");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        
        f(a, 0);
        f2(b, 0);
        if (ans == 1 << 30)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
    
    static void f(int a, int d) {
        if (weights.containsKey(a))
            return;
        
        weights.put(a, d);

        if (a % 2 == 0)
            f(a / 2, d + 1);
        if (a % 3 == 0)
            f(a / 3, d + 1);
        if (a % 5 == 0)
            f(a / 5, d + 1);
    }
    
    static void f2(int b, int d) {
        if (weights.containsKey(b)) {
            ans = Math.min(ans, d + weights.get(b));
            return;
        }

        if (b % 2 == 0)
            f2(b / 2, d + 1);
        if (b % 3 == 0)
            f2(b / 3, d + 1);
        if (b % 5 == 0)
            f2(b / 5, d + 1);
    }
}
