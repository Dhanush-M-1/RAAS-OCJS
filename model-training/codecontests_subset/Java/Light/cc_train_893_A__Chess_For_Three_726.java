import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = 3;
        int[] x = new int[n + 5];
        for(int i = 1; i <= n; i++) {
            x[i] = in.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            if(x[i] == c) {
                System.out.println("NO");
                System.exit(0);
            }
            c = 6 - x[i] - c;
        }
        System.out.println("YES");
    }
}