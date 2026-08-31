import java.util.Arrays;
import java.util.Scanner;

public class Codeforces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            String ans = "YES";
            for (int r = 0; r < N; r++) {
                if (arr[r][0] < arr[r][1]) {
                    ans = "NO";
                    break;
                }                
            }
            for (int r = 1; r < N; r++) {
                if (arr[r][0] < arr[r-1][0] || arr[r][1] < arr[r-1][1]) {
                    ans = "NO";
                    break;
                }
                if (arr[r][0] - arr[r-1][0] < (arr[r][1] - arr[r-1][1])) {
                    ans = "NO";
                    break;
                }
            }
            // 3 1
            // 3 2
            System.out.println(ans);
        }
    }
}