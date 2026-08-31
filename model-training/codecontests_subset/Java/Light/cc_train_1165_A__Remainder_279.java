import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        char[] s = sc.next().toCharArray();
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Character.getNumericValue(s[i]);
        }

        int change = 0;

        for (int i = n - 1; i > n - 1 - x; i--) {
            if (num[i] != 0) {
                change++;
            }
        }

        if (num[n - 1 - y] == 1) {
            change--;
        } else {
            change++;
        }

        System.out.println(change);
    }
}
