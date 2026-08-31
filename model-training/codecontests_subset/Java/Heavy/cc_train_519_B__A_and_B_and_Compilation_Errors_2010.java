import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n - 1];
        int[] c = new int[n - 2];

        int firstError = 0;
        int secondError = 0;

        for (int i = 0; i < a.length; ++i) a[i] = in.nextInt();
        for (int i = 0; i < b.length; ++i) b[i] = in.nextInt();
        for (int i = 0; i < c.length; ++i) c[i] = in.nextInt();

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        for(int i = 0; i < a.length; ++i) {
            if(i == b.length) firstError = a[i];
            else {
                if(a[i] != b[i]) {
                    firstError = a[i];
                    break;
                }
            }
        }

        for(int i = 0; i < b.length; ++i) {
            if(i == c.length) secondError = b[i];
            else {
                if(b[i] != c[i]) {
                    secondError = b[i];
                    break;
                }
            }
        }

        System.out.println(firstError);
        System.out.println(secondError);
    }
}