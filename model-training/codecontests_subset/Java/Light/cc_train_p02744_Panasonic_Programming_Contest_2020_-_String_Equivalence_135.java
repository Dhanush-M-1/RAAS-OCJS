import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = 0;
        }
        if(n==1) {
            System.out.println("a");
            return;
        }
        rec(a, 1);
    }
    public static void rec(int[] a, int from) {
        int max = a[0];
        for(int i=1; i<from; i++) {
            max = Math.max(max, a[i]);
        }
        for(int i=0; i<=max+1; i++) {
            a[from] = i;
            if(from==a.length-1) {
                output(a);
            }
            else {
                rec(Arrays.copyOf(a, a.length), from+1);
            }
        }
    }
    public static void output(int[] a) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<a.length; i++) {
            sb.append((char)('a'+a[i]));
        }
        System.out.println(sb.toString());
    }
}
