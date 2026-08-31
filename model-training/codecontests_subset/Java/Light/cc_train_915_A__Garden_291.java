import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        int hour = 100000000;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (k % a[i] == 0 && k / a[i] < hour) {
                hour = k / a[i];
            }
        }
        System.out.print(hour);

    }
}
