import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class T_519B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n - 1];
        int[] c = new int[n - 2];
        
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        
        for (int i = 0; i < n - 1; i++) {
            b[i] = in.nextInt();
        }
        
        for (int i = 0; i < n - 2; i++) {
            c[i] = in.nextInt();
        }      
        in.close();
        safeSort(a);
        safeSort(b);
        safeSort(c);
        
        int first = -1, second = -1;
        
        for (int i = 0; i < n - 1; i++) {
            if (b[i] != a[i]) {
                first = a[i];
                break;
            }
        }
        if (first == -1)
            first = a[n - 1];
        System.out.println(first);
        
        for (int i = 0; i < n - 2; i++) {
            if (c[i] != b[i]) {
                second = b[i];
                break;
            }
        }
        if (second == -1)
            second = b[n - 2];
        System.out.println(second);
    }
    
    private static void safeSort(int[] a) {
        int n = a.length;
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int tmp = a[i];
            int idx = rnd.nextInt(n - i) + i;
            a[i] = a[idx];
            a[idx] = tmp;
        }
        Arrays.sort(a);
    }
}
