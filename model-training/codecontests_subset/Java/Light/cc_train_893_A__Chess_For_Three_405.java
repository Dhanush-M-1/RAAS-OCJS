import java.util.Scanner;

public class p123A{
    static  int MOD=998244353 ;
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
    int x=3;
    for (int i=0;i<n;i++) {
        int w = sc.nextInt();
        if (x == w) {
            System.out.println("NO");
            return;
        }
        x = 6 - w - x;
    }

            System.out.println("YES");


    }
}