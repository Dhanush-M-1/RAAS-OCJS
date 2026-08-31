import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] array = new int[n][2];
        int[][] arrayC = new int[m][2];
        for (int i=0; i<n; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        for (int i=0; i<m; i++) {
            arrayC[i][0] = sc.nextInt();
            arrayC[i][1] = sc.nextInt();
        }
        for (int i=0; i<n; i++) {
            int x = array[i][0];
            int y = array[i][1];
            double min = Math.pow(10,8)*2;
            int minP = 0;
            for (int j=0; j<m; j++) {
                if (min > Math.abs(arrayC[j][0] - x) + Math.abs(arrayC[j][1]-y)) {
                    min = Math.abs(arrayC[j][0] - x) + Math.abs(arrayC[j][1]-y);
                    minP = j;
                }
            }
            System.out.println(minP +1);
        }

    }
}