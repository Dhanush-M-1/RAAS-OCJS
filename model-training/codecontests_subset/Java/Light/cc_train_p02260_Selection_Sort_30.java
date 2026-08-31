import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i; j < n; j++) {
                if (a[index] > a[j])
                    index = j;
            }
            if (index != i) {
                int min = a[index];
                a[index] = a[i];
                a[i] = min;
                cnt++;
            }
        }

        for (int i = 0; i < n-1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(a[n-1]);
        System.out.println(cnt);
    }
}

