import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        ArrayList<Integer> bits = new ArrayList<>(n);
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String line = sc.nextLine();
        for (int i = 0; i < n; i++) {
            int a = line.charAt(i) - '0';
            bits.add(a);
        }
        int ans = 0;
        for (int i = bits.size() - x; i < bits.size(); i++) {
            int cur = bits.get(i);
            if (i == n - 1 - y && cur == 0) ans++;
            if (i != n - 1 - y && cur == 1) ans++;
        }
        System.out.println(ans);
        sc.close();
    }
}
