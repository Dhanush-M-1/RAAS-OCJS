import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < m; i++){
            b[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            b[a[i] - 1]++;
        }
        for (int i = 0; i < m; i++){
            for(int j = i + 1; j < m; j++) {
                k += b[i] * b[j];
            }
        }
        System.out.println(k);
    }
}