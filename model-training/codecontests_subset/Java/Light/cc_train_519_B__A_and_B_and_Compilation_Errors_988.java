import java.util.Scanner;

public class _519B {
        public static void main(String args[]) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            int[] a = new int[3];
            for(int i = 0; i < 3; i++) for(int j = 0; j < n - i; j++) a[i] += scan.nextInt();
            System.out.println((a[0] - a[1]) + "\n" + (a[1] - a[2]));
        }
    }