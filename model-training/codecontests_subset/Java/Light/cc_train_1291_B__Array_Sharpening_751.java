import java.util.Scanner;

public class ArraySharpening {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();
            int prefixEnd = -1, suffixEnd = n;
            for (int i = 0; i < n; i++) {
                if (a[i] < i)
                    break;
                prefixEnd = i;
            }
            for (int i = n - 1; i >= 0; i--) {
                if (a[i] < (n - i - 1))
                    break;
                suffixEnd = i;
            }
            if (suffixEnd <= prefixEnd)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
