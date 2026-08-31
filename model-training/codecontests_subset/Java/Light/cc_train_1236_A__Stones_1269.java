import java.util.Scanner;

public class Rocks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arrSum = new int[n];
        for(int i = 0; i < n; i++) {
            int l = in.nextInt();
            int m = in.nextInt();
            int r = in.nextInt();
            int sum = 0;

            while (m > 0 && r > 1) {
                m--;
                r -= 2;
                sum += 3;
            }
            while (l > 0 && m > 1) {
                l--;
                m -= 2;
                sum += 3;
            }
            arrSum[i] = sum;
        }
        for(int i = 0; i < n; i++){
            System.out.println(arrSum[i]);
        }
    }
}
