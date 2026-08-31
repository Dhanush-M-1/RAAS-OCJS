import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] aa = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] cc = br.readLine().toCharArray();
            for (int j = 0; j < n / 4; j++) {
                char c = cc[j];
                int a = c >= 'A' ? c - 'A' + 10 : c - '0';
                for (int h = 0; h < 4; h++) {
                    aa[i][j * 4 + h] = (a >> (3 - h)) & 1;
                }
            }
        }
        int[][] res = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 || j==0) res[i][j] = 1;
                else {
                    if (aa[i][j]!=aa[i-1][j] || aa[i][j]!=aa[i][j-1]) {
                        res[i][j] = 1; continue;
                    }
                    int x = Math.min(res[i-1][j], res[i][j-1]);
                    if (aa[i][j]!=aa[i-x][j-x]) {
                        res[i][j] = x; continue;
                    }
                    res[i][j] = x + 1;
                }
            }
        }
        for (int i=n; i>1; i--) {
            if (n%i!=0) continue;
            boolean mark = true;
            breakpoint: for (int j=i-1; j<n; j+=i) {
                for (int k=i-1; k<n; k+=i) {
                    if (res[j][k]<i) {
                        mark = false;
                        break breakpoint;
                    }
                }
            }
            if (mark) {
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(1);
    }
}