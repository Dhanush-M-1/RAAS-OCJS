import java.util.*;

public class _1037B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);
        long res = Math.abs(s - arr[n / 2]);
        if (s <= arr[n / 2]) {
            for (int i = 0; i < n / 2; i++) 
                res += Math.max(arr[i] - s, 0);
        } else {
            for (int i = n / 2 + 1; i < n; i++)
                res += Math.max(s - arr[i], 0);
        }
        System.out.println(res);
    }
}
