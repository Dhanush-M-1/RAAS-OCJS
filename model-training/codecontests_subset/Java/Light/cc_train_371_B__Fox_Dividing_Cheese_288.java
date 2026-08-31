
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(cf(a,b));
    }

    private static int cf(int a, int b) {
        int a2 = 0, a3 = 0, a5 = 0, b2 = 0, b3 = 0, b5 = 0;
        while (a % 2 == 0) {
            a/=2;a2++;
        }
        while (a % 3 == 0) {
            a/=3;a3++;
        }
        while (a % 5 == 0) {
            a/=5;a5++;
        }
        while (b % 2 == 0) {
            b/=2;b2++;
        }
        while (b % 3 == 0) {
            b/=3;b3++;
        }
        while (b % 5 == 0) {
            b/=5;b5++;
        }
        if (a!=b)return -1;
        return Math.abs(a2 - b2) + Math.abs(a3 - b3) + Math.abs(a5 - b5);
    }
    private static long pow2(int i) {
        long ans =1;
        long two = 2;
        while (i > 0) {
            if (i%2==1)ans*=two;
            two *= two;
            i /= 2;
        }
        return ans;
    }

    private static void printArray(int[] arr, int startPosition, int toPosition) {
        for (int i = startPosition; i <= toPosition; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
