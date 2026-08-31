

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String[] input;
        while (T-- > 0) {
            input = br.readLine().split(" ");
            input = br.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int m = Integer.parseInt(input[2]);
            int[] a = new int[n];
            input = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(input[i]);
            int[] b = new int[m];
            input = br.readLine().split(" ");
            for (int i = 0; i < m; i++)
                b[i] = Integer.parseInt(input[i]);
            boolean possible = true;
            int[] res = new int[n + m];
            int index = 0;
            int lines = k;
            int ai = 0, bi = 0;
            while (ai < n && bi < m) {
                int nexta = a[ai];
                int nextb = b[bi];
                if (nexta == 0) {
                    res[index] = a[ai];
                    index++;
                    ai++;
                    lines++;
                } else if (nextb == 0) {
                    res[index] = b[bi];
                    index++;
                    bi++;
                    lines++;
                } else {
                    if (nexta < nextb && nexta <= lines) {
                        res[index] = a[ai];
                        index++;
                        ai++;
                    } else if (nextb <= lines) {
                        res[index] = b[bi];
                        index++;
                        bi++;
                    } else {
                        possible = false;
                        break;
                    }
                }
            }
            if (possible) {
                while (ai < n) {
                    int next = a[ai];
                    if (next == 0) {
                        res[index] = a[ai];
                        index++;
                        ai++;
                        lines++;
                    } else if (next <= lines) {
                        res[index] = a[ai];
                        index++;
                        ai++;
                    } else {
                        possible = false;
                        break;
                    }
                }
                while (possible && bi < m) {
                    int next = b[bi];
                    if (next == 0) {
                        res[index] = b[bi];
                        index++;
                        bi++;
                        lines++;
                    } else if (next <= lines) {
                        res[index] = b[bi];
                        index++;
                        bi++;
                    } else {
                        possible = false;
                        break;
                    }
                }
            }
            if (possible) {
                for (int i = 0; i < (n + m); i++)
                    sb.append(res[i] + " ");
                sb.append("\n");
            } else {
                sb.append("-1\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
