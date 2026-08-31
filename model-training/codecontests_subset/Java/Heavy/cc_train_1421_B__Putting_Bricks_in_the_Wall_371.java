import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            char[][] matrix = new char[n][n];
            for (int i = 0; i < n; i++) {
                char[] inp = buffer.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = inp[j];
                }
            }
            char a = matrix[0][1], b = matrix[1][0], c = matrix[n - 1][n - 2], d = matrix[n - 2][n - 1];
            if (a == '0' && b == '0') {
                if (c == '1' && d == '1') {
                    sb.append(0 + "\n");
                } else if ((c == '1' || d == '1') && (c == '0' || d == '0')) {
                    sb.append(1 + "\n");
                    if (c == '0')
                        sb.append(n + " " + (n - 1) + "\n");
                    else
                        sb.append((n - 1) + " " + n + "\n");
                } else if (c == '0' && d == '0') {
                    sb.append(2 + "\n");
                    sb.append(n + " " + (n - 1) + "\n");
                    sb.append((n - 1) + " " + n + "\n");
                }
            } else if ((a == '1' || b == '1') && (a == '0' || b == '0')) {
                if (c == '1' && d == '1') {
                    sb.append(1 + "\n");
                    if (a == '1')
                        sb.append(1 + " " + 2 + "\n");
                    else
                        sb.append(2 + " " + 1 + "\n");
                } else if ((c == '1' || d == '1') && (c == '0' || d == '0')) {
                    sb.append(2 + "\n");
                    if (a == '1') {
                        sb.append(1 + " " + 2 + "\n");
                    } else {
                        sb.append(2 + " " + 1 + "\n");
                    }
                    if (c == '0')
                        sb.append(n + " " + (n - 1) + "\n");
                    else
                        sb.append((n - 1) + " " + n + "\n");

                } else if (c == '0' && d == '0') {
                    sb.append(1 + "\n");
                    if (a == '0')
                        sb.append(1 + " " + 2 + "\n");
                    else
                        sb.append(2 + " " + 1 + "\n");
                }
            } else if (a == '1' && b == '1') {
                if (c == '1' && d == '1') {
                    sb.append(2 + "\n");
                    sb.append(n + " " + (n - 1) + "\n");
                    sb.append((n - 1) + " " + n + "\n");
                } else if ((c == '1' || d == '1') && (c == '0' || d == '0')) {
                    sb.append(1 + "\n");
                    if (c == '1')
                        sb.append(n + " " + (n - 1) + "\n");
                    else
                        sb.append((n - 1) + " " + n + "\n");
                } else if (c == '0' && d == '0') {
                    sb.append(0 + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
