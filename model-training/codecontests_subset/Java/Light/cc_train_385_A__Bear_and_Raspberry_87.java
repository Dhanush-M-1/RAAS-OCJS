import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int max = 0;
        for(int i=0; i<n-1; i++) {
            int profit =  a[i] - a[i+1] - c;
            max = Math.max(max, profit);
        }
        System.out.println(max);
    }
}