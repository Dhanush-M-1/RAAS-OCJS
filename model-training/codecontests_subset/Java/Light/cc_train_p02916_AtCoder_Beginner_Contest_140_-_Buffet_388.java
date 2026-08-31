import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int[][] arr = new int[3][n];
        label:
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 2 && j == n-1) break label;
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n - 1; i++)
            ans += arr[1][arr[0][i] - 1]
                    + (arr[0][i + 1] - arr[0][i] == 1 ? arr[2][arr[0][i] - 1] : 0);
        ans += arr[1][arr[0][n-1] - 1];
        System.out.println(ans);
    }
}
