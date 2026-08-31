import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int ans = 0;
        for (int i=0;i<N;i++) {
            int A = Integer.parseInt(sc.next());
            if (A==(i+1)) {
                ans++;
                if (i!=N-1) {
                    int pass = Integer.parseInt(sc.next());
                }
                i++;
            }
        }
        System.out.println(ans);
    }
}