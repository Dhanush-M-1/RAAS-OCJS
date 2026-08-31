import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        char[] charS = s.toCharArray();
        int n0 = 0;
        for (char c : charS) {
            if (c == '0') {
                n0++;
            }
        }
        int n1 = n - n0;
        if (n0 == n1) {
            System.out.println(2);
            System.out.print(charS[0]+" ");
            for (int i = 1; i < n; i++) {
                System.out.print(charS[i]);
            }
        } else {
            System.out.println(1);
            System.out.println(s);
        }
    }
}
