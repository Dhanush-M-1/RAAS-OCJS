import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] a = new Integer[n];

        sc.nextLine();
        String line = sc.nextLine();
//        System.out.println(line);
        StringTokenizer st = new StringTokenizer(line, " ");
        for (int i = 0; i < n; ++i) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);


        int l = 0;
        int sum = 0;
        for (int i = 1; i < n; ++i) {
            while (a[i] > a[l]) {
                if (a[i] > a[l] + k)
                    sum += 1;

                l += 1;
            }
        }

        sum += (n - l);

        System.out.println(sum);
    }
}