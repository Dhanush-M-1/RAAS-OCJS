import java.util.Scanner;

public class PermutationTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            t--;
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            setDepth(0, n - 1, 0, a);
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void setDepth(int l, int r, int depth, int[] a) {
        if (l == r) {
            a[l] = depth;
            return;
        }
        if (l > r) {
            return;
        }
        int maxInd = l;
        for (int i = l; i <= r; i++) {
            if (a[i] > a[maxInd]) {
                maxInd = i;
            }
        }
        // System.out.println(a[maxInd] + " " + l + " " + r);
        a[maxInd] = depth;
        setDepth(l, maxInd - 1, depth + 1, a);
        setDepth(maxInd + 1, r, depth + 1, a);
    }

}