import java.util.Scanner;

public class Sh1H {

    static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int k = in.nextInt();
        for (int i = 1; i < k; ++i) {
            for (int j = 1; j < k; ++j)
                System.out.print(toK(i * j, k) + " ");
            System.out.println();
        }
    }

    private static int toK(int j, int k) {
        int[] ans = new int[10];
        int l = 0;
        while (j != 0) {
            ans[l++] = j % k;
            j /= k;
        }
        int res = 0;
        for (int i = l - 1; i >= 0; --i)
            res = res * 10 + ans[i];
        return res;
    }
}
