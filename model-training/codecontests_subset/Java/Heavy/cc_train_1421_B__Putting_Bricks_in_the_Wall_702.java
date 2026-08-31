import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = sc.nextInt();

            char c[][] = new char[n][];

            for (int i = 0; i < n; i++) {
                String str = sc.next();
                c[i] = str.toCharArray();
            }

            // To check [0][1] [1][0] [n-1][n-2] [n-2][n-1]

            StringBuilder ans = new StringBuilder();

            int count = 0;
            if (c[0][1] != '0') {
                count++;
                ans.append("1 2").append("\n");
            }
            if (c[1][0] != '0') {
                count++;
                ans.append("2 1").append("\n");
            }
            if (c[n - 1][n - 2] != '1') {
                count++;
                ans.append(n + " " + (n - 1)).append("\n");
            }
            if (c[n - 2][n - 1] != '1') {
                count++;
                ans.append((n - 1) + " " + n).append("\n");
            }

            if (count <= 2) {
                sb.append(count).append("\n");
                sb.append(ans);
                continue;
            }

            ans = new StringBuilder();
            count = 0;

            if (c[0][1] != '1') {
                count++;
                ans.append("1 2").append("\n");
            }
            if (c[1][0] != '1') {
                count++;
                ans.append("2 1").append("\n");
            }
            if (c[n - 1][n - 2] != '0') {
                count++;
                ans.append(n + " " + (n - 1)).append("\n");
            }
            if (c[n - 2][n - 1] != '0') {
                count++;
                ans.append((n - 1) + " " + n).append("\n");
            }

            sb.append(count).append("\n");
            sb.append(ans);

        }
        System.out.print(sb);
    }
}