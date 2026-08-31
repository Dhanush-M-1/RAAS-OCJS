

import java.util.ArrayList;
import java.util.Scanner;

public class D {
    static ArrayList adj[];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int mas[] = new int[n];
        int func[] = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = in.nextInt() - 1;
            func[mas[i]] = i;
        }
        int kek[] = new int[n];
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt() - 1, y = in.nextInt() - 1;
            if (func[x] < func[y]) {
                kek[x]++;
                adj[y].add(x);
            }
        }
        int ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            int tek = mas[i];
            if (kek[tek] == n - 1 - i - ans) {
                ans++;
                for (int j = 0; j < adj[tek].size(); j++) {
                    kek[(int) adj[tek].get(j)]--;
                }
            }
        }
        System.out.println(ans);
    }
}
