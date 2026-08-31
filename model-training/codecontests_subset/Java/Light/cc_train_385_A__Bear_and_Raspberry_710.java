import java.util.*;

public class BearSaving {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < n - 1; i++)
            arr[i] -= arr[i + 1];
        int max = arr[0];
        for (int i = 1; i < n - 1; i++)
            if (arr[i] > max)
                max = arr[i];
        max -= c;
        if (max <= 0)
            System.out.println("0");
        else
            System.out.println(max);
    }
}