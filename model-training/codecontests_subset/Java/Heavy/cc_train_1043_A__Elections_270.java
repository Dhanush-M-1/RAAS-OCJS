import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskA Solver = new TaskA();
        Solver.Solve();
    }
    private static class TaskA {
        private void Solve() {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int ar[] = new int[n];
            int max = 0, sum1 = 0;
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
                sum1 += ar[i];
                max = Math.max(max, ar[i]);
            }
            int k = max;
            while (true) {
                int sum2 = 0;
                for (int i = 0; i < n; i++)
                    sum2 += (k - ar[i]);
                if (sum2 > sum1) {
                    System.out.println(k);
                    return;
                }
                k++;
            }
        }
    }
}