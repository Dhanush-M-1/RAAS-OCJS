import java.util.ArrayList;
import java.util.Scanner;

class D {
    static class E {
        final int to;
        final int d;

        public E(int to, int d) {
            this.to = to;
            this.d = d;
        }
    }

    static class V extends ArrayList<E> {
    }

    public static void main(String... args) {
        final Scanner sc = new Scanner(System.in);
        final int N = sc.nextInt();
        final int M = sc.nextInt();
        final int[] L = new int[M];
        final int[] R = new int[M];
        final int[] D = new int[M];
        for (int i = 0; i < M; i++) {
            L[i] = sc.nextInt() - 1;
            R[i] = sc.nextInt() - 1;
            D[i] = sc.nextInt();
        }
        final V[] vs = new V[N];
        for (int i = 0; i < N; i++)
            vs[i] = new V();
        for (int i = 0; i < M; i++) {
            vs[L[i]].add(new E(R[i], D[i]));
            vs[R[i]].add(new E(L[i], -D[i]));
        }
        final boolean[] visited = new boolean[N];
        final int[] ds = new int[N];
        boolean success = true;
        for (int i = 0; i < N && success; i++)
            if (!visited[i]) {
                visited[i] = true;
                success &= check(i, vs, visited, ds);
            }
        System.out.println(success ? "Yes" : "No");
    }

    static boolean check(int idx, V[] vs, boolean[] visited, int[] ds) {
        for (final E e : vs[idx])
            if (visited[e.to]) {
                if (ds[idx] + e.d != ds[e.to])
                    return false;
            } else {
                visited[e.to] = true;
                ds[e.to] = ds[idx] + e.d;
                if (!check(e.to, vs, visited, ds))
                    return false;
            }
        return true;
    }
}
public class Main {
    public static void main(String... args) {
        D.main(args);
    }
}