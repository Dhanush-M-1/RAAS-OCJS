import java.util.Scanner;

public class Prog1334A{
    static Scanner sc = new Scanner(System.in);
    private static void solve(){
        int n = sc.nextInt();
        int[] p = new int[n];
        int[] c = new int[n];
        for (int i = 0 ; i < n ; i++){
            p[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }
        boolean found = false;
        for (int i = 0 ; i < n ; i++){
            if (c[i] > p[i]){
                found = true;
                System.out.println("NO");
                break;
            }
            else if (i > 0 && (p[i] < p[i-1] || c[i] < c[i-1])){
                found = true;
                System.out.println("NO");
                break;
            }
            else if (i > 0 && (p[i] - p[i-1] < c[i] - c[i-1])){
                found = true;
                System.out.println("NO");
                break;
            }
        }
        if (!found){
            System.out.println("YES");
        }
    }
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t > 0){
            solve();
            t--;
        }
        sc.close();
    }
}