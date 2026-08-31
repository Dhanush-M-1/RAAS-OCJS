import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();   
            a[i][1] = sc.nextInt();   
        }

        int[][] b = new int[m][2];
        for (int i = 0; i < m; i++) {
            b[i][0] = sc.nextInt();   
            b[i][1] = sc.nextInt();   
        }

        for (int i = 0; i < n; i++) {
            int min = 1000000000;
            int index = -1;
            for (int j = 0; j < m; j++) {
                int dist = Math.abs(a[i][0] - b[j][0]) + Math.abs(a[i][1] - b[j][1]);
                if (dist < min) {
                    min = dist;
                    index = j;
                }
            }
            System.out.println(index + 1);
        }

    }
}
