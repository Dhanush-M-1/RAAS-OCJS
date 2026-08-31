import java.util.*;

public class Main {


    public static int calcSum(int[] ar, int n) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += ar[i];
        }

        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a;

        int arr0[] = new int[n];
        int arr1[] = new int[n];

        int i0 = 0, i1 = 0;

        for (int i = 0; i < n; i++) {
            a = sc.nextInt();

            if ((a & 1) == 0) arr0[i0++] = a;
            else arr1[i1++] = a;
        }

        Arrays.sort(arr0, 0, i0);
        Arrays.sort(arr1, 0, i1);

        if (i0 >= i1) {
            int d = i0 - i1 - 1;
            System.out.println(calcSum(arr0, d));
        }
        else {
            int d = i1 - i0 - 1;
            System.out.println(calcSum(arr1, d));
        }
    }
}
