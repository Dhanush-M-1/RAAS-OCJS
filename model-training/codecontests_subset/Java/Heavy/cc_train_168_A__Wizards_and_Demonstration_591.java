import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class solution {
    public static void merge(long arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        long L[] = new long[n1];
        long R[] = new long[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }


        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(long arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public static boolean check(int n) {
        String s = "";
        s += n;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '4' && s.charAt(i) != '7') {
                return false;
            }
        }
        return true;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static long findTrailingZeros(long n) {
        // Initialize result
        long count = 0;

        // Keep dividing n by powers
        // of 5 and update count
        for (long i = 5; n / i >= 1; i *= 5)
            count += n / i;

        return count;
    }

    public static int ceilSearch(long arr[], int low, int high, long x) {
        int mid;

        if (x <= arr[low])
            return low;
        if (x > arr[high])
            return -1;


        mid = (low + high) / 2;

        if (arr[mid] == x)
            return mid;


        else if (arr[mid] < x) {
            if (mid + 1 <= high && x <= arr[mid + 1])
                return mid + 1;
            else
                return ceilSearch(arr, mid + 1, high, x);
        } else {
            if (mid - 1 >= low && x > arr[mid - 1])
                return mid;
            else
                return ceilSearch(arr, low, mid - 1, x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       long n = Long.parseLong(st.nextToken());
       long x = Long.parseLong(st.nextToken());
       long y = Long.parseLong(st.nextToken());
       long r = (long)Math.ceil((double) (y*n)/100);
       long ans = Math.max(0,r-x);
        System.out.println(ans);
    }
}