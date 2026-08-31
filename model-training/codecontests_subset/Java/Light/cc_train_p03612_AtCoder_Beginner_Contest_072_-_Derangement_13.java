import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            int x = i+1;
            if(a[i] == x){
                int y = a[i+1];
                a[i+1] = a[i];
                a[i] = y;
                ans++;
            }
        }
        if(a[n-1] == n)ans++;
        System.out.println(ans);
        sc.close();

    }

}
