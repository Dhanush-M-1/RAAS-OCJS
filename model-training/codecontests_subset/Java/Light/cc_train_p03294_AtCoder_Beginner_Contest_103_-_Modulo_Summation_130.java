import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Your code here!
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long ans = 0;
        while (n-- > 0) {
            ans += sc.nextLong() - 1;
        }
        
        System.out.println(ans);
    }
}