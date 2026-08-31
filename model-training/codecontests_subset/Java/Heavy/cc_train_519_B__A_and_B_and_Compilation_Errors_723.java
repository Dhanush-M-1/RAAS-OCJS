import java.util.Arrays;
import java.util.Scanner;

public class b {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numE = in.nextInt();
        int a[] = new int[numE];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }

        int b[] = new int[numE - 1];
        for (int i = 0; i < b.length; i++)
            b[i] = in.nextInt();

        int c[] = new int[numE - 2];
        for (int i = 0; i < c.length; i++)
            c[i] = in.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int print1 = -1;
        for (int i = 0; i < b.length; i++) {
            if (a[i] != b[i]) {
                print1 = i;
                break;
            }
        }
        int print2 = -1;
        for (int i = 0; i < c.length; i++) {
            if (b[i] != c[i]) {
                print2 = i;
                break;
            }
        }
        if (print1 == -1)
            print1 = a.length - 1;
        if (print2 == -1)
            print2 = b.length - 1;
        System.out.println(a[print1]);
        System.out.println(b[print2]);

        in.close();

    }
}