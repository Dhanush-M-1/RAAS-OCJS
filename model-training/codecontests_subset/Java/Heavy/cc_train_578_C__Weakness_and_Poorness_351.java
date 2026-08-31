import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solver solver = new Solver();
        solver.solve();
    }
}

class Solver {
    Scanner stdin = new Scanner(System.in);
    
    final int MAXN = 200010;
    int[] a = new int[MAXN];
    final double INF = 1e6;
    final double EPS = 1e-8;
    final int TIME = 100;
    
    double poorness(int n, double x) {
        double sum = 0.0;
        double max = 0.0; // careful
        double min = 0.0; // careful
        double res = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += a[i] - x;
            res = Math.max(res, Math.abs(sum - max));
            res = Math.max(res, Math.abs(sum - min));
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        return res;
    }
    
    void solve() {
        int n = stdin.nextInt();
        for (int i = 1; i <= n; i++)
            a[i] = stdin.nextInt();
        double L = -INF;
        double R = INF;
        for (int i = 0; i < TIME; i++) {
            double len = (R - L) / 3.0;
            double p = L + len;
            double q = R - len;
            if (poorness(n, p) > poorness(n, q))
                L = p;
            else R = q;
        }
        System.out.println(poorness(n, L));
    }
}