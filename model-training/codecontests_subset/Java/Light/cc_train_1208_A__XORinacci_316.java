// https://codeforces.com/problemset/problem/1208/A
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            if (a == 0 && b == 0) {
                System.out.println(a);
            } else {
                f_1(a, b, n);
            }
        }

    }
    
    public static void f_1(int a, int b, int n) {
        int value = 0;
        int p_1 = a;
        int p_2 = b;
        if (n == 0) {
            value = a;
        } else if (n == 1) {
            value = b;
        } else {
            int c = a ^ b;

            int temp = n / 3;
            int temp1 = n - temp * 3;

            if (temp1 == 1) {
                value = b;
            } else if (temp1 == 2) {
                value = c;
            } else {
                value = a;
            }
        }

        System.out.println(value);
    } 
}
