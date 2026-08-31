import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0 ; i < n ; i++) {
            a[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0 ; i < n - 1 ; i++) {
            if (a[i] == i + 1) {
                count++;
                a[i + 1] = a[i];
            }
        }

        if (a[n - 1] == n) {
            count++;
        }
        System.out.println(count);
    }

}