import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Tasks {

    public static Scanner sc = null;

    public static void Cal(int l, int r, int[] a, int[] res, int cnt) {
        if (l > r) return;
        int pos = 0, ans = 0;
        for (int i = l; i <= r; ++ i) {
            if (a[i] > ans) {
                ans = a[i];
                pos = i;
            }
        }
        res[pos] = cnt;
        Cal(l, pos - 1, a, res, cnt + 1);
        Cal(pos + 1, r, a, res, cnt + 1);
    }

    public static void Solve(int test_case) {
        int n = sc.nextInt();
        int[] a = new int[105];
        int[] res = new int[105];
        for (int i = 1; i <= n; ++ i) {
            a[i] = sc.nextInt();
        }
        Cal(1, n, a, res, 0);
        for (int i = 1; i <= n; ++ i) {
            System.out.print(res[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        try {
            File file = new File("E:\\PCONHA\\Viet\\Java\\Tasks\\Tasks.txt");
            sc = new Scanner(file);
        }
        catch(Exception ex) {
            sc = new Scanner(System.in);
        }
        int test_case = 1;
        test_case = sc.nextInt();
        for (int i = 1; i <= test_case; ++ i) {
            Solve(test_case);
        }
    }
}
