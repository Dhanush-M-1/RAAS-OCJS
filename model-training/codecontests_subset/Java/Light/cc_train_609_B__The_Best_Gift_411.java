import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            a.add(0);
        }
        
        int n = sc.nextInt(),
            m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt() - 1;
            a.set(x, a.get(x) + 1);
        }

        int ans = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j < 10; j++) {
                ans += a.get(i) * a.get(j);
            }
        }

        System.out.println(ans);
    }
}
