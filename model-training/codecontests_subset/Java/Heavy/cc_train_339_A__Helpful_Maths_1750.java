import java.util.*;

public class P150906_339A {

    public static <T extends Comparable<T>> void sortQuickSort(T[] a, int l, int r) {
        if (l >= r) return;
        T pivot = a[l + (r - l) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (a[i].compareTo(pivot) < 0) i++;
            while (a[j].compareTo(pivot) > 0) j--;
            if (i <= j) {
                T tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++; j--;
            }
        }

        sortQuickSort(a, l, j);
        sortQuickSort(a, i, r);

    }
    public static <T extends Comparable<T>> void sortInsertionSort(T[] a, int l, int r) {
        for(int i = l + 1; i <= r; i++) {
            T c = a[i];
            int cIndex = i;
            while (cIndex > l && a[cIndex - 1].compareTo(c) > 0 ) cIndex--;
            for(int j = i; j > cIndex; j--) a[j] = a[j - 1];
            a[cIndex] = c;
        }

    }
    public static <T extends Comparable<T>> void sortBubbleSort(T[] a, int l, int r) {
        for(int i = l; i <= r; i++)
            for(int j = l; j < r; j++)
                if (a[j].compareTo(a[j + 1]) > 0) {
                    T tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tmp = scanner.nextLine().split("\\+");
        int N = tmp.length;
        Integer[] a = new Integer[N];
        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(tmp[i]);
        }

        sortQuickSort(a, 0, N - 1);
        for(int i = 0; i < N; i++) {
            if (i > 0) System.out.print("+");
            System.out.print(a[i]);
        }
    }
}
