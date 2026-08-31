import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        String[][] ans = new String[k][k];
        for (int i = 1; i < k; i++) {
            for (int j = 1; j < k; j++) {
                int val = i * j;
                ans[i][j] = Integer.toString(val, k);
            }
        }
        for (int i = 1; i < k; i++) {
            for (int j = 1; j < k; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
