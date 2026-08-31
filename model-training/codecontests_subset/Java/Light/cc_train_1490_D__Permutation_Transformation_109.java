import java.util.*;

public class CodeForces1490D{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            int[] d = new int[n];
            fill(arr, d, 0, n, 0);
            for (int i = 0; i < n; i++) {
                System.out.print((i == 0 ? "" : " ") + d[i]);
            }
            System.out.println();
        }
    }
    public static void fill(int[] arr, int[] d, int l, int r, int depth) {
        if (l >= r) {
            return;
        }
        int max = l;
        for (int i = l; i < r; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        d[max] = depth;
        fill(arr, d, l, max, depth + 1);
        fill(arr, d, max + 1, r, depth + 1);
    } 
}