import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class C361C {
    private static final int MAX_VALUE = 1000000000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] ops = new int[m + 1][5];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= 4; j++) {
                ops[i][j] = sc.nextInt();
            }
        }
        sc.close();

        PrintWriter out = new PrintWriter(System.out);
        Optional<int[]> result = solve(n, ops);
        if (result.isPresent()) {
            out.println("YES");
            out.println(Arrays.toString(result.get()).replaceAll("\\[|\\]|,", ""));
        } else {
            out.println("NO");
        }
        out.close();
    }

    private static Optional<int[]> solve(int n, int[][] ops) {
        int[] a = new int[n + 1];
        Arrays.fill(a, MAX_VALUE);
        for (int i = ops.length - 1; i >= 1; i--) {
            if (ops[i][1] == 1) {
                for (int l = ops[i][2]; l <= ops[i][3]; l++) {
                    if (a[l] != MAX_VALUE) {
                        a[l] -= ops[i][4];
                    }
                }
            } else {
                for (int l = ops[i][2]; l <= ops[i][3]; l++) {
                    if (a[l] > ops[i][4]) {
                        a[l] = ops[i][4];
                    }
                }
            }
        }

        int[] b = Arrays.copyOf(a, n + 1);
        boolean valid = true;
        for (int i = 1; i < ops.length; i++) {
            if (ops[i][1] == 1) {
                for (int l = ops[i][2]; l <= ops[i][3]; l++) {
                    b[l] += ops[i][4];
                }
            } else {
                int max = -MAX_VALUE;
                for (int l = ops[i][2]; l <= ops[i][3]; l++) {
                    max = Math.max(max, b[l]);
                }
                if (max != ops[i][4]) {
                    valid = false;
                    break;
                }
            }
        }
        if (valid) return Optional.of(Arrays.copyOfRange(a, 1, n + 1));
        return Optional.empty();
    }
}