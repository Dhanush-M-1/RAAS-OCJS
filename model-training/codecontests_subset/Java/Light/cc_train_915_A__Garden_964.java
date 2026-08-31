import java.util.Scanner;

public class Garden {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int max = 0;
        int[] a = new int[n];
        for(int i = 0; i < n; i++) a[i] = s.nextInt();
        for(int i = 0; i < n; i++) {
            if(k % a[i] == 0 && a[i] > max) max = a[i];
        }
        System.out.println(k / max);
    }
}
