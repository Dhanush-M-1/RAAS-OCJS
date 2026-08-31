import java.util.*;

public class Main {
    static int n;
    static PriorityQueue<List<Integer>> que = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        String str = "";
        dfs(0, str, 0, 0);
        
        
    }
    
    public static void dfs(int x, String str, int count, int max) {
        char c = (char)(x + 'a');
        str += c;
        count++;
        if (count == n) {
            System.out.println(str);
            return;
        }
        
        max = Math.max(x, max);
        for (int i = 0; i <= max + 1; i++) {
            dfs(i, str, count, max);
        }
        
        // if (max > x) {
        //     for (int i = 0; i <= Math.max(max, x + 1); i++) {
        //         max = Math.max(max, i);
        //         dfs(i, str, count, max);
        //     }
        // } else {
        //     for (int i = 0; i <= Math.max(max, x + 1); i++) {
        //         max = Math.max(max, i);
        //         dfs(i, str, count, max);
        //     }
        // }
    }
}
