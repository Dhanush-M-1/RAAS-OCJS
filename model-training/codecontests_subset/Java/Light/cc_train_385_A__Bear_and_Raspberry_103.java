import java.util.Scanner;

public class Main {

    public static void solve(int n,int[] a,int c){

        int d = 0;
        for (int i = 0; i < n-1; i++) {
            if(a[i]>a[i+1] && d < a[i]-a[i+1]){
                d = a[i]-a[i+1];
            }
        }
        System.out.println(Math.max(d - c, 0));
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        solve(n,a,c);
    }
}
