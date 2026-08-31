import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = scanner.nextInt();
            }
            int cnt = n / 2;
            while (cnt > 0 && a[cnt] == a[cnt - 1]) {
                cnt--;
            }
            if (cnt == 0) {
                System.out.println("0 0 0");
                continue;
            }
            int g = 1;
            while (g < cnt && a[g - 1] == a[g]) {
                ++g;
            }
            int s = g + 1;
            while (g + s < cnt && a[g + s - 1] == a[g + s]) {
                ++s;
            }
            int b = cnt - g - s;
            if (b > g) {
                System.out.println(g + " " + s + " " + b);
            } else {
                System.out.println("0 0 0");
            }
        }
    }

}