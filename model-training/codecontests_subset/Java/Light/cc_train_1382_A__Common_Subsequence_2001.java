
import java.util.Scanner;

public class A {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++) {
           solve(sc);
        }
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[1001];
        int[] b = new int[1001];

        for(int i=0; i<n; i++) {
            int num = sc.nextInt();
            a[num]++;
        }
        for(int i=0; i<m; i++) {
            int num = sc.nextInt();
            b[num]++;
        }
        for(int i=1; i<=1000; i++) {
            if(a[i]>0 && b[i]>0) {
                System.out.println("YES");
                System.out.println("1 " + i);
                return;
            }
        }
        System.out.println("NO");

    }

}