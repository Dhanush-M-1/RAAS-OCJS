import java.util.Scanner;

public class Paths {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        if (k < n + 1 || n==4) {
            System.out.println(-1);
            return;
        }
        int[] x = new int[n + 1];
        x[1] = a;
        x[2] = c;
        x[n - 1] = d;
        x[n] = b;
        for (int i = 3, idx=1; i < n - 1; i++) {
            while (idx == a || idx == b || idx == c || idx == d)
                idx++;
            x[i] = idx;
            idx++;
        }
        for(int i=1;i<=n;i++){
            System.out.print(x[i] + " ");
        }
        System.out.println();
        
        System.out.print(x[2] + " ");
        System.out.print(x[1] + " ");
        for(int i=3;i<n-1;i++){
            System.out.print(x[i] + " ");
        }
        System.out.print(x[n] + " ");
        System.out.print(x[n-1] + " ");
    }

}
