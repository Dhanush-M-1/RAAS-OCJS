import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class B1144 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }


        final long even = Arrays.stream(arr).filter(i -> i % 2 == 0).count();
        final long odd = n - even;

        if (Math.abs(even - odd) <= 1) {
            System.out.println(0);
            return;
        }

        Arrays.sort(arr);
        long diff = n - 2 * Math.min(even, odd) - 1;
        IntPredicate filter = even > odd ?
                i -> i % 2 == 0 :
                i -> i % 2 == 1;
        System.out.println(getMaxFiltredItems(arr, filter, diff));
    }

    private static long getMaxFiltredItems(int[] array, IntPredicate filter, long size) {
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (size == 0) break;
            if (filter.test(array[i])) {
                sum += array[i];
                size--;
            }
        }
        return sum;
    }
}
