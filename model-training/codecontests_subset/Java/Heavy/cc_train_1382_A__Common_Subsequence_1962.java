import java.util.Scanner;

public class Solution{

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++){
            solve(s);
        }
    }

    public static void solve(Scanner s){
        int n = s.nextInt();
        int m = s.nextInt();

        int a[] = new int[n];
        int b[] = new int[m];
        for (int i = 0; i < n; i++){
            a[i] = s.nextInt();
        }
        for (int i = 0; i < m; i++){
            b[i] = s.nextInt();
        }

        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (a[i] == b[j]) {
                    System.out.println("YES");
                    System.out.println(1 +  " " + a[i]);
                    return;
                }
            }
        }
        System.out.println("NO");
        return;
    }

}